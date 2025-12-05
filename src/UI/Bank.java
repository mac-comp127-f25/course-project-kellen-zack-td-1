package UI;

import edu.macalester.graphics.GraphicsText;

public class Bank {
    
    private int money;
    private GraphicsText moneyText = new GraphicsText("");
    
    public Bank(int money){

        this.money = money;
        moneyText.setText("$" + money);
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

    public int getMoney(){
        return money;
    }

    public GraphicsText getGraphics(){
        return moneyText;
    }
}
