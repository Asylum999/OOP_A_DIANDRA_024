//login
package Task.Module4.main;
import java.util.*;

import Task.Module4.users.admin;
import Task.Module4.users.mahasiswa;
import Task.Module4.users.userLogin;
import Task.Module4.Model.items;

public class loginSystem { 
    public static ArrayList<userLogin> userList = new ArrayList<>();
    public static ArrayList<items> reporteditems = new ArrayList<>();

    public static void main(String[] args) {
        // Inisialisasi user default
        userList.add(new admin("adit", "200"));
        userList.add(new mahasiswa("diian", "123"));

        Scanner input = new Scanner(System.in);
        String choice;
        do  {
            System.out.println("Pilih jenis login:");
            System.out.println("1. Admin");
            System.out.println("2. Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            choice = input.nextLine();

            userLogin loggedInUser = null;
            switch (choice) {
                case "1":
                    loggedInUser = login("admin", input);
                    break;
                case "2":
                    loggedInUser = login("mahasiswa", input);
                    break;
                case "3":
                    System.out.println("Program keluar");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            if (loggedInUser != null) {
                loggedInUser.displaymenu(input);
            }

        } while (!choice.equals("3"));
        input.close();
    }

    public static userLogin login(String tipe, Scanner input) {
        System.out.print("Username: ");
        String username = input.nextLine();
        System.out.print("Password: ");
        String password = input.nextLine();
        //instanceof
        for (userLogin user : userList) { 
             if (tipe.equals("admin") && user instanceof admin) {
                if (user.getUserName().equals(username) && user.getUserPassw().equals(password)) {
                    System.out.println("Login berhasil sebagai Admin!");
                    return user;
                }
            } else if (tipe.equals("mahasiswa") && user instanceof mahasiswa) {
                if (user.getUserName().equals(username) && user.getUserPassw().equals(password)) {
                    System.out.println("Login berhasil sebagai Mahasiswa!");
                    return user;
                }
            }
        }
        System.out.println("Username atau password salah.");
        return null;
    }
}