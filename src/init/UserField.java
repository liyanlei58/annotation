package init;

public class UserField {

    @Init(value = "liang")
    private String name;

    @Init(value = "23")
    private String age;

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}