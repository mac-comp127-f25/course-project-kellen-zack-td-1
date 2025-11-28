package Defenders.Interfaces;

import java.util.ArrayList;

import Attackers.Interfaces.Attacker;

/**
 * Interface outlining things all attackers can do
 */
public interface Defender {
    int getCost();
    int getRangeRadius();
    int getDamagePerShot();
    double getFireRate();

    void attack(Attacker target);
    void place();
    void removeShadow();
    void addShadow();
    Attacker findClosestTarget(ArrayList<Attacker> attackers);
}
