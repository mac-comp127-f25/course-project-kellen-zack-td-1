/**
 * This class provides the properties and function of an Archer
 */

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
    private static final int RANGE_RADIUS = 115;
    private static final Color SHADOW_COLOR = new Color(128, 128, 128, 20);
    private static final Color ARCHER_COLOR = new Color(97, 29, 173);
    private static final int COST = 50; 
    private static final int SHOT_DAMAGE = 20;
    private static final int FIRERATE = 30;

    
    private Ellipse archer;
    private Ellipse rangeShadow;
    private double x;
    private double y;
    private boolean locked;
    private int frame = 0;

    public Archer(double x, double y){
        archer = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        archer.setCenter(x, y);
        rangeShadow = new Ellipse(x, y, RANGE_RADIUS*2, RANGE_RADIUS*2);
        rangeShadow.setCenter(x, y);
        rangeShadow.setFillColor(SHADOW_COLOR);
        archer.setFillColor(ARCHER_COLOR);
        this.x = x;
        this.y = y;
        locked = false;
    }

    /**
     * Make the Archer shoot an arrow at the provided target
     * @param target
     */
    public void attack(Attacker target){
        if(target != null && locked){
            if(frame < FIRERATE){
                frame++;
            }
            else{
                Arrow arrow = new Arrow(this);
                arrow.shoot(target);
                target.takeDamage(SHOT_DAMAGE);
                frame = 0;
            }
        }
    }

    /**
     * This method allows the archer to be moved by the user
     * @param x
     * @param y
     */
    public void move(double x, double y){
        if(!locked){
            this.getGraphics().setCenter(x, y);
            this.getShadow().setCenter(x, y);
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Sets the position of the archer and locks it so it cannot be moved again
     * @param x
     * @param y
     */
    public void place(double x, double y){
        if(!locked){
            this.getGraphics().setCenter(x, y);
            this.getShadow().setCenter(x, y);
            this.x = x;
            this.y = y;
            locked = true;
        }
    }

    /**
     * @param attackers
     * @return Attcker which is the closest to the archer
     */
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

    /**
     * Add a range shadow onto the archer on the canvas
     */
    public void addShadow(){
        archer.getCanvas().add(rangeShadow);
    }
    
    /**
     * @return the cost of the archer
     */
    public int getCost(){
        return COST;
    }

    /**
     * @return the radius of range of the archer
     */
    public int getRangeRadius(){
        return RANGE_RADIUS;
    }

    /**
     * @return the damage the archer does to an attacker
     */
    public int getDamagePerShot(){
        return SHOT_DAMAGE;
    }

    /**
     * @return how many frames pass before the archer shoots each arrow
     */
    public double getFireRate(){
        return FIRERATE;
    }

    /**
     * @return the x position of the archer
     */
    public double getX(){
        return x;
    }

    /**
     * @return the y position of the archer
     */
    public double getY(){
        return y;
    }

    /**
     * @return whether the archer is locked in place or not
     */
    public boolean isLocked(){
        return locked;
    }

    /**
     * @return the Ellipse of the archer on the canvas
     */
    public Ellipse getGraphics(){
        return archer;
    }

    /**
     * @return the Ellipse on the canvas of the range shadow on the archer
     */
    public Ellipse getShadow(){
        return rangeShadow;
    }
}
