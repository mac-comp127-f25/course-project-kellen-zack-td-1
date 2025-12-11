/**
 * Interface for all defenders in the game
 */

package Defenders.Interfaces;

import java.util.ArrayList;

import Attackers.Interfaces.Attacker;

public interface Defender {
    int getCost();
    int getRangeRadius();
    int getDamagePerShot();
    double getFireRate();

    void attack(Attacker target);
    void place(double x, double y);
    void addShadow();
    Attacker findClosestTarget(ArrayList<Attacker> attackers);
}
