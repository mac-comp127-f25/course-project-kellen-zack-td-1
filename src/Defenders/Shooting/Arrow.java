package Defenders.Shooting;

import java.awt.Color;

import Attackers.Interfaces.Attacker;
import Defenders.Entities.Archer;
import Defenders.Interfaces.Shootable;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Arrow implements Shootable{
    
    private static final double SQUARE_WIDTH = 6;
    private static final Point ARROW_SIZE = new Point(SQUARE_WIDTH, SQUARE_WIDTH);

    private Rectangle arrow;
    private Point arrowPosition;
    private Archer archer;

    public Arrow(Archer archer){
        arrow = new Rectangle(new Point(0, 0), ARROW_SIZE);
        arrow.setCenter(archer.getGraphics().getCenter());
        arrow.setFillColor(Color.PINK);
        this.archer = archer;
        arrowPosition = archer.getGraphics().getCenter();
        archer.getGraphics().getCanvas().add(arrow);
    }


    //TODO: Figure out math for shooting at moving targets
    public void shoot(Attacker attacker){
        final int SPEED = 2;
        archer.getGraphics().getCanvas().draw();
        for(int i = 0; i < SPEED; i++){
            double moveX = (attacker.getX()-arrowPosition.getX())/SPEED;
            double moveY = (attacker.getY()-arrowPosition.getY())/SPEED;
            arrow.moveBy(moveX, moveY);
            archer.getGraphics().getCanvas().draw();
        }
        archer.getGraphics().getCanvas().remove(arrow);
    }

    public Rectangle getGraphics(){
        return arrow;
    }
}
