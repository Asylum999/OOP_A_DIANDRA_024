package Task.Module3;

public class UserLoginClass {
    private String userName;
    private String userPassw;

    public UserLoginClass(String userName, String userPassw){
        this.userName = userName;
        this.userPassw = userPassw;
    }
    public String getName(){
        return userName;
    }
    public String getPassw(){
        return userPassw;
    }
    public void setName(String userName){
        this.userName = userName;
    }
    public void setStudentId(String userPassw){
        this.userPassw = userPassw;
    }
    //boolean to user login (username and password)
    public boolean Login(String inputUserName, String inputUserPassw){
        return userName.equalsIgnoreCase(inputUserName) && userPassw.equalsIgnoreCase(inputUserPassw);
    }
    public void displayInfo(boolean isLogin){
        if(isLogin){
            System.out.println("Login Berhasil");
        } else {
            System.out.println("Username / Password Salah!");
        }
    }
}