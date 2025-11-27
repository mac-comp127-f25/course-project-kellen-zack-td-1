package Defenders.Shooting;

import java.util.ArrayList;

import Attackers.Interfaces.Attacker;
import Defenders.Interfaces.Shootable;

public class Arrow implements Shootable{
    
    private ArrayList<Attacker> attackers;

    public Arrow(ArrayList<Attacker> attackers){
        this.attackers = new ArrayList<Attacker>(attackers);
    }

    public void shoot(Attacker attacker){

    }
}
