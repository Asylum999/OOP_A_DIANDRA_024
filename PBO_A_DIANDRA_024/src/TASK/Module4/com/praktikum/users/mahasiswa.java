package com.praktikum.users;
import java.util.Scanner;
import com.praktikum.actions.*;

public class mahasiswa extends userLogin implements mahasiswaActions{
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
        System.out.println("lokasi terakhir/terakhir: ");
        String itemLocation = scanner.nextLine();
        System.out.println("pesanan diterima");
    }
    @Override
    public void viewReporteditems() {
        System.out.println("Viewing reported items.");
         System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");

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
            System.out.println("Login successful!" + this.userName + "!"); 
        } else {
            System.out.println("Nama atau password salah.");
        }
    }

    @Override
    public void displaymenu() {
        System.out.println("Mahasiswa Menu: \n1. Report Item\n2. View Reported Items\n3. Logout");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose an option: ");
        String choice = scanner.nextLine();
        switch (choice) {
            case "1":
                reportitem();
                break;
            case "2":
                viewReporteditems();
                break;
            case "3":
                System.out.println("Logout successful!");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}