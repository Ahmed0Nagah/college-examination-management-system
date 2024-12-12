package LecturerModule;


public class Lecturer extends UserModule.User{
        private static int id;

    public Lecturer(String name, String password) {
        super(name, password);
        id++;
    }

    @Override
    public int getID() {
        return id;
    }    
    
    public void addExam(){
        
    }
    
    
}

