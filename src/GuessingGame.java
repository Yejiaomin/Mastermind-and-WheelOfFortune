import javax.management.monitor.GaugeMonitor;

public abstract class GuessingGame extends Game {

    protected int playTime = 0;
    protected int maxTimesTry = 4;
    protected int score;
    @Override
    abstract GameRecord play() ;

    @Override
    abstract boolean playNext() ;

    @Override
    public String toString() {
        return "GuessingGame{}";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
