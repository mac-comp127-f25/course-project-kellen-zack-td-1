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

    public Barbarian createBarbarian(double x, double y){
        barbarian = new Barbarian(x, y, canvas, attackers);
        attackers.add(barbarian);
        canvas.add(barbarian.getGraphics());
        return barbarian;
    }

    public Golem createGolem(double x, double y){
        golem = new Golem(x, y, canvas, attackers);
        attackers.add(golem);
        canvas.add(golem.getGraphics());
        return golem;
    }

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

    public void moveRandom(){
        for(Attacker attacker : attackers){
            attacker.randomizeMovement();
            if(attacker.checkBounds()){
                return;
            }
        }
    }

    public ArrayList<Attacker> getAttackers(){
        return attackers;
    }
}
