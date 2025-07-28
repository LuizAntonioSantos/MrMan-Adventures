package chon.group.game;

import java.util.ArrayList;
import java.util.List;

import chon.group.game.core.agent.Agent;
import chon.group.game.core.agent.Object;
import chon.group.game.core.animation.AnimationGraphics;
import chon.group.game.core.animation.AnimationSpritesheet;
import chon.group.game.core.animation.AnimationStatus;
import chon.group.game.core.animation.AnimationSystem;
import chon.group.game.core.animation.SimpleAnimationSpritesheet;
import chon.group.game.core.environment.Environment;
import chon.group.game.core.environment.Level;
import chon.group.game.core.menu.MainOption;
import chon.group.game.core.menu.MenuTextManager;
import chon.group.game.core.menu.PauseOption;
import chon.group.game.core.weapon.CloseWeapon;
import chon.group.game.core.weapon.Panel;
import chon.group.game.core.weapon.Weapon;
import chon.group.game.domain.weapon.Cannon;
import chon.group.game.domain.weapon.Lancer;
import chon.group.game.domain.weapon.Sword;

public class GameSet {

    private int canvasWidth;
    private int canvasHeight;
    private Environment environment;
    private Panel panel;

    public GameSet() {
        this.load();
    }

    public int getCanvasWidth() {
        return canvasWidth;
    }

