package UI;

import java.util.Random;

import Attackers.AttackerManager;
import Defenders.DefenderManager;
import Defenders.Entities.Archer;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

public class TowerUI {
    private Random random = new Random();

    private CanvasWindow canvas;
    private Button addArcherButton;
    private Button addAttackersButton;
    private DefenderManager defenderManager;
    private AttackerManager attackerManager;
    private Archer archer;
    
    public TowerUI(int width, int height, int amount){
        
        canvas = new CanvasWindow("Tower Defense Game", width, height);
        attackerManager = new AttackerManager(canvas);
        defenderManager = new DefenderManager(canvas);

        for(int i = 0; i < amount; i++){
            attackerManager.createBarbarian(random.nextDouble(canvas.getWidth()), random.nextDouble(canvas.getHeight()));
        }
        defenderManager.createArcher(canvas.getWidth()*2/3, canvas.getHeight()/2);
        canvas.animate(() -> {
            defenderManager.attack(attackerManager.getAttackers());
            attackerManager.move();
        });

    }

    public TowerUI(int width, int height){
        canvas = new CanvasWindow("Tower Defense Game", width, height);
        attackerManager = new AttackerManager(canvas);
        defenderManager = new DefenderManager(canvas);

        setUpButtons();
        canvas.animate(() -> {
            defenderManager.attack(attackerManager.getAttackers());
            //attackerManager.move();
        });

    }

    public void setUpButtons(){
        addArcherButton = new Button("Archer: $50");
        canvas.add(addArcherButton);
        addArcherButton.onClick(() -> {
            archer = defenderManager.createArcher(addArcherButton.getX(), addArcherButton.getY());
            if(!archer.isLocked()){
                handleButtons();
            }
        });

        addAttackersButton = new Button("Add Attackers");
        addAttackersButton.setPosition(0, addArcherButton.getHeight());
        canvas.add(addAttackersButton);
        addAttackersButton.onClick(() -> {
            for(int i = 0; i < 10; i++){
                attackerManager.createBarbarian(random.nextDouble(canvas.getWidth()), random.nextDouble(canvas.getHeight()));
            }
        });

        Button moveAttackers = new Button("Move Attackers");
        moveAttackers.setPosition(0, addAttackersButton.getHeight()*2);
        canvas.add(moveAttackers);
        moveAttackers.onClick(() -> {
            canvas.animate(() -> {
                attackerManager.move();
            });
        });


    }

    public void handleButtons(){
        canvas.onDrag(e -> {
            archer.move(e.getPosition().getX(), e.getPosition().getY());
        });
        canvas.onMouseUp(e -> {
            archer.place(e.getPosition().getX(), e.getPosition().getY());
            System.out.println(archer.isLocked());
        });
    }
}
