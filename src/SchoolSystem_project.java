import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

class Student {
    String firstName;
    String lastName;
    int registration;
    int grade;
    int year;

    public Student( String firstName, String lastName, int registration, int grade, int year){
        this.firstName=firstName;
        this.lastName=lastName;
        this.registration=registration;
        this.grade=grade;
        this.year=year;
    }
    public Student(String firstName,String lastName,int year){
        this(firstName,lastName,0,0,1);
    }
    public  Student(String firstName,String lastName){
        this(firstName,lastName,0,0,1);
    }
     public void printFullName(){
         //TODO implement
         System.out.println(firstName+" "+ lastName);
     }

     public boolean isApproved(){
         //TODO implement: should return true if grade >= 60
         return grade>=60;

     }

     public int changeYearIfApproved(){
        if(isApproved()){
            year++;
            System.out.println("Congragulations");
        }
         //TODO implement: the student should advance to the next year if he/she grade is >= 60
         // Make year = year + 1, and print "Congragulations" if the student has been approved
         return year;
     }
}

class Course{
    String courseName;
    String ProfessorName;
    int year;
    static List<Student> enrolledStudents;

    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.ProfessorName = professorName;
        this.year = year;
        enrolledStudents = new ArrayList<>();
    }

    public void enroll(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        } else {
            System.out.println(student.firstName + " " + student.lastName + " is already enrolled.");
        }
    }
    public void unEnroll(Student student){
        //TODO remove this student from the collection
        // Hint: check if that really is this student
        enrolledStudents.removeIf(s->s.registration==student.registration);
    }

    public  int countStudents(){
        //TODO implement
        return enrolledStudents.size();
    }

    public  int bestGrade(){
        //TODO implement
        int maxGrade=0;
        for(Student student:enrolledStudents) {
            maxGrade = Math.max(maxGrade, student.grade);
        }
            return maxGrade;

    }
    public void enroll(Student[] students) {
        for (Student student : students) {
            enroll(student);
        }
    }

}
public class SchoolSystem_project {
    public static void main(String[] args) {
        Student s1 = new Student("Rahul", "Kumar", 10, 75, 1);
        Student s2 = new Student("Soumya", "Sharma", 11, 85, 1);
        Student s3 = new Student("Rajat", "yadav", 12, 90, 1);

        Course c1 = new Course("java", "prof.Anamaliah", 2023);

        c1.enroll(s1);
        c1.enroll(s2);

        System.out.println("Number of students: " + c1.countStudents());
        System.out.println("Best grade: " + c1.bestGrade());

        Student[] studentArray = { s1, s3 };
        c1.enroll(studentArray);

        // Enroll students from studentArray if not already enrolled
//        for (Student student : studentArray) {
//            if (!Course.enrolledStudents.contains(student)) {
//                c1.enroll(student);
//            }
//        }

        System.out.println("Number of students after enroll of studentArray: " + c1.countStudents());
        System.out.println("Best grade after enroll of studentArray: " +c1.bestGrade());
    }
}


