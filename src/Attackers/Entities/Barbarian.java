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
    private static final int COST = 25;
    private static final int STARTING_HEALTH = 100;
    private static final double SPEED = 5;

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
    
    public void randomizeMovement(){
        barbarian.moveBy(moveX, moveY);
        x+=moveX;
        y+=moveY;
    }

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

    public void takeDamage(int amount){
        health-=amount;
        if(health <= 0){
            perish();
        }
    }

    public boolean checkBounds(){
        if(barbarian.getX() > canvas.getWidth() || barbarian.getX() < 0 || barbarian.getY() > canvas.getHeight() || barbarian.getY() < 0){
            perish();
            return true;
        }
        return false;
    }

    public void perish(){
        if(this.isAlive){
            canvas.remove(barbarian);
            attackers.remove(this);
            bank.addMoney(COST);
            this.isAlive = false;
        }
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
