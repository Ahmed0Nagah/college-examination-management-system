package UserModule;

public class User {
    private final int id;
    private String userName;
    private String password;

    public User(int id,String userName, String password) {
        this.id = id;
        this.password = password;
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
    
    
    
    
    
}
