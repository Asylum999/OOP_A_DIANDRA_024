//users user login abstract class
package Task.Module4.users;


public abstract class userLogin {
    
    protected String userName;
    protected String userPassw;
    
    public userLogin(String userName, String userPassw){
        this.userName = userName;
        this.userPassw = userPassw;
    }
    
    public abstract void login();
    public abstract void displaymenu(java.util.Scanner input);

    public String getUserName() {
        return userName;
    }

    public String getUserPassw() {
        return userPassw;
    }
}