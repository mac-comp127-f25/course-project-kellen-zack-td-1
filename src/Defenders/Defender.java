package Defenders;

import Attackers.Attacker;

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
}
