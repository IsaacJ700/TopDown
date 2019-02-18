package topdown;

public class SecondTimer {

    private long time;

    public SecondTimer(){
        time = System.currentTimeMillis();
    }

    public boolean isTimeUp(){
        return System.currentTimeMillis() > time + 500;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
