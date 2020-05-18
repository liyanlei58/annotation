package valid;

import java.lang.annotation.*;

@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate
{
    public int min() default 1;

    public int max() default 10;

    public boolean isNotNull() default true;

    public String minErrorMsg() default "";

    public String maxErrorMsg() default "";

    public String isNotNullErrorMsg() default "";
}