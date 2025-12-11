/**
 * Interface for all entities on the screen
 */

package Overall;

import edu.macalester.graphics.Ellipse;

public interface Entity {
    
    Ellipse getGraphics();
    double getX();
    double getY();

}
