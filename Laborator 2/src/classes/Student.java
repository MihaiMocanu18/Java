package classes;
public class Student {
    String firstName;
    String lastName;
    int groupNumber;
    public Student(String firstName, String lastName, int groupNumber)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
    }
    public String getFullName(){
        return firstName + " " + lastName;
    }
    public String toString(){
        return " Student { " + "firstName=" + firstName + " , lastName=" +
                 lastName + " , groupNumber=" + groupNumber + " } ";

    }

        public static void main(String[] args){
    Student student = new Student("Mocanu", "Mihai", 1234);
    String fullName = student.getFullName();
    System.out.println(fullName);}
}
