package Codelab.Module3;
//superclass
class GameCharacter {
    private String name;
    private int health;

    public GameCharacter(String name, int health) {
        this.name = name;
        this.health = health;
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void attack(GameCharacter target) {   
    }
}
//subclass: pahlawan
class Brimstone extends GameCharacter {
    public Brimstone(String name, int health) {
        super(name, health);
    }
    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike");
        System.out.println(target.getName() + " now has 180 healths points");
        target.setHealth(target.getHealth() - 180);
        System.out.println(getName() + " attacks " + target.getName() + " using orbital strike");
        System.out.println(target.getName() + " now has 160 health points ");
        target.setHealth(target.getHealth() - 160);

    }
}

//subclass; Musuh
class Viper extends GameCharacter {
    public Viper(String name, int health) {
        super(name, health);
    }
    @Override
    public void attack(GameCharacter target) {
        System.out.println(getName() + " attacks " + target.getName() + " using Snake Bite");
        System.out.println(target.getName() + " viper 50 health points");
        target.setHealth(target.getHealth() - 135);
    }
}

//main class
public class Game {
    public static void main(String[] args) {
        GameCharacter general = new GameCharacter("General Character", 100);
        Brimstone brimstone = new Brimstone("Brimstone", 150);
        Viper viper = new Viper("Viper", 200);

        System.out.println("Initial status:");
        System.out.println(brimstone.getName() + " has health: " + brimstone.getHealth());
        System.out.println(viper.getName() + " has health: " + viper.getHealth());
        System.out.println();

        //simulasi
        brimstone.attack(viper);
        brimstone.attack(viper);
        viper.attack(brimstone);
    }
}
