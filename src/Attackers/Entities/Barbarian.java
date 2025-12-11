/**
 * This class provides the properties and function of a Barbarian
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

public class Barbarian implements Entity, Attacker, Damagable {
    private static final double RADIUS = 10;
    private static final int COST = 9;
    private static final int STARTING_HEALTH = 20;
    private static final double SPEED = 5;
    private static final int HITS = 1;

    Random random = new Random();
    
    private double x;
    private double y;
    private int health;
    private boolean isAlive;
    private Ellipse barbarian;
    private CanvasWindow canvas;
    private Bank bank = new Bank();
    private ArrayList<Attacker> attackers;
    private double moveX = random.nextDouble(-10, 10);
    private double moveY = random.nextDouble(-10, 10);

    public Barbarian(double x, double y, CanvasWindow canvas, ArrayList<Attacker> attackers){
        this.canvas = canvas;
        this.attackers = attackers;
        this.x = x;
        this.y = y;
        barbarian = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        barbarian.setCenter(x, y);
        barbarian.setFillColor(Color.RED);
        health = STARTING_HEALTH;
        isAlive = true;
    }
    
    /**
     * Randomizes the movement/direction of the barbarian
     */
    public void randomizeMovement(){
        barbarian.moveBy(moveX, moveY);
        x+=moveX;
        y+=moveY;
    }

    /**
     * Move the barbarian on the set path
     */
    public void move(){
        if(getY() < 120){
            barbarian.moveBy(0, SPEED);
            y+=SPEED;
        } 
        else if(getX() < 1330 && getY() < 140){
            barbarian.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 370 && getX() >= 1330){
            barbarian.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() > 120 && getY() < 390){
            barbarian.moveBy(-SPEED, 0);
            x-=SPEED;
        }
        else if(getY() < 615 && getX() <= 120){
            barbarian.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() < 325 && getY() < 635){
            barbarian.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() > 520 && getX() >= 325 && getX() <= 350){
            barbarian.moveBy(0, -SPEED);
            y-=SPEED;
        }
        else if(getX() < 510 && getY() <= 520){
            barbarian.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 620 && getX() >= 510 && getX() <= 535){
            barbarian.moveBy(0, SPEED);
            y+=SPEED;
        }
        else if(getX() < 1330 && getY() >=630){
            barbarian.moveBy(SPEED, 0);
            x+=SPEED;
        }
        else if(getY() < 800 && getX() >= 1330 && getX() <= 1355){
            barbarian.moveBy(0, SPEED);
            y+=SPEED;
        }
        else{
            barbarian.moveBy(SPEED, 0);
            x+=SPEED;
        }

    }

    /**
     * Subtract the given amount of damage from the health of the barbarian and test to see if health hits or goes below zero
     * @param amount of damage
     */
    public void takeDamage(int amount){
        health-=amount;
        if(health <= 0){
            perish();
        }
    }

    /**
     * Check if barbarian has finished the path
     */
    public boolean checkBounds(){
        if(barbarian.getX() > canvas.getWidth() || barbarian.getX() < 0 || barbarian.getY() > canvas.getHeight()){
            this.isAlive = false;
            perish();
            return true;
        }
        return false;
    }

    /**
     * Checks whether the barbarian is alive, if not add money to the bank, if so subtract lives, remove from canvas either way
     */
    public void perish(){
        if(this.isAlive){
            canvas.remove(barbarian);
            attackers.remove(this);
            bank.addMoney(COST);
            this.isAlive = false;
        }
        else {
            canvas.remove(barbarian);
            attackers.remove(this);
            bank.subtractLives(HITS);
        }
    }

    /**
     * @return The health of the barbarian
     */
    public int getHealth(){
        return health;
    }

    /**
     * @return whether the barbarian is alive or not
     */
    public boolean isAlive(){
        return isAlive;
    }

    /**
     * @return x position of the barbarian
     */
    public double getX(){
        return x;
    }

    /**
     * @return y position of the barbarian
     */
    public double getY(){
       return y; 
    }

    /**
     * @return the Ellipse Object of the barbarian on the canvas
     */
    public Ellipse getGraphics(){
        return barbarian;
    }

}
