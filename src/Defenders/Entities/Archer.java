package Defenders.Entities;

import java.awt.Color;
import java.util.ArrayList;

import Attackers.Interfaces.Attacker;
import Defenders.Interfaces.Defender;
import Defenders.Shooting.Arrow;
import Overall.Entity;
import edu.macalester.graphics.Ellipse;

public class Archer implements Entity, Defender {
    
    private static final double RADIUS = 10;
    private static final int RANGE_RADIUS = 100;
    private static final Color SHADOW_COLOR = new Color(128, 128, 128, 20);
    private static final Color ARCHER_COLOR = new Color(97, 29, 173);
    private static final int COST = 50; 
    private static final int SHOT_DAMAGE = 20;


    private double fireRate;
    private Ellipse archer;
    private Ellipse rangeShadow;
    private double x;
    private double y;
    private boolean locked;

    public Archer(double x, double y){
        archer = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        archer.setCenter(x, y);
        rangeShadow = new Ellipse(x, y, RANGE_RADIUS*2, RANGE_RADIUS*2);
        rangeShadow.setCenter(x, y);
        rangeShadow.setFillColor(SHADOW_COLOR);
        archer.setFillColor(ARCHER_COLOR);
        this.x = x;
        this.y = y;
        fireRate = 1;
        locked = false;
    }


    public void attack(Attacker target){
        if(target != null){
            Arrow arrow = new Arrow(this);
            arrow.shoot(target);
            target.takeDamage(SHOT_DAMAGE);
        }
    }

    public void move(double x, double y){
        if(!locked){
            this.getGraphics().setCenter(x, y);
            this.getShadow().setCenter(x, y);
            this.x = x;
            this.y = y;
        }
    }

    public void place(double x, double y){
        if(!locked){
            this.getGraphics().setCenter(x, y);
            this.getShadow().setCenter(x, y);
            this.x = x;
            this.y = y;
            locked = true;
        }
    }

    public Attacker findClosestTarget(ArrayList<Attacker> attackers){
        Attacker closestAttacker = null;
        double closestDist = RANGE_RADIUS;
        for(Attacker attacker : attackers){
            double distance = Math.hypot(Math.abs(archer.getX()-attacker.getX()), Math.abs(archer.getY()-attacker.getY()));
            if(distance < closestDist){
                closestDist = distance;
                closestAttacker = attacker;
            }
        }
        return closestAttacker;
    }

    public void removeShadow(){
        archer.getCanvas().remove(rangeShadow);
    }

    public void addShadow(){
        archer.getCanvas().add(rangeShadow);
    }
    
    public int getCost(){
        return COST;
    }

    public int getRangeRadius(){
        return RANGE_RADIUS;
    }

    public int getDamagePerShot(){
        return SHOT_DAMAGE;
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

    public boolean isLocked(){
        return locked;
    }

    public Ellipse getGraphics(){
        return archer;
    }

    public Ellipse getShadow(){
        return rangeShadow;
    }
}
