package Attackers.Interfaces;

/**
 * Interface for entities that can take damage
 */
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