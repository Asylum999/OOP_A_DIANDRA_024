    import java.util.Scanner;

public class cdlab1 {
    public static void main(String[] args) {
        //untuk mengimput data user

        Scanner input = new Scanner(System.in);
        String adminNama = "Admin010";
        String studentNama = "password"; //sebagai passwod

        String password = "024";
        String nim = "password";
        //untuk login user
        System.out.println("pilih login");
        System.out.println("1.Admin");
        System.out.println("2.Mahasiswa");
        System.out.print("Masukan pilihan: ");

        //memilah data user dan menentukan data login
        int pilihan = input.nextInt();
        if (pilihan == 1) {
            System.out.print("masukan nama: ");
            String inputNama = input.next();

            System.out.print("masukan password: ");
            String inputPassword = input.next();

            if (inputNama.equals(adminNama) && inputPassword.equals(password)) {
                System.out.println("login berhasil");
            } else {
                System.out.println("login gagal");
            }
        }
        else if (pilihan == 2){
            System.out.print("masukan nama: ");
            String inputNama = input.next();
            System.out.print("masukan nim: ");
            String inputNim = input.next();

            if (inputNama.equals(studentNama) && inputNim.equals(nim)) {
                System.out.println("login berhasil");
            }
            else {
                System.out.println("login gagal");
            }
        }
        else {
            System.out.println("pilihan tidak valid");
        }
    }
}