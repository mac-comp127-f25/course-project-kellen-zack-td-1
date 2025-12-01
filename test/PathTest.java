import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.Rectangle;

import java.awt.Color;
import java.util.ArrayList;

import Attackers.AttackerManager;
import Attackers.Interfaces.Attacker;

public class PathTest {
    public static void main(String[] args) {
        new PathTest();
    }

    private static final Color BACKGROUND_COLOR = new Color(70, 135, 27);
    private static final Color PATH_COLOR = Color.GRAY;

    private CanvasWindow canvas;
    private ArrayList<Attacker> attackers;

    public PathTest(){
        canvas = new CanvasWindow("Path Test", 1500, 850);
        canvas.setBackground(BACKGROUND_COLOR);
        AttackerManager attackerManager = new AttackerManager(canvas);
        attackers = attackerManager.getAttackers();

        makePath();
        moveAttackers();
    }

    public void makePath(){
        GraphicsGroup path = new GraphicsGroup();
        Rectangle brick1 = new Rectangle(100, 0, 40, 150);
        brick1.setFillColor(PATH_COLOR);
        brick1.setStroked(false);
        path.add(brick1);
        Rectangle brick2 = new Rectangle(140, 110, 150, 40);
        brick2.setFillColor(PATH_COLOR);
        brick2.setStroked(false);
        path.add(brick2);
        path.add(brick2);
        canvas.add(path);
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
}
