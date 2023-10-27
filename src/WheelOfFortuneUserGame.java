import java.util.Objects;
import java.util.Scanner;

public class WheelOfFortuneUserGame extends WheelOfFortune {
    Scanner scanner = new Scanner(System.in);
    String userName = scanner.next();
    @Override
    char getGuess(String previousGuesses) {
        char guessCh = scanner.next().charAt(0);
        return guessCh;
    }

    @Override
    GameRecord play() {
        System.out.println("`````starting a new game``````");
        GameRecord gameRecord = this.processGuess(userName);
        this.reset();
        return gameRecord;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WheelOfFortuneUserGame that = (WheelOfFortuneUserGame) o;
        return Objects.equals(scanner, that.scanner) && Objects.equals(userName, that.userName);
    }

    @Override
    public String toString() {
        return "WheelOfFortuneUserGame{" +
                "scanner=" + scanner +
                ", userName='" + userName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("insert your user name");
        Game userGame = new WheelOfFortuneUserGame();
        AllGamesRecord allGamesRecord = userGame.playAll();
        System.out.println(allGamesRecord.highGameList(Math.min(3,allGamesRecord.getNumberOfRecords())));  // or call specific functions of record
        System.out.println("Average is: "+allGamesRecord.average());
    }
}
