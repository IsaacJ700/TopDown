package topdown;

import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 * Main class which runs the program and holds the most important
 * methods used to keep track of essential game elements/information.
 *
 * @author Isaac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
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
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5, enemy6,
            enemy7;
    
    /**
     * Holds player supplies that the player can grab.
     */
    private PlayerSupplies healthSupply1;

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
     * Constructor initializes many of the instance variables created
     * above and creates the window on which the game will run, adds
     * keyControls, adds a mouseListener, and calls on two methods used
     * to begin the game.
     */
    public Game() {
        frameCount = 0;
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

    /**
     * Sets up the game by adding all of the enemy and player objects to 
     * the game.
     */
    public void setUpGame() {
        player = new UserPlayer(100, 300, Type.player, handle, this);
        enemy1 = new Enemy(100, 450, Type.smallEnemy, handle, this);
        enemy2 = new Enemy(200, 300, Type.randomEnemy, handle, this);
        enemy3 = new Enemy(300, 300, Type.randomEnemy, handle, this);
        enemy4 = new Enemy(400, 300, Type.randomEnemy, handle, this);
        enemy5 = new Enemy(500, 300, Type.randomEnemy, handle, this);
        enemy6 = new Enemy(600, 300, Type.randomEnemy, handle, this);
        enemy7 = new Enemy(100, 600, Type.randomEnemy, handle, this);
        healthSupply1 = new PlayerSupplies(600, 600, Type.healthPack,
        		handle, this);
        handle.addObject(player);
        handle.addObject(enemy1);
        handle.addObject(enemy2);
        handle.addObject(enemy3);
        handle.addObject(enemy4);
        handle.addObject(enemy5);
        handle.addObject(enemy6);
        handle.addObject(enemy7);
        handle.addObject(healthSupply1);
        gameScreen = new GameScreen(this, player);
    }

    /**
     * Clears the game of all items in the handle list.
     */
    public void clearGame() {
        handle.getList().clear();
    }

    /**
     * Begins the game with the thread.
     */
    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Method used as the "engine" of the game, which keeps it running
     * and continuously updates all aspects of the game.
     */
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
        }
        stop();
    }

    /**
     * Stops the game and exits the program.
     */
    public void stop() {
        System.exit(1);
    }

    /**
     * Based on the current state of the game, it runs the tick
     * function through the handle.
     */
    public void tick() {
        if (state == State.Game) {
            handle.tick();
        }
    }

    /**
     * Declares the player a winner if all of the enemy objects have 
     * been removed.
     */
    public void checkIfWon() {
        int check = 0;
        for (int i = 0; i < handle.getList().size(); i++) {
            GameObject temp = handle.getList().get(i);
            if (temp.getType() == Type.smallEnemy 
            		|| temp.getType() == Type.mediumEnemy 
            		|| temp.getType() == Type.largeEnemy 
            		|| temp.getType() == Type.bossEnemy
            		|| temp.getType() == Type.zombieEnemy 
            		|| temp.getType() == Type.shootingEnemy
            		|| temp.getType() == Type.randomEnemy) {
                check++;
            }
        }
        if (check == 0) {
            setState(State.GameWon);
        }
    }

    /**
     * Resets the game screen by clearing the game and then setting up
     * the game.
     */
    public void reset() {
        clearGame();
        setUpGame();
    }

    /**
     * Renders the screen and updates the screen constantly.
     */
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

    /**
     * Returns the State object for the state of the game currently.
     *
     * @return The current state of the game.
     */
    public State getState() {
        return state;
    }

    /**
     * Sets the state of the game based on the State object passed.
     *
     * @param state Holds a State object to be set to the current game.
     */
    public void setState(final State state) {
        this.state = state;
    }

    /**
     * Returns an integer value for the width of the current game
     * screen.
     *
     * @return The value for the width of the game screen.
     */
    public int getWIDTH() {
        return width;
    }

    /**
     * Returns an integer value for the height of the current game
     * screen.
     *
     * @return The value for the height of the game screen.
     */
    public int getHEIGHT() {
        return height;
    }

    /**
     * Returns the integer value for the frames per second for the
     * current game.
     *
     * @return The value for the frames per second for the game.
     */
    public int getFrameCount() {
        return frameCount;
    }

    /**
     * Sets the frames per second based on the integer value passed.
     *
     * @param frameCount Holds an int value of the frames per second.
     */
    public void setFrameCount(final int frameCount) {
        this.frameCount = frameCount;
    }

    /**
     * Main method is called when the program begins and creates the
     * instance of Game that will be used within all classes that
     * demand and instance of Game.
     *
     * @param args an array of command-line arguments for the
     *             application.
     */
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
