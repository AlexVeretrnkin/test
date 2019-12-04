package ua.kpi.tef.ti71.lab2.reflection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReflectionUtils {

    private ReflectionUtils() {
    }

    private static Logger logger = LogManager.getLogger();

    public static List<Field> getAllFields(Object object) {
        List<Field> fields = new LinkedList<>();
        Class clazz = object.getClass();
        while (!clazz.equals(Object.class)) {
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        return fields;
    }

    public static List<Method> getAllMethods(Object object) {
        List<Method> methods = new LinkedList<>();
        Class clazz = object.getClass();
        while (!clazz.equals(Object.class)) {
            methods.addAll(Arrays.asList(clazz.getMethods()));
            clazz = clazz.getSuperclass();
        }
        return methods;
    }

    public static <T> List<Class<? super T>> getAllInterfaces(Object object) {
        List<Class<? super T>> superInterfaces = new LinkedList<>();
        Class clazz = object.getClass();
        while (!clazz.equals(Object.class)) {
            if (clazz.getInterfaces().length != 0) {
                for (Class superInterface : clazz.getInterfaces()) {
                    superInterfaces.add((Class<? super T>) superInterface);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return superInterfaces;
    }


    public static void printAllFieldsWithTheirTypesAndAnnotations(Object object) {
        for (Field field : getAllFields(object)) {
            logger.info("Field: " + field.getName() + " type: " + field.getType());

            for (Annotation annotation : field.getDeclaredAnnotations()) {
                String res = annotation.toString();
                logger.info("    annotation: {}", res);
            }

        }
    }

    public static void invokeAllAnnotatedMethods(Object object) {
        for (Method method : getAllMethods(object)) {
            if ((method.getDeclaredAnnotations().length > 0) && (method.getParameterTypes().length == 0)) {
                method.setAccessible(true);

                try {
                    method.invoke(object);

                    logger.info(method.getName() + " invoked successfully");
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

    public static String getName(Object object) {
        return object.getClass().getSimpleName();
    }

    public static List<String> getInterfaceNames(Object object) {
        List<String> interfaceNames = new LinkedList<>();

        for (Class clazz : getAllInterfaces(object)) {
            interfaceNames.add(clazz.getSimpleName());
        }

        return interfaceNames;
    }


    public static Object getProxy(Object object) {
        Class clazz = getAllInterfaces(object).get(0);

        return Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new CustomInvocationHandler(object));
    }
}
