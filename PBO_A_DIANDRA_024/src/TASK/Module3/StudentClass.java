package Task.Module3;

public class StudentClass extends UserLoginClass{
    public StudentClass(String userName, String userPassw){
        super(userName.toLowerCase(), userPassw.toLowerCase());
    }

    @Override
    public boolean Login(String inputUserName, String inputUserPassw){
        return super.Login(inputUserName, inputUserPassw);
    }
}   