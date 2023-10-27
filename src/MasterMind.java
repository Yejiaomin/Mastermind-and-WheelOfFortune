import java.util.*;
/**
 * Class to play Master mind game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class MasterMind extends GuessingGame {
    private final Scanner scanner = new Scanner(System.in);
    private final String userName = scanner.next();
    private String secret = "";
    private int exacts;
    private int partials;
    private static final int CODESIZE = 4;
    /**
     * This method to define the specific gameplay logic
     * @return A GameRecord representing the result of the gameplay.
     */
    @Override
    GameRecord play() {
        System.out.println("numbers of 0,1,2,3,4,5,6,7 represent eight colors.");
        secret = getSecret();
        System.out.println("secret: " + secret);
        while(playTime < maxTimesTry){
            score = (maxTimesTry-playTime)* 100/maxTimesTry;
            StringBuilder secretSB = new StringBuilder(secret);
            StringBuilder guessSB = new StringBuilder(getGuess());
            exacts = this.checkExacts(guessSB, secretSB);
            if(exacts == CODESIZE){
                System.out.println("You win! Your score is " + score);
                return new GameRecord(score,userName);
            }
            partials = this.checkPartials(guessSB, secretSB);
            System.out.println("The right color in right place guesses: " + exacts);
            System.out.println("The right color guesses: " + partials);
            playTime++;
        }
        score = (maxTimesTry-playTime)* 100/maxTimesTry;
        System.out.println("You lost the game! Your score is " + score);
        return new GameRecord(score,userName);
    }
    /**
     * This  method to obtain a list of all colors for the game.
     * @return a list of all colors representing by numbers from 0 to 7.
     */
    private List<Integer> getAllColors(){
        List<Integer> allColors  = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            allColors.add(i);
        }
        return allColors;
    }
    /**
     * This  method to obtain the next answer of the game.
     * @return The next character guessed by the player.
     */
    private String getSecret() {
        List<Integer> allColors = getAllColors();
        Collections.shuffle(allColors);
        System.out.println(allColors);
        for(int i = 0; i < CODESIZE; i++){
            secret =secret + allColors.get(i);
        }
        return secret;
    }
    /**
     *  This method is used to provide their next guess while considering the previous guesses made in the game.
     * @return The next character guessed by the player.
     */
    private String getGuess(){
        System.out.println("Input 4 numbers from 0-7 to guess the secret number sequence. Example input: 0123");
        return scanner.next();
    }
    /**
     *  This method is used to check the matched colors between secret and guess.
     * @return A integer representing by numbers of matched colors between secret and guess.
     */
    public int checkPartials(StringBuilder secretSB, StringBuilder guessSB) {
        // compare secret to guess
        int i = 0;
        int partials = 0;
        while (i < CODESIZE) {
            int j = 0;
            while (j < CODESIZE) {
                if (secretSB.charAt(i) == guessSB.charAt(j)) {
                    partials = partials + 1;
                    secretSB.setCharAt(i, '-');
                    guessSB.setCharAt(j, '*');
                }
                j++;
            }
            i++;
        }
        return partials;
    }
    /**
     *  This method is used to check the matched colors and positions between secret and guess.
     * @return A integer representing by numbers of matched colors and positions between secret and guess.
     */
    public int checkExacts(StringBuilder secretSB, StringBuilder guessSB) {
        // compare secret to guess
        int exacts = 0;
        for (int i = 0; i < CODESIZE; i++) {
            if (secretSB.charAt(i) == guessSB.charAt(i)) {
                exacts = exacts + 1;
            }
        }
        return exacts;
    }
    /**
     * This method to define the specific logic for playing the next turn.
     * @return True if the next turn or move can be played, false otherwise.
     */
    @Override
    boolean playNext() {
            char answer = ' ';
            while (answer != 'y' && answer != 'n') {
                System.out.println("Do you want to play next? 'y' or 'n'");
                answer = scanner.next().charAt(0);
            }
            reset();
            return answer == 'y';
    }
    /**
     * Reset the state of player, preparing for the next game.
     */
    private void reset(){
        playTime = 0;
        secret = "";
        exacts = 0;
        partials = 0;
    }

    /**
     * Returns a string representation of the object MasterMind.
     * @return A string representation of the object MasterMind.
     */
    @Override
    public String toString() {
        return "MasterMind{" +
                "secret='" + secret + '\'' +
                ", exacts=" + exacts +
                ", partials=" + partials +
                ", scanner=" + scanner +
                '}';
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
        MasterMind that = (MasterMind) o;
        return exacts == that.exacts && partials == that.partials && Objects.equals(secret, that.secret) && Objects.equals(scanner, that.scanner);
    }
    /**
     * This is the main method to run the program.
     * @param args args[0]
     */
    public static void main(String[] args) {
        System.out.println("insert your user name");
        Game userGame = new MasterMind();
        AllGamesRecord allGamesRecord = userGame.playAll();
        System.out.println("highGameList:"+allGamesRecord.highGameList(3));  // or call specific functions of record
        System.out.println("Average is: "+allGamesRecord.average());
    }
}
