
public class Dampymon extends Forneymon impements MinForneymon{
    
    //constructor(s)
    Dampymon(String n) {
            super(n,25);
    }
    
    //Methods
    public int takeDamage (int dmg, String type) {
        if(type.equals("burny")) {
            dmg+= 5;
        }
        health -=dmg;
        return health;
    }
    
}