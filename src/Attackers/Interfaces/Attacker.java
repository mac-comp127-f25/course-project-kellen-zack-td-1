package Attackers.Interfaces;

public interface Attacker {
    
    void move();

    int getHealth();
    boolean isAlive();
    double getX();
    double getY();

    void takeDamage(int amount, int money);

}
