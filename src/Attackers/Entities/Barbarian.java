package Attackers.Entities;

import java.awt.Color;

import Attackers.Interfaces.Attacker;
import Attackers.Interfaces.Damagable;
import Overall.Entity;
import edu.macalester.graphics.Ellipse;

public class Barbarian implements Entity, Attacker, Damagable {
    private static final double RADIUS = 10;
    
    private double x;
    private double y;
    private int health;
    private boolean isAlive;
    private Ellipse barbarian;

    public Barbarian(double x, double y){
        this.barbarian = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        barbarian.setCenter(x, y);
        barbarian.setFillColor(Color.RED);
        this.x = x;
        this.y = y;
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
        this.getGraphics().getCanvas().remove(this.getGraphics());
        this.isAlive = false;
        
    }

    public int getHealth(){
        return health;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public double getX(){
        return x;
    }

    public double getY(){
       return y; 
    }

    public Ellipse getGraphics(){
        return barbarian;
    }

}
