package Codelab.Module4.App;
import Codelab.Module4.Library.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Muhammad Kharisma Aditya Putra", "200");
        Anggota anggota2 = new Anggota("Muhammad Zhiaulhag", "394");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();
        System.out.println();

        anggota1.pinjamBuku(" 10 dosa besar soeharto");
        anggota2.pinjamBuku("Death Note");
        System.out.println();

        anggota1.kembalikanBuku("10 dosa besar soeharto");
        anggota2.kembalikanBuku("Death Note");
    }
}
