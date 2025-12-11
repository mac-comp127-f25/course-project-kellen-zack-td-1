/**
 * This class provides the properties and function of a Wizard
 */

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

    /**
     * Make the Wizard shoot a fireball at the provided target
     * @param target
     */
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

    /**
     * This method allows the wizard to be moved by the user
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
     * Sets the position of the wizard and locks it so it cannot be moved again
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
     * @return Attcker which is the closest to the wizard
     */
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

    /**
     * Add a range shadow onto the wizard on the canvas
     */
    public void addShadow(){
        wizard.getCanvas().add(rangeShadow);
    }
    
    /**
     * @return the cost of the wizard
     */
    public int getCost(){
        return COST;
    }

    /**
     * @return the radius of range of the wizard
     */
    public int getRangeRadius(){
        return RANGE_RADIUS;
    }

    /**
     * @return the damage the wizard does to an attacker
     */
    public int getDamagePerShot(){
        return SHOT_DAMAGE;
    }

    /**
     * @return how many frames pass before the wizard shoots each fireball
     */
    public double getFireRate(){
        return FIRERATE;
    }

    /**
     * @return the x position of the wizard
     */
    public double getX(){
        return x;
    }

    /**
     * @return the y position of the wizard
     */
    public double getY(){
        return y;
    }

    /**
     * @return whether the wizard is locked in place or not
     */
    public boolean isLocked(){
        return locked;
    }

    /**
     * @return the Ellipse of the wizard on the canvas
     */
    public Ellipse getGraphics(){
        return wizard;
    }

    /**
     * @return the Ellipse on the canvas of the range shadow on the wizard
     */
    public Ellipse getShadow(){
        return rangeShadow;
    }
}
