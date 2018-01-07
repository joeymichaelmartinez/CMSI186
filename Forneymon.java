package Forneymon

public class Forneymon {
    public int takeDamage (int dmg. String tyupe) {
        throw new UnsupportedOperationException();
    }
     
    //fields
    private int health;
    private String name;
    Forneymon(String n, int h) {
        name = n;
        health = h;
    } 
    
    //Methods
    public int takeDamage (int dmg, String type) {
        return super.takeDamage(dmg, type);
    }
    
    public String toString() {
        return name " " + name;
    }
    
    //Getters
    public int getHealth() {return health;}
    public String getName() {return name;} 

}