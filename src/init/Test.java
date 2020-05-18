package init;

public class Test {
    public static void main(String[] args) {
        testField();
//        testMethod();
    }

    public static void testMethod(){
        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    public static void testField(){
        UserField user = UserFieldFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

}