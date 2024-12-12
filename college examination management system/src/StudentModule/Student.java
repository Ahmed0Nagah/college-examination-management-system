// std
package StudentModule;

public class Student extends UserModule.User{
    private static int id = 100;
    
    
    public Student(String name , String password){
        super(name, password);
        id++;
    }

    
    @Override
    public int getID(){
        return id;
    }
}
