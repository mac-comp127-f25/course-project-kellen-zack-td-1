package UI;

import edu.macalester.graphics.GraphicsText;

public class Bank {
    
    private static int money;
    private GraphicsText moneyText = new GraphicsText("");
    
    public Bank(int startingMoney){
        money = startingMoney;
        moneyText.setText("$" + money);
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

    public int getMoney(){
        return money;
    }

    public GraphicsText getGraphics(){
        return moneyText;
    }
}
