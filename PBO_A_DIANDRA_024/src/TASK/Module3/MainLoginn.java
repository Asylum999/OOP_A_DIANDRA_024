package Task.Module3;
import java.util.Scanner;

public class MainLoginn {
    public static void main(String[] args) {
        //object dfrom 2 class 
        AdminClass admin1 = new AdminClass("dian", "24");
        StudentClass student1 = new StudentClass("dian", "24");
        //scanner for user
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Pilih jenis Login:\n1. Admin\n2. Student\n3. Keluar");
            System.out.print("Masukkan pilihan (1/2/3): ");
            String choice = input.nextLine().trim();
            //trying with if-else not with switch-case
            if (choice.equals("3")){
                System.out.println("Progam Keluar.");
                break;
            } else if (choice.equals("1")){
                loginUser(input, admin1);
            } else if (choice.equals("2")){ 
                loginUser(input, student1);
            } else {
                System.out.println("Input Invalid. Harap Masukkan 1/2/3");
            }
        }
        input.close();
    }
    private static void loginUser (Scanner input, UserLoginClass user){
        System.out.print("\nMasukkan Username: ");
        String userName = input.nextLine();
        System.out.print("Masukkan Password: ");
        String userPassw = input.nextLine();

        boolean isLogin = user.Login(userName, userPassw);
        user.displayInfo(isLogin);
    }
}