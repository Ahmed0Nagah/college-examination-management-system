/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentModule;

/**
 *
 * @author HP
 */
public class Feedback {
     public void submitFeedback(String studentId, String courseName, String rating) {
        // Print the feedback to the console (this could also be saved to a file or database)
        System.out.println("Feedback submitted for Student ID: " + studentId
                + ", Course Name: " + courseName
                + ", Rating: " + rating);
    }
}

