package init;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class UserFieldFactory {
    public static UserField create() {
        UserField userField = new UserField();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Field[] fields = UserField.class.getDeclaredFields();

        try {
            for (Field field : fields) {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (field.isAnnotationPresent(Init.class)) {
                    Init init = field.getAnnotation(Init.class);

                    //设置字段的值
                    field.setAccessible(true);
                    field.set(userField, init.value());

                    //通过method设置字段的值
//                    String fieldName = field.getName();
//                    fieldName = fieldName.replaceFirst(fieldName.substring(0, 1), fieldName.substring(0, 1).toUpperCase());
//                    Method method = UserField.class.getMethod("set" + fieldName, String.class);
//                    method.invoke(userField, init.value());
                }
            }
        } catch (Exception e) {
            System.err.println("发生异常：" + e.getMessage());
            return null;
        }

        return userField;
    }
}