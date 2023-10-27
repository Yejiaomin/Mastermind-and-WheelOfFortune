import java.util.Objects;
/**
 * Class to create an Alphabetical player for playing Wheel of fortune game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class AlphabeticalPlayer implements WheelOfFortunePlayer{
    private int index;
    /**
     * This method is used to get the player's next guess.
     * @return The character representing the player's next guess.
     */
    @Override
    public char nextGuess() {
        char guessCh = (char) ('a'+index);
        System.out.println(guessCh);
        index++;
        return guessCh;
    }
    /**
     * This method is used to get the unique identifier of the player.
     * @return A string representing the player's unique identifier.
     */
    @Override
    public String playerId() {
        return "AlphabeticalOrder player";
    }
    /**
     * This method is used to reset the state of player, preparing for the next game.
     */
    @Override
    public void reset() {
        index = 0;
    }
    /**
     * Returns a string representation of the object AlphabeticalPlayer.
     * @return A string representation of the object AlphabeticalPlayer.
     */
    @Override
    public String toString() {
        return "AlphabeticalPlayer";
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
        AlphabeticalPlayer that = (AlphabeticalPlayer) o;
        return index == that.index;
    }

}
