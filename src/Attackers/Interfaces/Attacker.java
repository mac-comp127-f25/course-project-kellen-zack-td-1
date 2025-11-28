package Attackers.Interfaces;

public interface Attacker {
    
    void move();

    int getHealth();
    boolean isAlive();
    double getX();
    double getY();

    boolean takeDamage(int amount);

}
