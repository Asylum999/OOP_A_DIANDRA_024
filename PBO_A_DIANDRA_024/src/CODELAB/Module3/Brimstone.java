package Codelab.Module3;

//subclass: pahlawan
class Brimstone extends GameCharacter { //subclass Brimstone
    public Brimstone(String name, int health) {
        super(name, health);
    }
    @Override //untuk meng-override method attack pada superclass
    public void attack(GameCharacter target) { //method attack
        System.out.println(getName() + " attacks " + target.getName() + " using Orbital Strike");
        System.out.println(target.getName() + " now has 180 healths points");
        target.setHealth(target.getHealth() - 180);
        System.out.println(getName() + " attacks " + target.getName() + " using orbital strike");
        System.out.println(target.getName() + " now has 160 health points ");
        target.setHealth(target.getHealth() - 160);

    }
}