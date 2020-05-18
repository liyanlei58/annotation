package valid;

public class User {
    @Validate(min = 2, minErrorMsg = "名字最小长度校验不通过！", max = 5, maxErrorMsg = "名字最大长度校验不通过！", isNotNullErrorMsg = "年龄不能为空")
    private String name;

    @Validate(isNotNull = false)
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