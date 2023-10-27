import java.util.*;

public class MasterMind extends GuessingGame {
    private String secret = "";
    private int exacts;
    private int partials;
    private static final int CODESIZE = 4;
    private final Scanner scanner = new Scanner(System.in);

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
                return new GameRecord(score,"user");
            }
            partials = this.checkPartials(guessSB, secretSB);
            System.out.println("The right color in right place guesses: " + exacts);
            System.out.println("The right color guesses: " + partials);
            playTime++;
        }
        score = (maxTimesTry-playTime)* 100/maxTimesTry;
        System.out.println("You lost the game! Your score is " + score);
        return new GameRecord(score,"user");
    }
    private List<Integer> getAllColors(){
        List<Integer> allColors  = new ArrayList<>();
        for(int i = 0; i < 8; i++){
            allColors.add(i);
        }
        return allColors;
    }

    private String getSecret() {
        List<Integer> allColors = getAllColors();
        Collections.shuffle(allColors);
        System.out.println(allColors);
        for(int i = 0; i < CODESIZE; i++){
            secret =secret + allColors.get(i);
        }
        return secret;
    }

    private String getGuess(){
        System.out.println("Input 4 numbers from 0-7 to guess the secret number sequence. Example input: 0123");
        return scanner.next();
    }

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
    private void reset(){
        secret = "";
        exacts = 0;
        partials = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MasterMind that = (MasterMind) o;
        return exacts == that.exacts && partials == that.partials && Objects.equals(secret, that.secret) && Objects.equals(scanner, that.scanner);
    }

    @Override
    public String toString() {
        return "MasterMind{" +
                "secret='" + secret + '\'' +
                ", exacts=" + exacts +
                ", partials=" + partials +
                ", scanner=" + scanner +
                '}';
    }

    public static void main(String[] args) {
        MasterMind masterMind = new MasterMind();
        AllGamesRecord allGamesRecord = masterMind.playAll();
        System.out.println("highGameList:"+allGamesRecord.highGameList(3));  // or call specific functions of record
        System.out.println("Average is: "+allGamesRecord.average());
    }
}
