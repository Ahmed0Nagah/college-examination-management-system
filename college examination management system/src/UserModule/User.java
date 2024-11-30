package UserModule;

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
    
}
