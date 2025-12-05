import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;

import Attackers.AttackerManager;
import Attackers.Interfaces.Attacker;
import UI.Bank;

public class PathTest {
    public static void main(String[] args) {
        new PathTest();
    }

    private static final Color BACKGROUND_COLOR = new Color(70, 135, 27);
    private static final Color PATH_COLOR = Color.GRAY;

    private CanvasWindow canvas;
    private ArrayList<Attacker> attackers;
    private Bank bank = new Bank(100);

    public PathTest(){
        canvas = new CanvasWindow("Path Test", 1500, 850);
        canvas.setBackground(BACKGROUND_COLOR);
        AttackerManager attackerManager = new AttackerManager(canvas);
        attackers = attackerManager.getAttackers();

        makePath();

        for(int i = -10; i > -1500; i-=10){
            attackerManager.createBarbarian(120, i, bank);
        }

        moveAttackers();
    }

    /**
     * Animate the canvas to visually move attackers along the path that is set on the canvas
     */
    public void moveAttackers(){
        canvas.animate(() -> {
            for(Attacker attacker : attackers){
                attacker.move();
            }
        });
    }

    public static final double BRICK_LENGTH = 250;
    public static final double BRICK_WIDTH = 40;

    /**
     * Create the gray path running through the map
     */
    public void makePath(){
        GraphicsGroup path = new GraphicsGroup();
        Rectangle brick1 = new Rectangle(100, 0, BRICK_WIDTH, BRICK_LENGTH/2.5);
        brick1.setFillColor(PATH_COLOR);
        brick1.setStroked(false);

        Rectangle brick2 = new Rectangle(100, BRICK_LENGTH/2.5, BRICK_LENGTH*5, BRICK_WIDTH);
        brick2.setFillColor(PATH_COLOR);
        brick2.setStroked(false);

        Rectangle brick3 = new Rectangle(BRICK_LENGTH*5+100-BRICK_WIDTH, BRICK_LENGTH/2.5+BRICK_WIDTH-1, BRICK_WIDTH, BRICK_LENGTH);
        brick3.setFillColor(PATH_COLOR);
        brick3.setStroked(false);

        Rectangle brick4 = new Rectangle(100, BRICK_LENGTH/2.5+BRICK_LENGTH, BRICK_LENGTH*5, BRICK_WIDTH);
        brick4.setFillColor(PATH_COLOR);
        brick4.setStroked(false);

        Rectangle brick5 = new Rectangle(100, BRICK_LENGTH/2.5+BRICK_LENGTH, BRICK_WIDTH, BRICK_LENGTH);
        brick5.setFillColor(PATH_COLOR);
        brick5.setStroked(false);

        Rectangle brick6 = new Rectangle(100, BRICK_LENGTH*2.4-1, BRICK_LENGTH, BRICK_WIDTH);
        brick6.setFillColor(PATH_COLOR);
        brick6.setStroked(false);

        Rectangle brick7 = new Rectangle(60+BRICK_LENGTH, BRICK_LENGTH*2, BRICK_WIDTH, BRICK_LENGTH*.4);
        brick7.setFillColor(PATH_COLOR);
        brick7.setStroked(false);

        Rectangle brick8 = new Rectangle(100+BRICK_LENGTH-1, BRICK_LENGTH*2, BRICK_LENGTH*.6, BRICK_WIDTH);
        brick8.setFillColor(PATH_COLOR);
        brick8.setStroked(false);

        Rectangle brick9 = new Rectangle(100+BRICK_LENGTH+BRICK_LENGTH*.6-2, BRICK_LENGTH*2, BRICK_WIDTH, BRICK_LENGTH*.4+BRICK_WIDTH);
        brick9.setFillColor(PATH_COLOR);
        brick9.setStroked(false);

        Rectangle brick10 = new Rectangle(100+BRICK_LENGTH+BRICK_LENGTH*.6-3+BRICK_WIDTH, BRICK_LENGTH*2.4, BRICK_LENGTH*3.1, BRICK_WIDTH);
        brick10.setFillColor(PATH_COLOR);
        brick10.setStroked(false);

        Rectangle brick11 = new Rectangle(BRICK_LENGTH*5+100-BRICK_WIDTH, BRICK_LENGTH*2.4, BRICK_WIDTH, BRICK_LENGTH*.85);
        brick11.setFillColor(PATH_COLOR);
        brick11.setStroked(false);

        Rectangle brick12 = new Rectangle(BRICK_LENGTH*5+100-BRICK_WIDTH, BRICK_LENGTH*2.4+BRICK_LENGTH*.85-BRICK_WIDTH, BRICK_LENGTH, BRICK_WIDTH);
        brick12.setFillColor(PATH_COLOR);
        brick12.setStroked(false);


        path.add(brick1);
        path.add(brick2);
        path.add(brick3);
        path.add(brick4);
        path.add(brick5);
        path.add(brick6);
        path.add(brick7);
        path.add(brick8);
        path.add(brick9);
        path.add(brick10);
        path.add(brick11);
        path.add(brick12);
        canvas.add(path);
    }
}
