import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Line;

import java.awt.Color;
import java.util.ArrayList;

import Attackers.AttackerManager;
import Attackers.Interfaces.Attacker;

public class PathTest {
    public static void main(String[] args) {
        new PathTest();
    }

    private static final Color BACKGROUND_COLOR = new Color(70, 135, 27);

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
