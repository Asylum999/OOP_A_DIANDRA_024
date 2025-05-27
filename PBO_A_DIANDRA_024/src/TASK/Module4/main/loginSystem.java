package Task.Module4.main;

import java.util.*;
import Task.Module4.users.userLogin;
import Task.Module4.users.admin;
import Task.Module4.users.mahasiswa;
import Task.Module4.Model.items;

public class loginSystem {
    public static ArrayList<userLogin> userList = new ArrayList<>();
    public static ArrayList<items> reporteditems = new ArrayList<>();

    // Method baru untuk inisialisasi user, digunakan di GUI
    public static void initUsers() {
        if (userList.isEmpty()) { // Cegah duplikat
            userList.add(new admin("adit", "200"));
            userList.add(new mahasiswa("diian", "123"));
        }
    }

    // Method login dipakai oleh GUI
    public static userLogin login(String tipe, String username, String password) {
        for (userLogin user : userList) {
            if (tipe.equalsIgnoreCase("admin") && user instanceof admin) {
                if (user.getUserName().equals(username) && user.getUserPassw().equals(password)) {
                    return user;
                }
            } else if (tipe.equalsIgnoreCase("mahasiswa") && user instanceof mahasiswa) {
                if (user.getUserName().equals(username) && user.getUserPassw().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }
}
