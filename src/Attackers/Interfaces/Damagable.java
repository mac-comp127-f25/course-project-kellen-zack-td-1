package Attackers.Interfaces;

/**
 * Interface for entities that can take damage
 */
public interface Damagable {
    
    /**
     * @param amount Damage tak
     * @return True if the entity has died
     */
    boolean takeDamage(int amount);

    /**
     * 
     */
    void perish();

}