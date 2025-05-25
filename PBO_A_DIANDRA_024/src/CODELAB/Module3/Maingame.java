package Codelab.Module3;

//main class
public class Maingame { 
    public static void main(String[] args) { //method main
        Brimstone brimstone = new Brimstone("Brimstone", 150);
        Viper viper = new Viper("Viper", 200);

        System.out.println("Initial status:");
        System.out.println(brimstone.getName() + " has health: " + brimstone.getHealth());
        System.out.println(viper.getName() + " has health: " + viper.getHealth());

        //simulasi
        brimstone.attack(viper);
        brimstone.attack(viper);
        viper.attack(brimstone);
    }
}
