package AdminModule;

import UserModule.UpdateForm;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.*;


public class AdminForm extends javax.swing.JFrame {
    DefaultTableModel lecturersDefaultTableModel = new DefaultTableModel();
    DefaultTableModel studentsDefaultTableModel = new DefaultTableModel();

    
    public AdminForm() {
        initComponents();
        lectueresTable.setModel(lecturersDefaultTableModel);
        studentsTable.setModel(studentsDefaultTableModel);
        
        lecturersDefaultTableModel.addColumn("Id");
        lecturersDefaultTableModel.addColumn("Name");
        lecturersDefaultTableModel.addColumn("Password");
        lecturersDefaultTableModel.addColumn("Course name");
        
        studentsDefaultTableModel.addColumn("Id");
        studentsDefaultTableModel.addColumn("Name");
        studentsDefaultTableModel.addColumn("Password");
        
        fillTables();
    }
    private void fillTables(){
        try(Scanner reader = new Scanner(new File("src\\Lecturers.txt"))){
            while(reader.hasNextLine()){
                String[] data = reader.nextLine().split(" ");
                lecturersDefaultTableModel.addRow(data);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        try(Scanner reader = new Scanner(new File("src\\Students.txt"))){
            while(reader.hasNextLine()){
                String[] data = reader.nextLine().split(" ");
                studentsDefaultTableModel.addRow(data);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
    }


    private void searchInTableByID(JTable table, String query) {
        
        int rowCount = table.getRowCount();

        
        for (int i = 0; i < rowCount; i++) {
            
            String idValue = table.getValueAt(i, 0).toString();

            
            if (idValue.toLowerCase().equals(query.toLowerCase())) {
                
                table.setRowSelectionInterval(i, i); 
                table.scrollRectToVisible(table.getCellRect(i, 0, true)); 
                return; 
            }
        }

        
        table.clearSelection();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteUserButton = new javax.swing.JButton();
        UpdateUserButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lectueresTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        studentsTable = new javax.swing.JTable();
        publishButton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Search user by id :");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Lectureres");

        jLabel3.setText("Students");

        deleteUserButton.setText("Delete user");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        UpdateUserButton.setText("Update user");
        UpdateUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateUserButtonActionPerformed(evt);
            }
        });

        addUserButton.setText("Add user");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        lectueresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(lectueresTable);

        studentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(studentsTable);

        publishButton.setText("publish grades");
        publishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishButtonActionPerformed(evt);
            }
        });

        jButton4.setText("Logout");
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(UpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UpdateUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(publishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UpdateUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateUserButtonActionPerformed
        // TODO add your handling code here:
        new UpdateForm(1).setVisible(true);
    }//GEN-LAST:event_UpdateUserButtonActionPerformed

    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        // TODO add your handling code here:
        new AddUserForm().setVisible(true);
        
    }//GEN-LAST:event_addUserButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        // TODO add your handling code here:
        int selectedLecRow = lectueresTable.getSelectedRow();
        int selectedStuRow = studentsTable.getSelectedRow();

        if (selectedLecRow != -1) {
            int columnCount = lectueresTable.getColumnCount();

            String[] lecturerRowData = new String[columnCount];

            for (int i = 0; i < columnCount; i++) {
                lecturerRowData[i] = lectueresTable.getValueAt(selectedLecRow, i).toString();
            }
            ArrayList<String> lines = new ArrayList<>();
            try (Scanner fileReader = new Scanner(new File("src\\Lecturers.txt"))) {
                while (fileReader.hasNextLine()) {
                    String oldLine = fileReader.nextLine();
                    String[] oldContent = oldLine.split(" ");

                    if (!Arrays.equals(lecturerRowData, oldContent)) {
                        lines.add(oldLine);
                    }
                }

            } catch (IOException e) {
                System.out.println("File not found!");
            }
            try (PrintWriter write = new PrintWriter("src\\Lecturers.txt")) {
                for (String line : lines) {
                    write.println(line);
                }
            } catch (Exception e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
            lecturersDefaultTableModel.removeRow(selectedLecRow);

        }

        if (selectedStuRow != -1) {
            int columnCount = studentsTable.getColumnCount();

            String[] studentRowData = new String[columnCount];

            for (int i = 0; i < columnCount; i++) {
                studentRowData[i] = studentsTable.getValueAt(selectedStuRow, i).toString();
            }
            ArrayList<String> lines = new ArrayList<>();
            try (Scanner fileReader = new Scanner(new File("src\\Students.txt"))) {
                while (fileReader.hasNextLine()) {
                    String oldLine = fileReader.nextLine();
                    String[] oldContent = oldLine.split(" ");

                    if (!Arrays.equals(studentRowData, oldContent)) {
                        lines.add(oldLine);
                    }
                }

            } catch (IOException e) {
                System.out.println("File not found!");
            }
            try (PrintWriter write = new PrintWriter("src\\Students.txt")) {
                for (String line : lines) {
                    write.println(line);
                }
            } catch (Exception e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }

            studentsDefaultTableModel.removeRow(selectedStuRow);
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        searchInTableByID(studentsTable, searchField.getText());
        searchInTableByID(lectueresTable, searchField.getText());
        
    }//GEN-LAST:event_searchButtonActionPerformed

    private void publishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishButtonActionPerformed
        // TODO add your handling code here:
        new gradeapproval().setVisible(true);
        
    }//GEN-LAST:event_publishButtonActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        dispose();
        new UserModule.MainMenu().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton UpdateUserButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable lectueresTable;
    private javax.swing.JButton publishButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable studentsTable;
    // End of variables declaration//GEN-END:variables
}
