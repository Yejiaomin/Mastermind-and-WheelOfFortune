import javax.management.monitor.GaugeMonitor;
/**
 * Class to play a series time of a kind of guessing game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public abstract class GuessingGame extends Game {

    protected int playTime = 0;
    protected int maxTimesTry = 4;
    protected int score;
    /**
     * This is an abstract method representing gameplay in a game record.
     * Subclasses must implement this method to define the specific gameplay logic
     * @return A GameRecord representing the result of the gameplay.
     */
    @Override
    abstract GameRecord play() ;
    /**
     * This is an abstract method representing the action to play the next turn or move.
     * Subclasses must implement this method to define the specific logic for playing the next turn.
     * @return True if the next turn or move can be played, false otherwise.
     */
    @Override
    abstract boolean playNext() ;
    /**
     * Returns a string representation of the object GuessingGame.
     * @return A string representation of the object GuessingGame.
     */
    @Override
    public String toString() {
        return "GuessingGame{}";
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj The object to compare with.
     * @return True if this object is equal to the provided object, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
