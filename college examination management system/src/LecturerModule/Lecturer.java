<<<<<<< HEAD
package LecturerModule;


public class Lecturer extends UserModule.User{
        private static int id;

    Lecturer(String name, String password) {
        super(name, password);
        id++;
    }
    
    protected void setID(int id) {
        Lecturer.id = id;
    }

    public int getID() {
        return id;
    }    
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LecturerModule;

/**
 *
 * @author Ahmed Nagah
 */
public class Lecturer {
    
>>>>>>> parent of b9a1be2 (jiuhh)
}
