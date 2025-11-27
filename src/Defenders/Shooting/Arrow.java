package Defenders.Shooting;

import java.util.ArrayList;

import Attackers.Entities.Barbarian;
import Attackers.Interfaces.Attacker;
import Defenders.Entities.Archer;
import Defenders.Interfaces.Shootable;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Arrow implements Shootable{
    
    private static final double WIDTH = 4;
    private static final double HEIGHT = 8;
    private static final Point ARROW_SIZE = new Point(WIDTH, HEIGHT);

    private ArrayList<Attacker> attackers;
    private Rectangle arrow;

    public Arrow(ArrayList<Attacker> attackers, Archer archer){
        this.attackers = new ArrayList<Attacker>(attackers);
        this.arrow = new Rectangle(archer.getGraphics().getCenter(), ARROW_SIZE);
    }

    public void shoot(){
        
    }

    public Attacker findClosestTarget(){
        return new Barbarian(0, 0);
    }

    public Rectangle getGraphics(){
        return arrow;
    }
}
