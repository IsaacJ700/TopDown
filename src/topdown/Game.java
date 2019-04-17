package topdown;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**********************************************************************
 * Main class which runs the program and holds the most important
 * methods used to keep track of essential game elements/information.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 2.0
 *********************************************************************/
public class Game extends Canvas implements Runnable {

    /**
     * Holds if the game is currently running or not.
     */
    private boolean isRunning;
    
    /**
     * Holds if the song is currently running or not.
     */
    private static boolean songLoop;

    /**
     * Instance of thread used to control the execution of the program.
     */
    private Thread thread;

    /**
     * Holds the handler object for the enemy object.
     */
    private Handler handle;

    /**
     * Holds the current player as a Player object.
     */
    private UserPlayer player;

    /**
     * Holds enemies with each being their own object.
     */
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5;
    
    /**
     * Holds player supplies that the player can grab.
     */
    private PlayerSupplies healthSupply1, ammoSupply1;

    /**
     * Holds the current state of the game.
     */
    private State state;

    /**
     * Used for rendering a menu for the game.
     */
    private Menu menu;

    /**
     * Used for rendering the "credits" screen for the game.
     */
    private Credits credits;

    /**
     * Used for rendering the "options menu" screen for the game.
     */
    private OptionsMenu option;

    /**
     * Used for rendering the in-game screen.
     */
    private GameScreen gameScreen;

    /**
     * Used for rendering the "game over" screen for the game.
     */
    private GameOverScreen gameOver;

    /**
     * Used for rendering the "game won" screen for the game.
     */
    private GameWonScreen gameWon;

    /**
     * Used for rendering the "pause menu" screen for the game.
     */
    private PauseMenu pauseMenu;

    /**
     * Used for rendering the "controls" screen for the game.
     */
    private ControlsMenu controlMenu;

    /**
     * Holds the width of the game screen.
     */
    private final int width = 1000;

    /**
     * Holds the height of the game screen.
     */
    private final int height = 750;

    /**
     * Holds the current frames per second for the game.
     */
    private int frameCount;

    /**
     * Holds the value of the current round
     */
    private int roundCount;

    /**
     * Holds the number of enemies in the game
     */
    private int numberOfEnemies;

    /******************************************************************
     * Constructor initializes many of the instance variables created
     * above and creates the window on which the game will run, adds
     * keyControls, adds a mouseListener, and calls on two methods used
     * to begin the game.
     *****************************************************************/
    public Game() {
        frameCount = 0;
        roundCount = 1;
        numberOfEnemies = 5;
        isRunning = true;
        state = State.Menu;
        new Window(width, height, "Shooter", this);
        menu = new Menu(this);
        credits = new Credits(this);
        handle = new Handler();
        option = new OptionsMenu(this);
        pauseMenu = new PauseMenu(this);
        gameOver = new GameOverScreen(this);
        gameWon = new GameWonScreen(this);
        controlMenu = new ControlsMenu(this);
        this.addKeyListener(new KeyControls(handle, this));
        this.addMouseListener(new MouseInput(this, handle));
        start();
        setUpGame();
    }

    /******************************************************************
     * Checks the entire list of objects to see if any enemies remain.
     * If not, the round is over to start a new one!
     * @param num represents the number of enemy objects
     * @return true if the round is over, otherwise return false
     *****************************************************************/
    public boolean checkForNewRound(int num) {
        if (num == 0) {
            return true;
        } else {
            return false;
        }
    }

    /******************************************************************
     * Sets up the game by adding all of the enemy and player objects to 
     * the game.
     *****************************************************************/
    public void setUpGame() {
        player = new UserPlayer(100, 300, Type.player, handle, this);
        enemy1 = new Enemy(600, 300, Type.smallEnemy, handle, this);
        enemy2 = new Enemy(600, 350, Type.smallEnemy, handle, this);
        enemy3 = new Enemy(600, 400, Type.smallEnemy, handle, this);
        enemy4 = new Enemy(600, 450, Type.smallEnemy, handle, this);
        enemy5 = new Enemy(600, 500, Type.smallEnemy, handle, this);
        healthSupply1 = new PlayerSupplies(600, 600, Type.healthPack,
        		handle, this);
        ammoSupply1 = new PlayerSupplies(200, 600, Type.ammoPack,
        		handle, this);
        handle.addObject(player);
        handle.addObject(enemy1);
        handle.addObject(enemy2);
        handle.addObject(enemy3);
        handle.addObject(enemy4);
        handle.addObject(enemy5);
        gameScreen = new GameScreen(this, player);
    }

    /******************************************************************
     * After the first round is over, this method adds a bunch of new
     * objects into the game for round two
     *****************************************************************/
    public void roundTwo() {
        handle.addObject(new Enemy(600, 300, Type.mediumEnemy, handle, this));
        handle.addObject(new Enemy(600, 400, Type.shootingEnemy, handle, this));
        handle.addObject(new Enemy(600, 500, Type.shootingEnemy, handle, this));
        handle.addObject(new Enemy(600, 600, Type.shootingEnemy, handle, this));
        handle.addObject(new Enemy(500, 400, Type.smallEnemy, handle, this));
        handle.addObject(new Enemy(500, 500, Type.smallEnemy, handle, this));
    }

