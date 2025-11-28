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
    private static final double HEIGHT = 4;
    private static final Point ARROW_SIZE = new Point(WIDTH, HEIGHT);

    private Rectangle arrow;
    private Point arrowPosition;

    public Arrow(Archer archer){
        this.arrow = new Rectangle(archer.getGraphics().getCenter(), ARROW_SIZE);
        arrowPosition = archer.getGraphics().getCenter();
        archer.getGraphics().getCanvas().add(arrow);
    }

    public void shoot(Attacker attacker){
        for(int i = 0; i < 2; i++){
            arrow.moveBy(new Point((attacker.getX()-arrowPosition.getX())/2, (arrowPosition.getY()-attacker.getY())/2));
            arrow.getCanvas().draw();
        }

    }

    public Rectangle getGraphics(){
        return arrow;
    }
}
