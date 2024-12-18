/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminModule;

/**
 *
 * @author hp
 */
public class Student {
    private final String studentId;
    private final String studentName;
    private double grade;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = -1; // Default grade to indicate "Not graded"
    }

    // Getters and Setters
    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + studentName + ", Grade: " + 
               (grade == -1 ? "Not Yet Graded" : grade);
    }
}

