package UI;

import edu.macalester.graphics.GraphicsText;

public class Bank {
    
    private static int money;
    private GraphicsText moneyText = new GraphicsText("");
    private static int lives;
    private GraphicsText livesText = new GraphicsText("");
    
    public Bank(int startingMoney, int startingLives){
        money = startingMoney;
        moneyText.setText("$" + money);

        lives = startingLives;
        livesText.setText("Lives: " + startingLives);
    }

    public Bank(){

    }

    public int addMoney(int amount){
        money += amount;
        moneyText.setText("$" + money);
        return money;
    }

    public int subtractMoney(int amount){
        money -= amount;
        moneyText.setText("$" + money);
        return money;
    }

    public void updateMoney(){
        moneyText.setText("$" + money);
    }

    public int subtractLives(int amount){
        lives -= amount;
        livesText.setText("Lives: " + lives);
        return lives;
    }

    public void updateLives(){
        livesText.setText("Lives: " + lives);
    }

    public int getMoney(){
        return money;
    }

    public GraphicsText getMoneyGraphics(){
        return moneyText;
    }

    public int getLives(){
        return lives;
    }

    public GraphicsText getLivesGraphics(){
        return livesText;
    }
}
