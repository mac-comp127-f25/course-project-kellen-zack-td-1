/**
 * This class is a manager for all attacker objects
 */

package Attackers;

import java.util.ArrayList;

import Attackers.Entities.Barbarian;
import Attackers.Entities.Golem;
import Attackers.Interfaces.Attacker;
import edu.macalester.graphics.CanvasWindow;

public class AttackerManager {

    private ArrayList<Attacker> attackers;
    private CanvasWindow canvas;
    private Barbarian barbarian;
    private Golem golem;

    public AttackerManager(CanvasWindow canvas){
        attackers = new ArrayList<Attacker>();
        this.canvas = canvas;
    }

    /**
     * Create a barbarian at the x and y provided and add to the canvas
     * @param x
     * @param y
     * @return the Barbarian Object created
     */
    public Barbarian createBarbarian(double x, double y){
        barbarian = new Barbarian(x, y, canvas, attackers);
        attackers.add(barbarian);
        canvas.add(barbarian.getGraphics());
        return barbarian;
    }

    /**
     * Create a Golem at the x and y provided and add to the canvas
     * @param x
     * @param y
     * @return the Golem Object created
     */
    public Golem createGolem(double x, double y){
        golem = new Golem(x, y, canvas, attackers);
        attackers.add(golem);
        canvas.add(golem.getGraphics());
        return golem;
    }

    /**
     * Moves each attacker along the set path and check if the attacker is out of bounds of the canvas
     */
    public void move(){
        if(attackers.isEmpty()){
            return;
        }
        for(Attacker attacker : attackers){
            attacker.move();
            if(attacker.checkBounds()){
                return;
            }
        }
    }

    /**
     * This method is for the test class which moves each attacker in a random way
     */
    public void moveRandom(){
        for(Attacker attacker : attackers){
            attacker.randomizeMovement();
            if(attacker.checkBounds()){
                return;
            }
        }
    }

    /**
     * @return the list of all attackers created
     */
    public ArrayList<Attacker> getAttackers(){
        return attackers;
    }
}