    /******************************************************************
     * After the first round is over, this method adds a bunch of new
     * objects into the game for round three
     *****************************************************************/
    public void roundThree() {
        handle.addObject(new PlayerSupplies(200, 400, Type.healthPack, handle, this));
        handle.addObject(new PlayerSupplies(200, 500, Type.ammoPack, handle, this));
        handle.addObject(new Enemy(600, 400, Type.bossEnemy, handle, this));
        handle.addObject(new Enemy(600, 600, Type.zombieEnemy, handle, this));
        handle.addObject(new Enemy(500, 500, Type.largeEnemy, handle, this));
    }

    /******************************************************************
     * Clears the game of all items in the handle list.
     *****************************************************************/
    public void clearGame() {
        handle.getList().clear();
        roundCount = 1;
        numberOfEnemies = 5;

    }

    /******************************************************************
     * Begins the game with the thread.
     *****************************************************************/
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    /******************************************************************
     * Method used as the "engine" of the game, which keeps it running
     * and continuously updates all aspects of the game.
     *****************************************************************/
    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                frameCount = frames;
                frames = 0;
            }
            getNumberOfEnemies();
            if (checkForNewRound(numberOfEnemies) == true) {
                if (roundCount == 1) {
                    roundTwo();
                    roundCount++;
                } else if (roundCount == 2) {
                    roundThree();
                    roundCount++;
                } else if (roundCount == 3) {

                }
            }
        }
        stop();
    }

    /******************************************************************
     * Stops the game and exits the program.
     *****************************************************************/
    public void stop() {
        System.exit(1);
    }

    /******************************************************************
     * Based on the current state of the game, it runs the tick
     * function through the handle.
     *****************************************************************/
    public void tick() {
        if (state == State.Game) {
            handle.tick();
        }
    }

    /******************************************************************
     * Grabs the number of enemy objects in the game and sets it to
     * the numberOfEnemies variable
     *****************************************************************/
    public void getNumberOfEnemies() {
        numberOfEnemies = 0;
        for (int i = 0; i < handle.getList().size(); i++) {
            GameObject temp = handle.getList().get(i);
            if (temp.getType() == Type.smallEnemy
                    || temp.getType() == Type.mediumEnemy
                    || temp.getType() == Type.largeEnemy
                    || temp.getType() == Type.bossEnemy
                    || temp.getType() == Type.zombieEnemy
                    || temp.getType() == Type.shootingEnemy
                    || temp.getType() == Type.randomEnemy) {
                numberOfEnemies++;
            }
        }
    }

    /******************************************************************
     * Declares the player a winner if all of the enemy objects have 
     * been removed.
     *****************************************************************/
    public void checkIfWon() {
        getNumberOfEnemies();
        if (numberOfEnemies == 0 && roundCount == 4) {
            setState(State.GameWon);
        }
        if (player.getBulletCount() == 0) {
            setState(State.GameOver);
        }
    }

    /******************************************************************
     * Resets the game screen by clearing the game and then setting up
     * the game.
     *****************************************************************/
    public void reset() {
        clearGame();
        setUpGame();
    }

    /******************************************************************
     * Renders the screen and updates the screen constantly.
     *****************************************************************/
    public void render() {

        BufferStrategy bs = this.getBufferStrategy();

        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D g = (Graphics2D) bs.getDrawGraphics();

        g.setRenderingHint(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);

        if (state == State.Menu) {
            menu.render(g);
        } else if (state == State.Game) {
            checkIfWon();
            gameScreen.render(g);
            handle.render(g);
        } else if (state == State.OptionsMenu) {
            option.render(g);
        } else if (state == State.PauseMenu) {
            pauseMenu.render(g);
        } else if (state == State.ControlsMenu) {
            controlMenu.render(g);
        } else if (state == State.Credits) {
            credits.render(g);
        } else if (state == State.GameOver) {
            gameOver.render(g);
        } else if (state == State.GameWon) {
            gameWon.render(g);
        }
        g.dispose();
        bs.show();
    }

    /******************************************************************
     * Returns the State object for the state of the game currently.
     *
     * @return The current state of the game.
     *****************************************************************/
    public State getState() {
        return state;
    }

    /******************************************************************
     * Sets the state of the game based on the State object passed.
     *
     * @param state Holds a State object to be set to the current game.
     *****************************************************************/
    public void setState(final State state) {
        this.state = state;
    }

    /******************************************************************
     * Returns an integer value for the width of the current game
     * screen.
     *
     * @return The value for the width of the game screen.
     *****************************************************************/
    public int getWIDTH() {
        return width;
    }

    /******************************************************************
     * Returns an integer value for the height of the current game
     * screen.
     *
     * @return The value for the height of the game screen.
     *****************************************************************/
    public int getHEIGHT() {
        return height;
    }

    /******************************************************************
     * Returns the integer value for the frames per second for the
     * current game.
     *
     * @return The value for the frames per second for the game.
     *****************************************************************/
    public int getFrameCount() {
        return frameCount;
    }

    /******************************************************************
     * Sets the frames per second based on the integer value passed.
     *
     * @param frameCount Holds an int value of the frames per second.
     *****************************************************************/
    public void setFrameCount(final int frameCount) {
        this.frameCount = frameCount;
    }

    /******************************************************************
     * Main method is called when the program begins and creates the
     * instance of Game that will be used within all classes that
     * demand and instance of Game.
     *
     * @param args an array of command-line arguments for the
     *             application.
     *****************************************************************/
    public static void main(final String[] args) {
        Game game = new Game();
        songLoop = true;
        
        // Used for running music.
		try {
			do {
				FileInputStream fileInputStream 
					= new FileInputStream(
							"bensound-theduel.mp3");
				Player musicPlayer 
					= new Player(fileInputStream);
				musicPlayer.play();
			} while (songLoop);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
    }
}
