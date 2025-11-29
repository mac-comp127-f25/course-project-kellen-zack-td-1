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
        this.barbarian = new Ellipse(x, y, RADIUS*2, RADIUS*2);
        barbarian.setCenter(x, y);
        barbarian.setFillColor(Color.RED);
        this.canvas = canvas;
        this.attackers = attackers;
        this.x = x;
        this.y = y;
        this.health = 20;
        this.isAlive = true;
    }
    
    public void move(){
        barbarian.moveBy(moveX, moveY);
        x+=moveX;
        y+=moveY;
        barbarian.getCanvas().draw();
    }

    public void takeDamage(int amount){
        health-=amount;
        if(health <= 0){
            perish();
        }
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
