package init;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    public String value() default "";
}