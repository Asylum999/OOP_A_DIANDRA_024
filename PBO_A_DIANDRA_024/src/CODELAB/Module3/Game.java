package Codelab.Module3;
//superclass
class GameCharacter {
    private String name; //atribut name
    private int health; //atribut health
   
    //constructor
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
    public void attack(GameCharacter target) {  //method attack
        System.out.println(getName() + " attacks " + target.getName());
    }
}



