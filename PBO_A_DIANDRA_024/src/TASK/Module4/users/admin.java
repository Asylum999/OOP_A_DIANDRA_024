//user admin
package Task.Module4.users;
import java.util.*;

import Task.Module4.actions.adminActions;
import Task.Module4.main.loginSystem;
import Task.Module4.Model.items;

public class admin extends userLogin implements adminActions {
    public admin(String userName, String userPassw) {
        super(userName, userPassw);
    }
    @Override
    public void login() {
        System.out.println("Login sebagai Admin");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (username.equals(this.userName) && password.equals(this.userPassw)) {
            System.out.println("Login berhasil! Selamat datang " + this.userName + "!");
        } else {
            System.out.println("Nama atau password salah.");
        }
    }
    @Override
    public void displaymenu(Scanner input) {
        String pilihan;
        do {
            System.out.println("Admin Menu:");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Diambil");
            System.out.println("3. Kelola User");
            System.out.println("4. Logout");
            System.out.print("Pilih menu: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    viewitems();
                    break;
                case "2":
                    claimItem(input);
                    break;
                case "3":
                    manageUsers(input);
                    break;
                case "4":
                    System.out.println("Logout...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (!pilihan.equals("4"));
    }
    //
    public void viewitems() {
        if (loginSystem.reporteditems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }
        int idx = 0;
        for (items item : loginSystem.reporteditems) {
            System.out.println(idx + ". Nama: " + item.getItemname() + ", Deskripsi: " + item.getDeskripsi() + ", Lokasi: " + item.getLokasi() + ", Status: " + item.getStatus());
            idx++;
        }
    }
    //
    public void claimItem(Scanner input) {
        if (loginSystem.reporteditems.isEmpty()) {
            System.out.println("Tidak ada laporan barang.");
            return;
        }
        int i = 0;
        for (items item : loginSystem.reporteditems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println(i + ". " + item.getItemname() + " - " + item.getDeskripsi());
            }
            i++;
        }
        try {
            System.out.print("Masukkan nomor indeks barang yang di-claim: ");
            int idx = Integer.parseInt(input.nextLine());
            items item = loginSystem.reporteditems.get(idx);
            if (item.getStatus().equals("Reported")) {
                item.setStatus("Claimed");
                System.out.println("Barang berhasil ditandai sebagai diambil.");
            } else {
                System.out.println("Barang sudah di-claim sebelumnya.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid!");
        }
    }
    public void manageUsers(Scanner input) {
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.print("Pilih menu: ");
        String pilih = input.nextLine();
        if (pilih.equals("1")) {
            System.out.print("Nama Mahasiswa: ");
            String nama = input.nextLine();
            System.out.print("NIM: ");
            String nim = input.nextLine();
            loginSystem.userList.add(new mahasiswa(nama, nim));
            System.out.println("Mahasiswa berhasil ditambahkan.");
        } else if (pilih.equals("2")) {
            System.out.print("NIM Mahasiswa yang dihapus: ");
            String nim = input.nextLine();
            boolean found = false;
            for (int i = 0; i < loginSystem.userList.size(); i++) {
                userLogin user = loginSystem.userList.get(i);
                if (user instanceof mahasiswa && user.getUserPassw().equals(nim)) {
                    loginSystem.userList.remove(i);
                    System.out.println("Mahasiswa berhasil dihapus.");
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Mahasiswa tidak ditemukan.");
        }
    }
    @Override
    public void viewUsers() {
            System.out.println("Viewing reported items.");
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }
    @Override
    public void manageUsers() {
        System.out.println("Managing users.");
        System.out.println(">> Fitur Kelola User Belum Tersedia <<");
    }
}