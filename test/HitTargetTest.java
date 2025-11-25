import Attackers.Entities.Barbarian;
import Defenders.Entities.Archer;
import edu.macalester.graphics.CanvasWindow;

public class HitTargetTest {
    public static void main(String[] args) {
        
        CanvasWindow canvas = new CanvasWindow("Target Hit Test", 1200,600);
        
        canvas.add(new Barbarian(canvas.getWidth()/3, canvas.getHeight()/2).getGraphics());
        canvas.add(new Archer(canvas.getWidth()*2/3, canvas.getHeight()/2).getGraphics());
    }
}
