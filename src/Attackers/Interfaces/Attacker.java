package Attackers.Interfaces;

public interface Attacker {
    
    void randomizeMovement();
    void move();

    int getHealth();
    boolean isAlive();
    double getX();
    double getY();

    void takeDamage(int amount, int money);
    boolean checkBounds();

}
