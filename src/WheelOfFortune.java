import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class WheelOfFortune extends GuessingGame {
    private String phrase;
    private StringBuilder hiddenPhrase;
    protected String previousGuesses;
    protected List<String> phraseList ;

    public WheelOfFortune() {
        phraseList = this.getPhraseList();
        previousGuesses = "";
    }

    protected List<String> getPhraseList(){
        List<String> phraseList;
        try {
            phraseList = Files.readAllLines(Paths.get("phrases.txt"));
            // Get a random phrase from the list
        } catch (IOException e) {
            phraseList = new ArrayList<>();
            System.out.println(e);
        }
        return phraseList;
    }

    public String randomPhrase() {
            // Get a random phrase from the list
            Random rand = new Random();
            int r = rand.nextInt(phraseList.size()); // gets 0, 1, or 2
            phrase = phraseList.get(r);
            phraseList.remove(phrase);
        return phrase.toLowerCase();
    }

    public void generateHiddenPhrase() {
        this.hiddenPhrase = new StringBuilder(this.phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)) {
                hiddenPhrase.setCharAt(i, '*');
            }
        }
    }

    abstract char getGuess(String previousGuesses);

    public GameRecord processGuess(String playId) {
        int guessRightLetters = 0;
        this.phrase = this.randomPhrase();
        this.generateHiddenPhrase();
        while (playTime < maxTimesTry) {
            score = playTime*50/maxTimesTry + (guessRightLetters*50/phrase.replaceAll(" ", "").length());
            System.out.println("enter a letter");
            char guessCh = getGuess(previousGuesses);
            while ( (playTime != 0 && previousGuesses.indexOf(guessCh) >= 0) || !Character.isLetter(guessCh)) {
                if (!Character.isLetter(guessCh)) {
                    System.out.println("Your guess is not a letter.");
                } else {
                    System.out.println("The guessed letter has been guessed, your previous guesses are:" + this.previousGuesses);
                }
                guessCh = getGuess(previousGuesses);
            }
            this.previousGuesses += guessCh;
                guessCh = Character.toLowerCase(guessCh);
                 if(phrase.indexOf(guessCh) >= 0){
                    for(int i = 0; i < phrase.length(); i++){
                        if(guessCh == phrase.charAt(i)){
                            this.hiddenPhrase.setCharAt(i, guessCh);
                            guessRightLetters++;
                        }
                        score = playTime*50/maxTimesTry + (guessRightLetters*50/phrase.replaceAll(" ", "").length());
                    }

                    System.out.println("Guess right! The updated phrase is: " + this.hiddenPhrase);
                     if (phrase.contentEquals(this.hiddenPhrase)) {
                         System.out.println("score:" + score);
                         return new GameRecord(score,playId);
                     }
                }else{
                     playTime++;
                    System.out.println("The guessed letter does not occur in the phrase, you only have " + playTime + " chances");
                    System.out.println("your previous guesses are: " + this.previousGuesses);
                }
            }
        score = playTime*50/maxTimesTry + (guessRightLetters*50/phrase.replaceAll(" ", "").length());
        return new GameRecord(score,playId);
    }

    @Override
    abstract GameRecord play();

    @Override
    abstract boolean playNext();

    public void reset(){
        phrase = "";
        hiddenPhrase = new StringBuilder();
        previousGuesses = "";
    }

    @Override
    public String toString() {
        return "WheelOfFortune{" +
                "phrase='" + phrase + '\'' +
                ", hiddenPhrase=" + hiddenPhrase +
                ", previousGuesses='" + previousGuesses + '\'' +
                ", phraseList=" + phraseList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WheelOfFortune that = (WheelOfFortune) o;
        return Objects.equals(phrase, that.phrase) && Objects.equals(hiddenPhrase, that.hiddenPhrase) && Objects.equals(previousGuesses, that.previousGuesses) && Objects.equals(phraseList, that.phraseList);
    }


}
