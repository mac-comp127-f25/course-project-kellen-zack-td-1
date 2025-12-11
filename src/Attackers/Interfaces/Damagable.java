/**
 * Interface for entities that can take damage
 */

package Attackers.Interfaces;

public interface Damagable {
    
    /**
     * @param amount Damage taken
     */
    void takeDamage(int amount);

    /**
     * 
     */
    void perish();

}