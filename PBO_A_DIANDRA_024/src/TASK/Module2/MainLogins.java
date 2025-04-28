package Task.Module2;

import java.util.Scanner;

//admin login
class AdminLogin {
    boolean authenticate(String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }
}

//student login
class StudentLogin {
    boolean authenticate(String username, String password) {
        if (username.equals("Diandra") && password.equals("diandra024")) {
            return true;
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
    }
}

public class MainLogins{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Login as (admin/student): ");
        String choice = scanner.nextLine();
        if (choice.equals("admin")) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            AdminLogin admin = new AdminLogin();
            if (admin.authenticate(username, password)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } else if (choice.equals("student")) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();
            StudentLogin student = new StudentLogin();
            if (student.authenticate(username, password)) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } else {
            System.out.println("Invalid choice");
        }
        scanner.close();
    }
}