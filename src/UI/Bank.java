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

    /**
     * Adds the amount given to the static money variable
     * @param amount
     * @return The current amount of total money
     */
    public int addMoney(int amount){
        money += amount;
        moneyText.setText("$" + money);
        return money;
    }

    /**
     * Adds the amount given to the static money variable
     * @param amount
     * @return The current amount of total money
     */
    public int subtractMoney(int amount){
        money -= amount;
        moneyText.setText("$" + money);
        return money;
    }

    /**
     * Updates the text in the GraphicsText Object for money
     */
    public void updateMoney(){
        moneyText.setText("$" + money);
    }

    /**
     * Subtratcs the amount given from the static lives variable
     * @param amount
     * @return amount of total lives left
     */
    public int subtractLives(int amount){
        lives -= amount;
        livesText.setText("Lives: " + lives);
        return lives;
    }

    /**
     * Updates the text in the GraphicsText Object for lives
     */
    public void updateLives(){
        livesText.setText("Lives: " + lives);
    }

    /**
     * @return total money
     */
    public int getMoney(){
        return money;
    }

    /**
     * @return GraphicsText Object for displaying money
     */
    public GraphicsText getMoneyGraphics(){
        return moneyText;
    }

    /**
     * @return total lives
     */
    public int getLives(){
        return lives;
    }

    /**
     * @return GraphicsText Object for displaying lives
     */
    public GraphicsText getLivesGraphics(){
        return livesText;
    }
}
