/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AdminModule;

/**
 *
 * @author Ahmed Nagah
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminModuleGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    private JTextField usernameField, searchField;
    private JPasswordField passwordField;
    private JTextArea outputArea;

    private AdminModule adminModule;

    public AdminModuleGUI(AdminModule adminModule) {
        this.adminModule = adminModule;

        // إعداد واجهة المستخدم
        setTitle("Administrative Module");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // إعداد التبويبات (Tabs)
        JPanel loginPanel = createLoginPanel();
        JPanel userManagementPanel = createUserManagementPanel();

        cardPanel.add(loginPanel, "Login");
        cardPanel.add(userManagementPanel, "User Management");

        add(cardPanel);

        // عرض واجهة تسجيل الدخول أولاً
        cardLayout.show(cardPanel, "Login");
    }

    // واجهة تسجيل الدخول
    private JPanel createLoginPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminModule.authenticateUser(usernameField.getText(), new String(passwordField.getPassword()));
                if (adminModule.isAuthenticated()) {
                    JOptionPane.showMessageDialog(AdminModuleGUI.this, "Login Successful!");
                    cardLayout.show(cardPanel, "User Management");
                } else {
                    JOptionPane.showMessageDialog(AdminModuleGUI.this, "Invalid username or password!");
                }
            }
        });

        panel.add(loginButton);

        return panel;
    }

    // واجهة إدارة المستخدمين
    private JPanel createUserManagementPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // البحث عن مستخدم
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        searchPanel.add(new JLabel("Search User:"));
        searchField = new JTextField(15);
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminModule.searchUser(searchField.getText(), outputArea);
            }
        });
        searchPanel.add(searchButton);
        panel.add(searchPanel, BorderLayout.NORTH);

        // منطقة النتائج
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // إضافة، حذف وتحديث
        JPanel actionPanel = new JPanel();
        actionPanel.setLayout(new FlowLayout());

        JButton addButton = new JButton("Add User");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminModule.addUser(outputArea);
            }
        });
        actionPanel.add(addButton);

        JButton updateButton = new JButton("Update User");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminModule.updateUser(outputArea);
            }
        });
        actionPanel.add(updateButton);

        JButton deleteButton = new JButton("Delete User");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminModule.deleteUser(outputArea);
            }
        });
        actionPanel.add(deleteButton);

        panel.add(actionPanel, BorderLayout.SOUTH);

        return panel;
    }
}
