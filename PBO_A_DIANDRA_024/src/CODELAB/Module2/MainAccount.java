package Codelab.Module2;

public class MainAccount {
    public static void main(String[] args){
        BankAccount account1 = new BankAccount("202410370110024", "Muhammad Diandra Adzka Surya", 50000);
        BankAccount account2 = new BankAccount("202410370110200", "Kharisma Aditya Putra", 40000);

        account1.displayinfo();
        account2.displayinfo();

        System.out.print("\n");
        account1.depositinfo(20000);
        account2.depositinfo(10000);

        System.out.print("\n");
        account1.withdrawMoney(80000);
        account2.withdrawMoney(30000);
        System.out.print("\n");
        account1.displayinfo();
        account2.displayinfo();
    }
}