    public void setCanvasWidth(int canvasWidth) {
        this.canvasWidth = canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public void setCanvasHeight(int canvasHeight) {
        this.canvasHeight = canvasHeight;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    private void load() {
        /* Define some size properties for both Canvas and Environment */
        this.canvasWidth = 1280;
        this.canvasHeight = 780;

        /** Define a general panel for life, energy, points, and objects. */
        panel = new Panel(
                240,
                110);

        /* Initialize the game environment, levels, agents and weapons */
        Level level1 = new Level(
                0,
                0,
                canvasHeight,
                8024,
                "/images/environment/castleLong.png");

        Level level2 = new Level(
                0,
                0,
                canvasHeight,
                8000,
                "/images/environment/mountain.png");

        /* Set background music for each level */
        level1.setBackgroundMusic(Game.gameMusic);
        level2.setBackgroundMusic(Game.menuMusic);

        environment = new Environment(
                this.canvasHeight,
                level1.getWidth(),
                this.canvasWidth,
                panel);

        Agent chonBota = new Agent(400, 390, 90, 65, 5, 1000, "/images/agents/chonBota.png", false, false);
        AnimationSpritesheet idleChonBota = new SimpleAnimationSpritesheet(36, 48, 5, 300, "/images/agents/mrman.png");
        AnimationSpritesheet runChonBota = new SimpleAnimationSpritesheet(36, 48, 6, 300, "/images/agents/mrmanrun.png");
        AnimationSpritesheet attackChonBota = new SimpleAnimationSpritesheet(42, 48, 5, 10000, "/images/agents/mrmanattack.png");

        /*
         * Agent chonBota = new Agent(400, 390, 16, 12, 3, 1000, "/images/agents/mrman.png", false, false);
        AnimationSpritesheet idleChonBota = new SimpleAnimationSpritesheet(12, 16, 5, 500, "/images/agents/mrman.png");
        AnimationSpritesheet runChonBota = new SimpleAnimationSpritesheet(12, 16, 6, 500, "/images/agents/mrmanrun.png");
        AnimationSpritesheet attackChonBota = new SimpleAnimationSpritesheet(14, 16, 5, 500, "/images/agents/mrmanpunch.png");
         */

        AnimationGraphics chonBotaGraphics = new AnimationGraphics();
        chonBotaGraphics.addSpritesheet(AnimationStatus.IDLE, idleChonBota);
        chonBotaGraphics.addSpritesheet(AnimationStatus.RUNNING, runChonBota);
        chonBotaGraphics.addSpritesheet(AnimationStatus.ATTACKING, attackChonBota);
        AnimationSystem chonBotaSystem = new AnimationSystem(chonBotaGraphics);
        chonBota.setAnimationSystem(chonBotaSystem);

        Weapon cannon = new Cannon(400, 390, 0, 0, 3, 0, 0.05, "", false);
        Weapon lancer = new Lancer(400, 390, 0, 0, 3, 0, 0.05, "", false);
        Weapon lancer2 = new Lancer(400, 390, 0, 0, 3, 0, 0.05, "", false);
        CloseWeapon sword = new Sword(400, 390, 0, 0, 3, 0,  "", false);

        
        //chonBota.setCloseWeapon(sword);
        chonBota.setWeapon(lancer);

        Agent chonBot = new Agent(920, 440, 90, 65, 1, 500, "/images/agents/chonBot.png", true, true);
        AnimationSpritesheet idleChonBot = new SimpleAnimationSpritesheet(42, 81, 2, 1000, "/images/agents/MarioIdle.png");
        Agent chonBot2 = new Agent(720, 440, 90, 65, 1, 500, "/images/agents/chonBot.png", true, true);
        AnimationSpritesheet idleChonBot2 = new SimpleAnimationSpritesheet(42, 81, 2, 1000, "/images/agents/MarioIdle.png");
        Agent chonBot3 = new Agent(520, 440, 90, 65, 1, 500, "/images/agents/chonBot.png", true, true);
        AnimationSpritesheet idleChonBot3 = new SimpleAnimationSpritesheet(42, 81, 2, 1000, "/images/agents/MarioIdle.png");

        AnimationGraphics chonBotGraphics = new AnimationGraphics();
        chonBotGraphics.addSpritesheet(AnimationStatus.IDLE, idleChonBot);
        AnimationGraphics chonBotGraphics2 = new AnimationGraphics();
        chonBotGraphics.addSpritesheet(AnimationStatus.IDLE, idleChonBot2);
        AnimationGraphics chonBotGraphics3 = new AnimationGraphics();
        chonBotGraphics.addSpritesheet(AnimationStatus.IDLE, idleChonBot3);

        AnimationSystem chonBotSystem = new AnimationSystem(chonBotGraphics);
        chonBot.setAnimationSystem(chonBotSystem);
        AnimationSystem chonBotSystem2 = new AnimationSystem(chonBotGraphics2);
        chonBot.setAnimationSystem(chonBotSystem2);
        AnimationSystem chonBotSystem3 = new AnimationSystem(chonBotGraphics3);
        chonBot.setAnimationSystem(chonBotSystem3);
        
        environment.setProtagonist(chonBota);
        chonBot.setWeapon(lancer2);

        chonBot.setEnemy(true);
        chonBot2.setEnemy(true);
        chonBot3.setEnemy(true);
        //enemy.setEnemy(true) ;
        environment.setPauseImage("/images/environment/pause.png") ;
        environment.setGameOverImage("/images/environment/gameover.png");   

        level1.getAgents().add(chonBot);
        level1.getAgents().add(chonBot2);
        level1.getAgents().add(chonBot3);
        level2.getAgents().add(chonBot);


        /* Set up some collectable objects */
        List<Object> objects = new ArrayList<>();
        AnimationSpritesheet coinAnim = new SimpleAnimationSpritesheet(96, 96, 8, 200, "/images/agents/coinAnimated.png");
        objects.add(new Object(200, 350, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(400, 380, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(1000, 600, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(1400, 380, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(1800, 650, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(2000, 580, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false,coinAnim));
        objects.add(new Object(2300, 380, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(2600, 500, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(2900, 380, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(3200, 400, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(4100, 500, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(5000, 380, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));
        objects.add(new Object(6200, 400, 32, 32, 0, 0, "/images/agents/coin.png", false, false, true, false, coinAnim));

        // Register objects into the environment and count total collectibles
        level1.setObjects(objects);
        level1.countCollectibles();
        environment.getLevels().add(level1);
        level2.setObjects(objects);
        level2.countCollectibles();
        environment.getLevels().add(level2);
        environment.setCurrentLevel(level1);

        MenuTextManager.getInstance().setText(MainOption.START_GAME, "Start game");
        MenuTextManager.getInstance().setText(MainOption.EXIT, "Exit");
        MenuTextManager.getInstance().setText(PauseOption.RESUME, "Resume");
        MenuTextManager.getInstance().setText(PauseOption.GO_BACK_TO_MENU, "Go back to menu");
    }

}
