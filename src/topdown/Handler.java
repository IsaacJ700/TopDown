package topdown;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> list = new LinkedList<GameObject>();

    /** Holds true if the object is up. **/
    private boolean up = false;
    
    /** Holds true if the object is down. **/
    private boolean down = false;
    
    /** Holds true if the object to the left. **/
    private boolean left = false;
    
    /** Holds true if the object to the right. **/
    private boolean right = false;

    /**
     * Returns true if the object is up.
     * 
     * @return The boolean value stored in up.
     */
    public boolean isUp() {
        return up;
    }

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

    public void setRight(final boolean right) {
        this.right = right;
    }

    public void tick() {
        for (int i = 0; i < list.size(); i++) {
            GameObject temp = list.get(i);

            temp.tick();
        }
    }

    public void render(final Graphics g) {
        for (int i = 0; i < list.size(); i++) {
            GameObject temp = list.get(i);
            temp.render(g);
        }
    }

    public void addObject(final GameObject object) {
        list.add(object);
    }

    public void removeObject(final GameObject object) {
        list.remove(object);
    }
}
