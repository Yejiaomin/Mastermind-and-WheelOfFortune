import java.util.Objects;
/**
 * Class to create a Random player for playing Wheel of fortune game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class RandomPlayer implements WheelOfFortunePlayer{
    private int randomNumber;
    /**
     * This method is used to get the player's next guess.
     * @return The character representing the player's next guess.
     */
    @Override
    public char nextGuess() {
        randomNumber = (int) (Math.floor(Math.random()* 26)  + 1);
        char guessCh = (char) ('a'+randomNumber);
        System.out.println(guessCh);
        return guessCh;
    }
    /**
     * This method is used to get the unique identifier of the player.
     * @return A string representing the player's unique identifier.
     */
    @Override
    public String playerId() {
        return "RandomPlayer";
    }
    /**
     * This method is used to reset the state of player, preparing for the next game.
     */
    @Override
    public void reset() {
    }
    /**
     * Returns a string representation of the object RandomPlayer.
     * @return A string representation of the object RandomPlayer.
     */
    @Override
    public String toString() {
        return "RandomPlayer";
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     * @param o The object to compare with.
     * @return True if this object is equal to the provided object, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomPlayer that = (RandomPlayer) o;
        return randomNumber == that.randomNumber;
    }
}
