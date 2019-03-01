package topdown;

import java.awt.Graphics;
import java.util.LinkedList;

/**
 * Class used to keep track of all GameObjects and hold their
 * unique properties.
 *
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class Handler {

    /**
     * list represents a LinkedList of GameObjects that stores all
     * GameObjects created within the game.
     */
    LinkedList<GameObject> list = new LinkedList<GameObject>();

    /**
     * Holds true if the object is up.
     */
    private boolean up = false;

    /**
     * Holds true if the object is down.
     */
    private boolean down = false;

    /**
     * Holds true if the object to the left.
     */
    private boolean left = false;

    /**
     * Holds true if the object to the right.
     */
    private boolean right = false;

    /**
     * Returns true if the object is up.
     *
     * @return The boolean value stored in up.
     */
    public boolean isUp() {
        return up;
    }

    /**
     * Sets a boolean value for the boolean up.
     *
     * @param up represents whether or not the player is going up.
     */
    public void setUp(final boolean up) {
        this.up = up;
    }

    /**
     * Returns true if the object is down.
     *
     * @return The boolean value stored in down.
     */
    public boolean isDown() {
        return down;
    }

    /**
     * Sets a boolean value for the boolean down.
     *
     * @param down represents whether or not the player is going down.
     */
    public void setDown(final boolean down) {
        this.down = down;
    }

    /**
     * Returns true if the object is to the left.
     *
     * @return The boolean value stored in left.
     */
    public boolean isLeft() {
        return left;
    }

    /**
     * Sets a boolean value for the boolean left.
     *
     * @param left represents whether or not the player is going left.
     */
    public void setLeft(final boolean left) {
        this.left = left;
    }

    /**
     * Returns true if the object is to the right.
     *
     * @return The boolean value stored in right.
     */
    public boolean isRight() {
        return right;
    }

    /**
     * Sets a boolean value for the boolean right.
     *
     * @param right represents whether or not the player is going right
     */
    public void setRight(final boolean right) {
        this.right = right;
    }

    /**
     * Grabs each GameObject in list and run's their tick methods.
     */
    public void tick() {
        for (int i = 0; i < list.size(); i++) {
            GameObject temp = list.get(i);
            temp.tick();
        }
    }

    /**
     * Renders the screen continuously
     *
     * @param g represents the instance of Graphics being used
     */
    public void render(final Graphics g) {
        for (int i = 0; i < list.size(); i++) {
            GameObject temp = list.get(i);
            temp.render(g);
        }
    }

    /**
     * Adds the specified GameObject to the LinkedList, list.
     *
     * @param object the GameObject being added to the list.
     */
    public void addObject(final GameObject object) {
        list.add(object);
    }

    /**
     * Removes the specified GameObject from the LinkedList, list.
     *
     * @param object the GameObject being removed from the list.
     */
    public void removeObject(final GameObject object) {
        list.remove(object);
    }
}
