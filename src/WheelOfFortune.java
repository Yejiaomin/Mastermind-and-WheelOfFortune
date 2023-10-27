import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
/**
 * Class to play Wheel of fortune game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public abstract class WheelOfFortune extends GuessingGame {
    private String phrase;
    private StringBuilder hiddenPhrase;
    protected String previousGuesses;
    protected List<String> phraseList ;
    /**
     * A constructor to initialize the WheelOfFortune.
     */
    public WheelOfFortune() {
        phraseList = this.getPhraseList();
        previousGuesses = "";
    }

    /**
     * This is a method used to get a list of phrases from a file.
     * @return A list of phrases.
     */
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
    /**
     * This method is used to get the phrase from a file of phrases.
     */
    public String randomPhrase() {
            // Get a random phrase from the list
            Random rand = new Random();
            int r = rand.nextInt(phraseList.size()); // gets 0, 1, or 2
            phrase = phraseList.get(r);
            phraseList.remove(phrase);
        return phrase.toLowerCase();
    }
    /**
     * This method is used to convert a phrase to a hidden phrase.
     */
    public void generateHiddenPhrase() {
        this.hiddenPhrase = new StringBuilder(this.phrase);
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (Character.isLetter(ch)) {
                hiddenPhrase.setCharAt(i, '*');
            }
        }
    }
    /**
     * Abstract method to obtain the next guess from the player.
     * This method, to be implemented by subclasses, prompts the player to provide their next guess while considering the previous guesses made in the game.
     * @param previousGuesses A string representing the previous guesses made in the game.
     * @return The next character guessed by the player.
     */
    abstract char getGuess(String previousGuesses);
    /**
     * Process player's guesses and manage the gameplay.
     * This method processes the player's guesses and manages the gameplay for a word guessing game. It provides feedback on correct and incorrect guesses, updates the game state, and calculates the player's score. The game continues until the player either successfully guesses the word or runs out of allowed attempts.
     * @param playId A unique identifier for the current game session.
     * @return A GameRecord representing the result of the gameplay, including the player's score and play ID.
     */
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
     * Resets the state of a game.
     * This method clears the current phrase, resets the hidden phrase to its initial state, and clears the list of previous guesses. It prepares the game to start anew.
     */
    public void reset(){
        playTime = 0;
        phrase = "";
        hiddenPhrase = new StringBuilder();
        previousGuesses = "";
    }
    /**
     * Returns a string representation of the object WheelOfFortune.
     * @return A string representation of the object WheelOfFortune.
     */
    @Override
    public String toString() {
        return "WheelOfFortune{" +
                "phrase='" + phrase + '\'' +
                ", hiddenPhrase=" + hiddenPhrase +
                ", previousGuesses='" + previousGuesses + '\'' +
                ", phraseList=" + phraseList +
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
        WheelOfFortune that = (WheelOfFortune) o;
        return Objects.equals(phrase, that.phrase) && Objects.equals(hiddenPhrase, that.hiddenPhrase) && Objects.equals(previousGuesses, that.previousGuesses) && Objects.equals(phraseList, that.phraseList);
    }
}
