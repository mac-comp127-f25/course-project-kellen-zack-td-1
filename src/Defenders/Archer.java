package Defenders;

import Attackers.Attacker;

public class Archer implements Defender {
    
    private int cost;
    private int rangeRandius;
    private int shotDamage;
    private double fireRate;

    public Archer(){
        this.cost = 50;
        this.rangeRandius = 5;
        this.shotDamage = 20;
        this.fireRate = 1;
    }


    public void attack(Attacker target){
        
    }

    public void place(){
        
    }
    
    public int getCost(){
        return this.cost;
    }

    public int getRangeRadius(){
        return this.rangeRandius;
    }

    public int getDamagePerShot(){
        return this.shotDamage;
    }

    public double getFireRate(){
        return this.fireRate;
    }
}
