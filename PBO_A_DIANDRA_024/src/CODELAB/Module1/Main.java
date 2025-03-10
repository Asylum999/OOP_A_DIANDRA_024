import java.time.LocalTime;
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String nama; //variable nama untuk menyimpan nama
        String jenisKelamin; //untuk menyimpan jenis kelamin
        LocalDate Timenow = LocalDate.now(); //untuk mengimput waktu kini
        int tahunLahir; //variable tahun lahir

        Scanner input = new Scanner(System.in); //objek untuk mengimput

        //user di minta memesukan data diri
        System.out.print("Masukan Nama: "); nama = input.nextLine();
        System.out.print("Masukan Jenil kelamin (P/l): "); jenisKelamin = input.nextLine();
        System.out.print("Masukan Tahun Lahir: "); tahunLahir = input.nextInt();

        //hasil output data diri
        System.out.println("DAta Diri");
        System.out.println("Nama: " + nama);
        if(jenisKelamin.equalsIgnoreCase("p")){ //untuk perempuan
            System.out.println("Jenis Kelamin: Perempuan");

        } else if (jenisKelamin.equalsIgnoreCase("l")) { //untuk lakilaki
            System.out.println("Jenis Kelamin: Laki-laki");


        } else {
            System.out.println("Jenis Kelamin: Tidak dikenali"); //anomaly
        }
        int umur = Timenow.getYear() - tahunLahir; //untuk mengetahui umur user
        System.out.println("Umur: " + umur + " Tahun");
    }
}