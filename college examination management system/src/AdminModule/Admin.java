/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminModule;

/**
 *
 * @author Ahmed Nagah
 */
import java.util.ArrayList;

public class Admin {
    private final ArrayList<Subject> subjects;
    private final ArrayList<Student> students;

    public Admin() {
        subjects = new ArrayList<>();
        students = new ArrayList<>();
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

