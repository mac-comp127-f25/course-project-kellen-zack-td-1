package Defenders;

import java.util.ArrayList;

import Attackers.Interfaces.Attacker;
import Defenders.Entities.Archer;
import Defenders.Interfaces.Defender;
import edu.macalester.graphics.CanvasWindow;

public class DefenderManager {
    
    private ArrayList<Defender> defenders;
    private CanvasWindow canvas;
    private Archer archer;

    public DefenderManager(CanvasWindow canvas){
        defenders = new ArrayList<Defender>();
        this.canvas = canvas;
    }

    public Archer createArcher(double x, double y){
        archer = new Archer(x, y);
        defenders.add(archer);
        canvas.add(archer.getGraphics());
        archer.addShadow();
        return archer;
    }

    public void attack(ArrayList<Attacker> attackers, int money){
        for(Defender defender : defenders){
            defender.attack(defender.findClosestTarget(attackers), money);
        }
    }

    public ArrayList<Defender> getDefenders(){
        return defenders;
    }
}
