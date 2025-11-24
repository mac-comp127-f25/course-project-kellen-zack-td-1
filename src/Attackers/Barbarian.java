package Attackers;

public class Barbarian implements Attacker, Damagable {
    
    
    private int health;
    private boolean isAlive;

    public Barbarian(){
        this.health = 20;
        this.isAlive = true;
    }
    
    public void move(){

    }

    public boolean takeDamage(int amount){
        health-=amount;
        if(health <= 0){
            perish();
            return true;
        }
        return false;
    }

    public void perish(){
        //Remove from canvas
        this.isAlive = false;
    }

    public int getHealth(){
        return health;
    }

    public boolean isAlive(){
        return isAlive;
    }

}
