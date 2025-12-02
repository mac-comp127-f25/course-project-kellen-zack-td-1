package Attackers.Entities;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import Attackers.Interfaces.Attacker;
import Attackers.Interfaces.Damagable;
import Overall.Entity;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;

public class Barbarian implements Entity, Attacker, Damagable {
    private static final double RADIUS = 10;
    private static final int COST = 25;
    private static final int STARTING_HEALTH = 100;
    private static final double SPEED = 12;

    Random random = new Random();
    
    private double x;
    private double y;
    private int health;
    private boolean isAlive;
    private Ellipse barbarian;
    private CanvasWindow canvas;
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
        barbarian.getCanvas().draw();
    }

    public void move(){
        //Find a way to use a point coordinate system to move from point to point one after another
    }

    public void takeDamage(int amount, int money){
        health-=amount;
        if(health <= 0){
            perish();
            money+=COST;
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
