package Model;

public class User {

    String username;
    String password;
    private boolean loggedIn;

    public User(String u, String p){
        this.username = u;
        this.password = p;
    }

    public User(){
        this.username = "";
        this.password = "";
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
