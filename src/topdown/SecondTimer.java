package topdown;

public class SecondTimer {

    private long time;

    public SecondTimer(){
        time = System.currentTimeMillis();
    }

    public boolean isTimeUp(){
        if (System.currentTimeMillis() > time + 500) {
            return true;
        }
        else return false;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
