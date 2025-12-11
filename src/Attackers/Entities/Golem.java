/**
 * This class provides the properties and function of a Golem
 */

package Attackers.Entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Attackers.Interfaces.Attacker;
import Attackers.Interfaces.Damagable;
import Overall.Entity;
import UI.Bank;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Golem implements Entity, Attacker, Damagable {
    private static final double RADIUS = 10;
    private static final int COST = 250;
    private static final int STARTING_HEALTH = 200;
    private static final double SPEED = 3;
    private static final int HITS = 10;

    Random random = new Random();
    
    private double x;
    private double y;
    private int health;
    private boolean isAlive;
    private Ellipse golem;
    private CanvasWindow canvas;
    private Bank bank = new Bank();
    private ArrayList<Attacker> attackers;
    private double moveX = random.nextDouble(-10, 10);
    private double moveY = random.nextDouble(-10, 10);

    public Golem(double x, double y, CanvasWindow canvas, ArrayList<Attacker> attackers){
        this.canvas = canvas;
        this.attackers = attackers;
        this.x = x;
        this.y = y;
        golem = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        golem.setCenter(x, y);
        golem.setFillColor(Color.YELLOW);
        health = STARTING_HEALTH;
        isAlive = true;
    }
    
    /**
     * Randomizes the movement/direction of the golem
     */
    public void randomizeMovement(){
        golem.moveBy(moveX, moveY);
        x+=moveX;
        y+=moveY;
    }

    /**
     * Move the golem on the set path
     */
    public void move(){
        if(getY() < 120){
            golem.moveBy(0, SPEED);
            y+=SPEED;
        } 
        else if(getX() < 1330 && getY() < 140){
            golem.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 370 && getX() >= 1330){
            golem.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() > 120 && getY() < 390){
            golem.moveBy(-SPEED, 0);
            x-=SPEED;
        }
        else if(getY() < 615 && getX() <= 120){
            golem.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() < 325 && getY() < 635){
            golem.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() > 520 && getX() >= 325 && getX() <= 350){
            golem.moveBy(0, -SPEED);
            y-=SPEED;
        }
        else if(getX() < 510 && getY() <= 520){
            golem.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 620 && getX() >= 510 && getX() <= 535){
            golem.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() < 1330 && getY() >=630){
            golem.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 800 && getX() >= 1330 && getX() <= 1355){
            golem.moveBy(0, SPEED);
            y+=SPEED;
        }
        else{
            golem.moveBy(SPEED, 0);
            x+=SPEED;
        }

    }

    /**
     * Subtract the given amount of damage from the health of the golem and test to see if health hits or goes below zero
     * @param amount of damage
     */
    public void takeDamage(int amount){
        health-=amount;
        if(health <= 0){
            perish();
        }
    }

    /**
     * Check if golem has finished the path
     */
    public boolean checkBounds(){
        if(golem.getX() > canvas.getWidth() || golem.getX() < 0 || golem.getY() > canvas.getHeight()){
            this.isAlive = false;
            perish();
            return true;
        }
        return false;
    }

    /**
     * Checks whether the golem is alive, if not add money to the bank, if so subtract lives, remove from canvas either way
     */
    public void perish(){
        if(this.isAlive){
            canvas.remove(golem);
            attackers.remove(this);
            bank.addMoney(COST);
            this.isAlive = false;
        }
        else {
            canvas.remove(golem);
            attackers.remove(this);
            bank.subtractLives(HITS);
        }
    }

    /**
     * @return The health of the golem
     */
    public int getHealth(){
        return health;
    }

    /**
     * @return whether the golem is alive or not
     */
    public boolean isAlive(){
        return isAlive;
    }

    /**
     * @return x position of the golem
     */
    public double getX(){
        return x;
    }

    /**
     * @return y position of the golem
     */
    public double getY(){
       return y; 
    }

    /**
     * @return the Ellipse Object of the golem on the canvas
     */
    public Ellipse getGraphics(){
        return golem;
    }
}
