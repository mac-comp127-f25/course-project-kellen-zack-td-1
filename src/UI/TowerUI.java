package UI;

import java.util.Random;

import Attackers.AttackerManager;
import Defenders.DefenderManager;
import Defenders.Entities.Archer;
import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

public class TowerUI {
    private static final int STARTING_MONEY = 100;
    
    private Random random = new Random();

    private CanvasWindow canvas;
    private Button addArcherButton;
    private Button addAttackersButton;
    private DefenderManager defenderManager;
    private AttackerManager attackerManager;
    private Archer archer;
    private int money;

    public TowerUI(int width, int height){
        canvas = new CanvasWindow("Tower Defense Game", width, height);
        attackerManager = new AttackerManager(canvas);
        defenderManager = new DefenderManager(canvas);
        money = STARTING_MONEY;
        

        setUpButtons();
        canvas.animate(() -> {
            defenderManager.attack(attackerManager.getAttackers(), money);
        });

    }

    public void setUpButtons(){
        addArcherButton = new Button("Archer: $50");
        canvas.add(addArcherButton);
        addArcherButton.onClick(() -> {
                archer = defenderManager.createArcher(addArcherButton.getX(), addArcherButton.getY());
                handleArcherButton();
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

    public void handleArcherButton(){
        canvas.onDrag(e -> {
            archer.move(e.getPosition().getX(), e.getPosition().getY());
        });
        canvas.onMouseUp(e -> {
            archer.place(e.getPosition().getX(), e.getPosition().getY());
        });
    }
}
