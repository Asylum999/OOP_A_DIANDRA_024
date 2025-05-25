//user mahasiswa
package Task.Module4.users;
import java.util.*; 

import Task.Module4.actions.mahasiswaActions;
import Task.Module4.main.loginSystem;
import Task.Module4.Model.items;

public class mahasiswa extends userLogin implements mahasiswaActions {

    private ArrayList<String> reports = new ArrayList<>();

    public mahasiswa(String userName, String userPassw) {
        super(userName, userPassw);
    }
    @Override
    public void reportitem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nama Barang: ");
        String itemName = scanner.nextLine();
        System.out.println("Deskripsi Barang: ");
        String itemDescription = scanner.nextLine();
        System.out.println("Lokasi terakhir: ");
        String itemLocation = scanner.nextLine();

       
        String report = "Item: " + itemName + ", Deskripsi: " + itemDescription + ", Lokasi: " + itemLocation; 
        reports.add(report);

        System.out.println("Laporan telah diterima.");

    }
    @Override
    public void viewReporteditems() {
         System.out.println("Login sebagai Mahasiswa");
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
    public void login() {
        System.out.println("Login sebagai Mahasiswa");
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
            System.out.println("Mahasiswa Menu:");
            System.out.println("1. Lapor Barang");
            System.out.println("2. Lihat Laporan Saya");
            System.out.println("3. Logout");
            System.out.print("Pilih menu: ");
            pilihan = input.nextLine();
            switch (pilihan) {
                case "1":
                    reportItem(input);
                    break;
                case "2":
                    viewReportedItems();
                    break;
                case "3":
                    System.out.println("Logout...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (!pilihan.equals("3"));
    }

    public void reportItem(Scanner input) {
        System.out.print("Nama Barang: ");
        String nama = input.nextLine();
        System.out.print("Deskripsi: ");
        String deskripsi = input.nextLine();
        System.out.print("Lokasi: ");
        String lokasi = input.nextLine();
        items item = new items(nama, deskripsi, lokasi, "Reported");
        loginSystem.reporteditems.add(item);
        System.out.println("Laporan berhasil ditambahkan!");
    }

    public void viewReportedItems() {
        boolean ada = false;
        for (items item : loginSystem.reporteditems) {
            if (item.getStatus().equals("Reported")) {
                System.out.println("Nama: " + item.getItemname() + ", Deskripsi: " + item.getDeskripsi() + ", Lokasi: " + item.getLokasi());
                ada = true;
            }
        }
        if (!ada) System.out.println("Belum ada laporan barang.");
    }
}