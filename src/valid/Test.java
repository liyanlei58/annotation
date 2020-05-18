package valid;

public class Test {
    public static void main(String[] args) {
        User user = new User();

        user.setName("pff");
//        user.setAge("1");

        System.out.println(UserCheck.check(user));
    }
}