package UI;

import Attackers.AttackerManager;
import Defenders.DefenderManager;
import Defenders.Interfaces.Defender;
import edu.macalester.graphics.CanvasWindow;

public class TowerUI {
    
    public TowerUI(int width, int height){
        CanvasWindow canvas = new CanvasWindow("Tower Defense Game", width, height);
        AttackerManager attackerManager = new AttackerManager(canvas);
        DefenderManager defenderManager = new DefenderManager(canvas);

        canvas.onClick(e -> {
            defenderManager.createArcher(e.getPosition().getX(), e.getPosition().getY());
        });

    }
}
