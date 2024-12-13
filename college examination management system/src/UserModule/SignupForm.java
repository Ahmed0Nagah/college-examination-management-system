/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package UserModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import LecturerModule.Lecturer;
import StudentModule.*;

/**
 *
 * @author Ahmed Nagah
 */
public class SignupForm extends javax.swing.JFrame {

    ArrayList<Lecturer> lecturers = new ArrayList<>();
    private int signUpType;
    
    public SignupForm(int signUpType) {
        initComponents();
        
        this.signUpType = signUpType;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sign_inLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        signupButton = new javax.swing.JButton();
        passwordField1 = new javax.swing.JPasswordField();
        signupButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sign_inLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        sign_inLabel.setForeground(new java.awt.Color(0, 120, 215));
        sign_inLabel.setText("Sign up");

        usernameField.setBackground(new java.awt.Color(234, 234, 234));
        usernameField.setForeground(new java.awt.Color(0, 0, 0));
        usernameField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        usernameField.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        usernameLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        passwordLabel.setText("Password");

        signupButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signupButton.setText("Submit");
        signupButton.setFocusable(false);
        signupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButtonActionPerformed(evt);
            }
        });

        passwordField1.setBackground(new java.awt.Color(234, 234, 234));
        passwordField1.setForeground(new java.awt.Color(0, 0, 0));
        passwordField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        signupButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        signupButton1.setText("cancel");
        signupButton1.setFocusable(false);
        signupButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(signupButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(sign_inLabel)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sign_inLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameLabel)
                .addGap(18, 18, 18)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signupButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void signupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButtonActionPerformed
        // TODO add your handling code here:
        if(signUpType == 1){
            
        }
        
        else if(signUpType == 2){
            
            /*note that you will delete this object because you will remove the automatic id*/
            Lecturer lecturer = new Lecturer(usernameField.getText(), passwordField1.getText());
            lecturers.add(lecturer);


            String[] newLecturer = {String.valueOf(lecturer.getID()),usernameField.getText(),passwordField1.getText()}; 
            String newLine = String.join(" ", newLecturer);

            try(PrintWriter write = new PrintWriter(new FileWriter("src\\Lecturers.txt",true))) {
                write.println(newLine);

            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
        else{
            Student student = new Student(usernameField.getText(), passwordField1.getText());
            
            String[] newStudent = {String.valueOf(student.getID()),usernameField.getText(),passwordField1.getText()}; 
            String newLine = String.join(" ", newStudent);

            try(PrintWriter write = new PrintWriter(new FileWriter("src\\Students.txt",true))) {
                write.println(newLine);

            }catch(IOException e){
                System.out.println("File not found!");
            }
        }
        
        dispose();

    }//GEN-LAST:event_signupButtonActionPerformed

    private void signupButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_signupButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(SignupForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new SignupForm().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel sign_inLabel;
    private javax.swing.JButton signupButton;
    private javax.swing.JButton signupButton1;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
