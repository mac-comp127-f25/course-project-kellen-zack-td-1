/**
 * This is an interface for all Attckers that can be created
 */

package Attackers.Interfaces;

public interface Attacker {
    
    void randomizeMovement();
    void move();

    int getHealth();
    boolean isAlive();
    double getX();
    double getY();

    void takeDamage(int amount);
    boolean checkBounds();

}
