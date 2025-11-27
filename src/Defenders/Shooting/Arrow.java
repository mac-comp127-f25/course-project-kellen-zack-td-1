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

    private Rectangle arrow;

    public Arrow(Archer archer){
        this.arrow = new Rectangle(archer.getGraphics().getCenter(), ARROW_SIZE);
    }

    public void shoot(Attacker attacker){
        
    }

    public Rectangle getGraphics(){
        return arrow;
    }
}
