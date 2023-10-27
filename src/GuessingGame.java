import javax.management.monitor.GaugeMonitor;

public abstract class GuessingGame extends Game {
    int playTime = 0;
    int maxTimesTry = 4;
    int score;
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
