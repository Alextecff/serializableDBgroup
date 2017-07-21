import java.io.Serializable;

public class Group implements Serializable {
    Student[] students = new Student[10];
    private int index;

    public void addStudent(Student student){
        if(students.length == index){
            Student[] students = new Student[this.students.length + 1];
            System.arraycopy(this.students, 0, students, 0, this.students.length);
            this.students = students;
        }
        students[index++] = student;
    }

    public void showStudents(){
        for(Student st : students){
            if(st != null){
                System.out.println(st);
            }
        }
    }
}
