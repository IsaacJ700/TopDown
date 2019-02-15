package topdown;

import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList<GameObject> list = new LinkedList<GameObject>();

    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void tick(){
        for(int i = 0; i < list.size(); i++){
            GameObject temp = list.get(i);

            temp.tick();
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < list.size(); i++){
            GameObject temp = list.get(i);
            temp.render(g);
        }
    }

    public void addObject(GameObject object){
        list.add(object);
    }

    public void removeObject(GameObject object){
        list.remove(object);
    }
}
