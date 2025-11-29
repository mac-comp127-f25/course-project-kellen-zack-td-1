package UI;

import java.util.Random;

import Attackers.AttackerManager;
import Defenders.DefenderManager;
import edu.macalester.graphics.CanvasWindow;

public class TowerUI {
    
    public TowerUI(int width, int height, int amount){
        
        Random random = new Random();
        
        CanvasWindow canvas = new CanvasWindow("Tower Defense Game", width, height);
        AttackerManager attackerManager = new AttackerManager(canvas);
        DefenderManager defenderManager = new DefenderManager(canvas);

        for(int i = 0; i < amount; i++){
            attackerManager.createBarbarian(random.nextDouble(canvas.getWidth()), random.nextDouble(canvas.getHeight()));
        }
        defenderManager.createArcher(canvas.getWidth()*2/3, canvas.getHeight()/2);
        canvas.animate(() -> {
            defenderManager.attack(attackerManager.getAttackers());
            attackerManager.move();
        });

    }
}
