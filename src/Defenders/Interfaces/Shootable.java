/**
 * Interface for all things defenders can shoot
 */

package Defenders.Interfaces;

import Attackers.Interfaces.Attacker;

public interface Shootable {
    
    void shoot(Attacker attacker);
}
