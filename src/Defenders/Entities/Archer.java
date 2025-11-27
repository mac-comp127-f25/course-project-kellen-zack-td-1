package Defenders.Entities;

import java.awt.Color;

import Attackers.Interfaces.Attacker;
import Defenders.Interfaces.Defender;
import Overall.Entity;
import edu.macalester.graphics.Ellipse;

public class Archer implements Entity, Defender {
    
    private static final double RADIUS = 10;

    private int cost;
    private int rangeRandius;
    private int shotDamage;
    private double fireRate;
    private Ellipse archer;
    private double x;
    private double y;

    public Archer(double x, double y){
        archer = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        archer.setFillColor(Color.GREEN);
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

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Ellipse getGraphics(){
        return archer;
    }
}
