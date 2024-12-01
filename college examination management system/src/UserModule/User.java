package UserModule;

import LecturerModule.Lecturer;
import java.io.*;
import java.util.Scanner;

public abstract class User {
    
    
    private String userName;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    protected abstract void setID(int id);
    public abstract int getID();

    protected void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    
    public String getPassword() {
        return password;
    }

    public String getName(User u){
        return u.userName;
    }
    
    public  void printAllContnet(String pathName){
        try(Scanner fileReader = new Scanner(new File(pathName))) {
            while(fileReader.hasNext()){
                String line = fileReader.nextLine();
                String [] arr = line.split(",");
                
                if(arr.length <= 4){
                    String id = arr[0].trim();
                    String username = arr[1].trim();
                    String passwordd = arr[2].trim();
                    String courseName = arr[3].trim();
                    
                    System.out.println("The id is : "+ id);
                    System.out.println("The username is : "+ username);
                    System.out.println("The password is : "+ passwordd);
                    System.out.println("The course name is : "+ courseName);
                    System.out.println("************************");
                }
                else{
                    System.out.println("Invalid format!\n");
                }
            }
            
            
        } catch (Exception e) {
            System.out.println("The file not found!\n");
        }
        
    }
    
    public static void main(String[] args) {
        User user = new Lecturer("Ahmed", "1234");
        user.printAllContnet("src\\Lecturers.txt");
        
        
    }
}
