package valid;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserCheck {
    public static boolean check(User user) {
        if (user == null) {
            System.out.println("！！校验对象为空！！");
            return false;
        }

        // 获取User类的所有属性（如果使用getFields，就无法获取到private的属性）
        Field[] fields = user.getClass().getDeclaredFields();

        try {
            for (Field field : fields) {
                // 如果属性有注解，就进行校验
                if (field.isAnnotationPresent(Validate.class)) {
                    Validate validate = field.getAnnotation(Validate.class);

                    //获取字段的值
                    field.setAccessible(true);
                    String fieldValue = (String) field.get(user);

                    if(fieldValue == null){
                        if (validate.isNotNull()) {
                            System.out.println(validate.isNotNullErrorMsg());
                            return false;
                        }
                    }else{
                        if (fieldValue.length() < validate.min()) {
                            System.out.println(validate.minErrorMsg());
                            return false;
                        }
                        if (fieldValue.length() > validate.max()) {
                            System.out.println(validate.maxErrorMsg());
                            return false;
                        }
                    }
                }
            }
        } catch (SecurityException e) {
            System.err.println("类型转换安全异常: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("访问属性改变错误: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("非法参数: " + e.getMessage());
        }
        return true;
    }
}