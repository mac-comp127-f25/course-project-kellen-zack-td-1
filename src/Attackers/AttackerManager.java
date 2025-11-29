package Attackers;

import java.util.ArrayList;

import Attackers.Entities.Barbarian;
import Attackers.Interfaces.Attacker;
import Defenders.Interfaces.Defender;
import edu.macalester.graphics.CanvasWindow;

public class AttackerManager {

    private ArrayList<Attacker> attackers;
    private CanvasWindow canvas;
    private Barbarian barbarian;

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

    public ArrayList<Attacker> getAttackers(){
        return attackers;
    }
}
