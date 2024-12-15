package AdminModule;


public class Admin extends UserModule.User{
    private static int id;

    public Admin(String name, String password) {
        super(name, password);
        id++;
    }

    @Override
    public int getID() {
        return id;
    }
    
}
