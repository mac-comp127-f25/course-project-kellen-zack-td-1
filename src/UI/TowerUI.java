package UI;

import java.util.Random;

import Attackers.AttackerManager;
import Defenders.DefenderManager;
import edu.macalester.graphics.CanvasWindow;

public class TowerUI {
    
    public TowerUI(int width, int height){
        
        Random random = new Random();
        
        CanvasWindow canvas = new CanvasWindow("Tower Defense Game", width, height);
        AttackerManager attackerManager = new AttackerManager(canvas);
        DefenderManager defenderManager = new DefenderManager(canvas);

        // canvas.onClick(e -> {
        //     defenderManager.createArcher(e.getPosition().getX(), e.getPosition().getY(), attackerManager.getAttackers());
        // });
        for(int i = 0; i < 10; i++){
            attackerManager.createBarbarian(random.nextDouble(canvas.getWidth()), random.nextDouble(canvas.getHeight()));
        }
        defenderManager.createArcher(canvas.getWidth()*2/3, canvas.getHeight()/2);
        canvas.animate(() -> {
            defenderManager.attack(attackerManager.getAttackers());
        });

    }
}
