package ua.procamp.reflection.rules;

import java.lang.annotation.*;

/**
 * Indicates that there is a legal limit on the annotated field. It can have values that exceed the limit, but the excess if of no use legally.
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target(ElementType.FIELD)
public @interface UsageLimit {
    double value();
}
