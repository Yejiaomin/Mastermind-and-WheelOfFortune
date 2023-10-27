import java.util.Objects;
import java.util.Scanner;
/**
 * Class to for user to play Wheel of fortune game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class WheelOfFortuneUserGame extends WheelOfFortune {
    private final Scanner scanner = new Scanner(System.in);
    private final String userName = scanner.next();
    /**
     * This method is used to provide their next guess.
     * @param previousGuesses A string representing the previous guesses made in the game.
     * @return The next character guessed by the player.
     */
    @Override
    char getGuess(String previousGuesses) {
        char guessCh = scanner.next().charAt(0);
        return guessCh;
    }
    /**
     * This method is used to define the specific gameplay logic
     * @return A GameRecord representing the result of the gameplay.
     */
    @Override
    GameRecord play() {
        System.out.println("`````starting a new game``````");
        GameRecord gameRecord = this.processGuess(userName);
        this.reset();
        return gameRecord;
    }
    /**
     * This method is used to define the specific logic for playing the next turn.
     * @return True if the next turn or move can be played, false otherwise.
     */
    @Override
    boolean playNext() {
        if (!this.phraseList.isEmpty()) {
            char answer = ' ';
            while (answer != 'y' && answer != 'n') {
                System.out.println("Do you want to play next? 'y' or 'n'");
                answer = scanner.next().charAt(0);
            }
            return answer == 'y';
        } else {
            System.out.println("No phrase available for playing");
            return false;
        }
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
        if (!super.equals(o)) return false;
        WheelOfFortuneUserGame that = (WheelOfFortuneUserGame) o;
        return Objects.equals(scanner, that.scanner) && Objects.equals(userName, that.userName);
    }
    /**
     * Returns a string representation of the object WheelOfFortuneUserGame.
     * @return A string representation of the object WheelOfFortuneUserGame.
     */
    @Override
    public String toString() {
        return "WheelOfFortuneUserGame{" +
                "scanner=" + scanner +
                ", userName='" + userName + '\'' +
                '}';
    }
    /**
     * This is the main method to run the program.
     * @param args args[0]
     */
    public static void main(String[] args) {
        System.out.println("insert your user name");
        Game userGame = new WheelOfFortuneUserGame();
        AllGamesRecord allGamesRecord = userGame.playAll();
        System.out.println(allGamesRecord.highGameList(Math.min(3,allGamesRecord.getNumberOfRecords())));  // or call specific functions of record
        System.out.println("Average is: "+allGamesRecord.average());
    }
}
