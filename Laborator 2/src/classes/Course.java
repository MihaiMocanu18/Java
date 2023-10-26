package classes;
public class Course {
    private  String name;
    private  String description;
    private  Professor teacher;
    private  Student[] students;

    public Course(String name, String description, Professor teacher, Student[] students) {
        this.name = name;
        this.description = description;
        this.teacher = teacher;
        this.students = students;
    }

    public void addStudent(Student student) {
    Professor prof = new Professor("Danciu", "Gabriel");
    Student student1 = new Student("Mocanu","Mihai",1234);
    Student student2 = new Student("Mocanu", "Miha" , 1243);
    Course course = new Course("Laboratorul 2" , "Object Oriented",prof, new Student[]{student1,student2});
    }

    public String getName() {
        return name;
    }

    public String toString() {
    StringBuilder courseInfo = new StringBuilder();
    courseInfo.append("Couse: ").append(name).append("\n");
    courseInfo.append("Description: ").append(description).append("\n");
    courseInfo.append("Teacher: ").append(teacher.getFullName()).append("\n");
    courseInfo.append("Students:\n");

    for (Student student : students){
        courseInfo.append("   ").append(student.getFullName()).append("\n");

    }
    return courseInfo.toString();
    }
}

