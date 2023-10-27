import java.util.Objects;
/**
 * Class to create a Frequency player for playing Wheel of fortune game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class FrequencyPlayer implements WheelOfFortunePlayer{
    private final String frequencyLetterOrder = "etaonrishdlfcmugypwbvkjxzq";
    int index = 0;
    /**
     * This method is used to get the player's next guess.
     * @return The character representing the player's next guess.
     */
    @Override
    public char nextGuess() {
        char guessCh = frequencyLetterOrder.charAt(index);
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
        return "Frequency Player";
    }
    /**
     * This method is used to reset the state of player, preparing for the next game.
     */
    @Override
    public void reset() {
        index = 0;
    }
    /**
     * Returns a string representation of the object FrequencyPlayer.
     * @return A string representation of the object FrequencyPlayer.
     */
    @Override
    public String toString() {
        return "FrequencyPlayer";
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
        FrequencyPlayer that = (FrequencyPlayer) o;
        return index == that.index && Objects.equals(frequencyLetterOrder, that.frequencyLetterOrder);
    }

}
