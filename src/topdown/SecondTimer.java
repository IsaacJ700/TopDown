package topdown;

/**
 * Creates a timer to count down time that is left in the game.
 * 
 * @author Issac Jimenez
 * @author Nicholas English
 * @author Suman Gurung
 * @version 1.0
 */
public class SecondTimer {

    /**
     * Holds the current time left in the game.
     */
    private long time;

    /**
     * Creates the timer for the game.
     */
    public SecondTimer() {
        time = System.currentTimeMillis();
    }

    /**
     * Returns true if the game time is up.
     * 
     * @return Boolean value for if the time is up.
     */
    public boolean isTimeUp() {
        return System.currentTimeMillis() > time + 200;
    }

    /**
     * Returns the current time left for the game.
     * 
     * @return The long value for the current time.
     */
    public long getTime() {
        return time;
    }

    /**
     * Sets the current time as the time passed to the function.
     * 
     * @param time Holds the current time to be set.
     */
    public void setTime(final long time) {
        this.time = time;
    }
}
