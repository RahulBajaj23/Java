import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 class Student {
    String firstName;
    String lastName;
    int registration;
    int grade;
    int year;

    // Constructors
    public Student(String firstName, String lastName, int registration, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = grade;
        this.year = year;
    }

    public Student(String firstName, String lastName, int registration) {
        this(firstName, lastName, registration, 0, 1);
    }

    public Student(String firstName, String lastName) {
        this(firstName, lastName, 0, 0, 1);
    }

    // Methods
    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }

    public boolean isApproved() {
        return grade >= 60;
    }

    public int changeYearIfApproved() {
        if (isApproved()) {
            year++;
            System.out.println("Congratulations!");
        }
        return year;
    }
}

class Course {
    String courseName;
    String professorName;
    int year;
    List<Student> enrolledStudents;

    // Constructor
    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.enrolledStudents = new ArrayList<>();
    }

    // Methods
    public void enroll(Student student) {
        enrolledStudents.add(student);
    }

    public void enroll(List<Student> students) {
        enrolledStudents.addAll(students);
    }

    public void unEnroll(Student student) {
        enrolledStudents.removeIf(s -> s.registration == student.registration);
    }

    public int countStudents() {
        return enrolledStudents.size();
    }

    public int bestGrade() {
        int maxGrade = 0;
        for (Student student : enrolledStudents) {
            maxGrade = Math.max(maxGrade, student.grade);
        }
        return maxGrade;
    }
}

public class SchoolSystem_project {
    public static void main(String[] args) {
        // Example usage

        // Create students
        Student student1 = new Student("John", "Doe", 1, 70, 1);
        Student student2 = new Student("Jane", "Smith", 2, 85, 1);
        Student student3 = new Student("Bob", "Johnson", 3, 55, 1);

        // Create course
        Course course = new Course("Java Programming", "Prof. Johnson", 2023);

        // Enroll individual students
        course.enroll(student1);
        course.enroll(student2);

        // Print student count and best grade
        System.out.println("Number of students: " + course.countStudents());
        System.out.println("Best grade in the course: " + course.bestGrade());

        // Enroll a list of students
        List<Student> studentList = Arrays.asList(student2, student3);
        course.enroll(studentList);

        // Print updated student count and best grade
        System.out.println("Number of students after enrolling a list: " + course.countStudents());
        System.out.println("Best grade in the course after enrolling a list: " + course.bestGrade());
    }
}