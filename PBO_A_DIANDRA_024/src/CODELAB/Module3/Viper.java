package Codelab.Module3;

//subclass; Musuh
class Viper extends GameCharacter { //subclass Viper
    public Viper(String name, int health) {
        super(name, health);
    }
    @Override //Untuk meng override method attack
    public void attack(GameCharacter target) { //method attack
        System.out.println(getName() + " attacks " + target.getName() + " using Snake Bite");
        System.out.println(target.getName() + " viper 50 health points");
        target.setHealth(target.getHealth() - 135); //mengurangi health target
    }
}
