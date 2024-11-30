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
}
