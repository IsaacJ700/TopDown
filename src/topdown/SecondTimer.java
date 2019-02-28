package topdown;

public class SecondTimer {

    private long time;

    public SecondTimer() {
        time = System.currentTimeMillis();
    }

    public boolean isTimeUp() {
        return System.currentTimeMillis() > time + 200;
    }

    public long getTime() {
        return time;
    }

    public void setTime(final long time) {
        this.time = time;
    }
}
