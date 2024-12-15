/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminModule;

/**
 *
 * @author dell
 */
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AdminModule {
    private final List<User> users;
    private boolean authenticated = false;

    public AdminModule() {
        users = new ArrayList<>();
       users.add(new User("admin", "admin123", "Admin"));
    }

    // المصادقة (User Authentication)
    public void authenticateUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                authenticated = true;
                return;
            }
        }
        authenticated = false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    // البحث عن المستخدم
    public void searchUser(String searchText, JTextArea outputArea) {
        outputArea.setText("");  // مسح المحتوى السابق

        for (User user : users) {
            if (user.getUsername().contains(searchText) || user.getRole().contains(searchText)) {
                outputArea.append(user.toString() + "\n");
            }
        }
    }

    // إضافة مستخدم جديد
    public void addUser(JTextArea outputArea) {
        String username = JOptionPane.showInputDialog(null, "Enter Username:");
        String password = JOptionPane.showInputDialog(null, "Enter Password:");
        String role = JOptionPane.showInputDialog(null, "Enter Role (Student/Lecturer):");

        if (username != null && password != null && role != null) {
            users.add(new User(username, password, role));
            JOptionPane.showMessageDialog(null, "User Added Successfully");
        }
    }

    // تحديث بيانات مستخدم
    public void updateUser(JTextArea outputArea) {
        String username = JOptionPane.showInputDialog(null, "Enter Username to Update:");

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                String newPassword = JOptionPane.showInputDialog(null, "Enter New Password:");
                String newRole = JOptionPane.showInputDialog(null, "Enter New Role (Student/Lecturer):");

                user.setPassword(newPassword);
                user.setRole(newRole);
                JOptionPane.showMessageDialog(null, "User Updated Successfully");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "User Not Found");
    }

    // حذف مستخدم
    public void deleteUser(JTextArea outputArea) {
        String username = JOptionPane.showInputDialog(null, "Enter Username to Delete:");

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                JOptionPane.showMessageDialog(null, "User Deleted Successfully");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "User Not Found");
    }

    // الفئة الداخلية للمستخدم
    public class User {
        private String username;
        private String password;
        private String role;

        public User(String username, String password, String role) {
            this.username = username;
            this.password = password;
            this.role = role;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getRole() {
            return role;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setRole(String role) {
            this.role = role;
        }

        @Override
        public String toString() {
            return "Username: " + username + ", Role: " + role;
        }
    }

    // نقطة الدخول الرئيسية
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                AdminModule adminModule = new AdminModule();
                AdminModuleGUI frame = new AdminModuleGUI(adminModule);
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);  // لجعل النافذة تظهر في المنتصف
            }
        });
    }
}

