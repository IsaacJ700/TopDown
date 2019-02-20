package topdown;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;


public class Game extends Canvas implements Runnable {

    private boolean isRunning;
    private Thread thread;
    private Handler handle;
    private Player player;
    private Enemy enemy1, enemy2, enemy3, enemy4, enemy5, enemy6, enemy7;
    private List<Enemy> enemies;
    private State state;
    private Menu menu;
    private Credits credits;
    private SecondTimer timer;
    private OptionsMenu option;
    private GameScreen gameScreen;
    private GameOverScreen gameOver;
    private GameWonScreen gameWon;
    private PauseMenu pauseMenu;
    private ControlsMenu controlMenu;
    private final int WIDTH = 1000;
    private final int HEIGHT = 750;
    private int frameCount;

    public Game() {
        frameCount = 0;
        isRunning = true;
        enemies = new ArrayList<>();
        state = State.Menu;
        new Window(WIDTH, HEIGHT, "Shooter", this);
        menu = new Menu(this);
        credits = new Credits(this);
        handle = new Handler();
        timer = new SecondTimer();
        option = new OptionsMenu(this);
        pauseMenu = new PauseMenu(this);
        gameOver = new GameOverScreen(this);
        gameWon = new GameWonScreen(this);
        controlMenu = new ControlsMenu(this);
        player = new Player(100, 300, Type.player, handle, this);
        enemy1 = new Enemy(100, 450, Type.smallEnemy, handle, this);
        enemy2 = new Enemy(200, 300, Type.smallEnemy, handle, this);
        enemy3 = new Enemy(300, 300, Type.smallEnemy, handle, this);
        enemy4 = new Enemy(400, 300, Type.smallEnemy, handle, this);
        enemy5 = new Enemy(500, 300, Type.smallEnemy, handle, this);
        enemy6 = new Enemy(600, 300, Type.smallEnemy, handle, this);
        enemy7 = new Enemy(100, 600, Type.smallEnemy, handle, this);

        enemies.add(enemy1);
        enemies.add(enemy2);
        enemies.add(enemy3);
        enemies.add(enemy4);
        enemies.add(enemy5);
        enemies.add(enemy6);
        enemies.add(enemy7);
        
        gameScreen = new GameScreen(this, player);
        this.addKeyListener(new KeyControls(handle, this));
        this.addMouseListener(new MouseInput(this, handle));
        start();
        beginGame();
    }

    public void beginGame() {
        handle.addObject(player);
        handle.addObject(enemy1);
        handle.addObject(enemy2);
        handle.addObject(enemy3);
        handle.addObject(enemy4);
        handle.addObject(enemy5);
        handle.addObject(enemy6);
        handle.addObject(enemy7);
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

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

    public void stop() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(1);
    }

    public void tick() {
        if (state == State.Game) {
            handle.tick();
        }
    }

    public void checkIfWon() {
        int check = 0;
        for (int i = 0; i < handle.list.size(); i++) {
            GameObject temp = handle.list.get(i);
            if (temp.getType() == Type.smallEnemy) {
                check++;
            }
        }
        if (check == 0) {
            setState(State.GameWon);
        }
    }

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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public static void main(String args[]) {
        Game game = new Game();
    }
}
