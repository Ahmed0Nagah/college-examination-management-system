package AdminModule;

import java.util.ArrayList;
import UserModule.User;

/**
 * @author Ahmed Nagah
 */
public class Admin extends User {
    private static int idCounter = 0; // Static counter to auto-increment IDs
    private final ArrayList<Subject> subjects;
    private final ArrayList<Student> students;
    private final int id;

    // Constructor that initializes admin data
    public Admin(String name, String password) {
        super(name, password); // Call the parent class constructor
        this.id = ++idCounter;
        this.subjects = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    @Override
    public int getID() {
        return id;
    }

    // 1. Subject Management
    public void addSubject(String subjectId, String subjectName) {
        subjects.add(new Subject(subjectId, subjectName));
        System.out.println("Subject '" + subjectName + "' added successfully!");
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    // 2. Grade Approval and Publication
    public void addStudent(String studentId, String studentName) {
        students.add(new Student(studentId, studentName));
        System.out.println("Student '" + studentName + "' added successfully!");
    }

    public void assignGrade(String studentId, double grade) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.setGrade(grade);
                System.out.println("Grade assigned to " + student.getStudentName());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}


