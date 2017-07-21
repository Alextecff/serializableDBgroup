import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String surname;
    private boolean sex;
    private int age;
    private int course;

    public Student(String name, String surname, boolean sex, int age, int course) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                '}';
    }
}
