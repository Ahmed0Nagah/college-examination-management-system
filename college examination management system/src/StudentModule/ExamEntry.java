/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentModule;

/**
 *
 * @author HP
 */

public class ExamEntry {
    private boolean hasEnteredExam = false;

    public void enterExam(Student_1 student) {
        if (!hasEnteredExam) {
            System.out.println("Student " + student.getName() + " (ID: " + student.getStudentId() + ") has entered the exam.");
            hasEnteredExam = true;
        } else {
            System.out.println("Error: Exam entry is allowed only once!");
        }
    }
}

