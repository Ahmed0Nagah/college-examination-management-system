/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentModule;

/**
 *
 * @author HP
 */
public class Student_1 {
    private String name;
    private int studentId;

    // Constructor
    public Student_1(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public static void main(String[] args) {
        // Creating student instance
        Student_1 student = new Student_1("Bla Bla", 1234567);

        // Exam Entry Logic
        ExamEntry examEntry = new ExamEntry();
        examEntry.enterExam(student);

        // Re-Correction Request Logic
        ReCorrection reCorrection = new ReCorrection();
        // Example Parameters
        String studentId = "123456";
        String courseName = "CS";
        reCorrection.submitRequest(studentId, courseName);
    

        // Feedback Mechanism
        // Create an instance of Feedback and submit the feedback
        Feedback feedback = new Feedback();

    }
}

