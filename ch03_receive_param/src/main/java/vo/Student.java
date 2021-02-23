package vo;

//保存请求参数值的普通类
public class Student {
    //属性名与请求中参数名相同

    private String name;
    private Integer age;

    public Student() {
        System.out.println("Student无参构造方法");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setname = " + name);
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("setAge = " + age);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
