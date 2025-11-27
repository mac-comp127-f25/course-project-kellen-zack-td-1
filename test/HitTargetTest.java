import Attackers.AttackerManager;
import Defenders.DefenderManager;
import edu.macalester.graphics.CanvasWindow;

public class HitTargetTest {
    public static void main(String[] args) {
        
        CanvasWindow canvas = new CanvasWindow("Target Hit Test", 1200,600);
        AttackerManager attackerManager = new AttackerManager(canvas);
        DefenderManager defenderManager = new DefenderManager(canvas);
        
        attackerManager.createBarbarian(canvas.getWidth()/3, canvas.getHeight()/2);
        defenderManager.createArcher(canvas.getWidth()*2/3, canvas.getHeight()/2);
    }
}
