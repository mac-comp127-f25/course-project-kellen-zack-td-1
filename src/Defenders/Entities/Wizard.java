package Defenders.Entities;

import java.awt.Color;
import java.util.ArrayList;

import Attackers.Interfaces.Attacker;
import Defenders.Interfaces.Defender;
import Defenders.Shooting.Fireball;
import Overall.Entity;
import edu.macalester.graphics.Ellipse;

public class Wizard implements Entity, Defender{
    private static final double RADIUS = 10;
    private static final int RANGE_RADIUS = 130;
    private static final Color SHADOW_COLOR = new Color(128, 128, 128, 20);
    private static final Color WIZARD_COLOR = Color.ORANGE;
    private static final int COST = 500; 
    private static final int SHOT_DAMAGE = 60;
    private static final int FIRERATE = 20;

    
    private Ellipse wizard;
    private Ellipse rangeShadow;
    private double x;
    private double y;
    private boolean locked;
    private int frame = 0;

    public Wizard(double x, double y){
        wizard = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        wizard.setCenter(x, y);
        rangeShadow = new Ellipse(x, y, RANGE_RADIUS*2, RANGE_RADIUS*2);
        rangeShadow.setCenter(x, y);
        rangeShadow.setFillColor(SHADOW_COLOR);
        wizard.setFillColor(WIZARD_COLOR);
        this.x = x;
        this.y = y;
        locked = false;
    }


    public void attack(Attacker target){
        if(target != null && locked){
            if(frame < FIRERATE){
                frame++;
            }
            else{
                Fireball fireball = new Fireball(this);
                fireball.shoot(target);
                target.takeDamage(SHOT_DAMAGE);
                frame = 0;
            }
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
            double distance = Math.hypot(Math.abs(wizard.getX()-attacker.getX()), Math.abs(wizard.getY()-attacker.getY()));
            if(distance < closestDist){
                closestDist = distance;
                closestAttacker = attacker;
            }
        }
        return closestAttacker;
    }

    public void removeShadow(){
        wizard.getCanvas().remove(rangeShadow);
    }

    public void addShadow(){
        wizard.getCanvas().add(rangeShadow);
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
        return FIRERATE;
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
        return wizard;
    }

    public Ellipse getShadow(){
        return rangeShadow;
    }
}
