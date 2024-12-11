package UserModule;

import LecturerModule.Lecturer;
import java.io.*;
import java.util.ArrayList;
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
                String [] arr = line.split(" ");
                
                if(arr.length <= 4){
                    String id = arr[0].trim();
                    String username = arr[1].trim();
                    String passwordd = arr[2].trim();
                    String courseName = arr[3].trim();
                    
                    System.out.println("Id is : "+ id);
                    System.out.println("Username is : "+ username);
                    System.out.println("Password is : "+ passwordd);
                    System.out.println("Course name is : "+ courseName);
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
    
    public void filewriter(String pathname, String newcontent) {
        String[] data = newcontent.split(" ");
        if (data.length <= 4) {
            try (PrintWriter write = new PrintWriter((new FileWriter(pathname, true)))) {
                write.print("\n"+newcontent);

            } catch (Exception e) {

                System.out.println("The file not found!\n");

            }
        } else {
            System.out.println("Invalid format!\n");
        }

    }
    
    
    public static void main(String[] args) {
        User user = new Lecturer("Ahmed", "1234");
//        user.filewriter("src\\Lecturers.txt", "7 ronaldo 3mmessi history");
//        user.printAllContnet("src\\Lecturers.txt");
        
    }
}
