package Defenders.Shooting;

import java.awt.Color;

import Attackers.Interfaces.Attacker;
import Defenders.Entities.Wizard;
import edu.macalester.graphics.Point;
import edu.macalester.graphics.Rectangle;

public class Fireball {
    private static final double SQUARE_WIDTH = 6;
    private static final Point ARROW_SIZE = new Point(SQUARE_WIDTH, SQUARE_WIDTH);

    private Rectangle fireball;
    private Point arrowPosition;
    private Wizard wizard;

    public Fireball(Wizard wizard){
        fireball = new Rectangle(new Point(0, 0), ARROW_SIZE);
        fireball.setCenter(wizard.getGraphics().getCenter());
        fireball.setFillColor(Color.PINK);
        this.wizard = wizard;
        arrowPosition = wizard.getGraphics().getCenter();
        wizard.getGraphics().getCanvas().add(fireball);
    }

    public void shoot(Attacker attacker){
        final int SPEED = 2;
        wizard.getGraphics().getCanvas().draw();
        for(int i = 0; i < SPEED; i++){
            double moveX = (attacker.getX()-arrowPosition.getX())/SPEED;
            double moveY = (attacker.getY()-arrowPosition.getY())/SPEED;
            fireball.moveBy(moveX, moveY);
            wizard.getGraphics().getCanvas().draw();
        }
        wizard.getGraphics().getCanvas().remove(fireball);
    }

    public Rectangle getGraphics(){
        return fireball;
    }
}
