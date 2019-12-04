package ua.kpi.tef.ti71.lab2.rules;

import java.lang.annotation.*;

/**
 * Used to mark that the result of the annotated method should be used as legally binding.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.METHOD)
public @interface LegallyBinding {
}
