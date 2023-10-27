import java.util.ArrayList;
import java.util.List;
/**
 * Class to play a series time of a game.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public abstract class Game {
    /**
     * Plays multiple game records and collects them into an AllGamesRecord.
     * This method initiates the gameplay, collects individual GameRecords, and aggregates them into an AllGamesRecord.
     * It begins by playing the initial game, then repeatedly plays the next game until no more games can be played.
     * @return An AllGamesRecord containing a collection of individual GameRecords.
     */
    AllGamesRecord playAll(){
        AllGamesRecord allGamesRecord = new AllGamesRecord();
        GameRecord gameRecord = play();
        allGamesRecord.add(gameRecord);
        while (playNext()){
            GameRecord nextGameRecord = play();
            allGamesRecord.add(nextGameRecord);
        }
        return allGamesRecord;
    }
    /**
     * This is an abstract method representing gameplay in a game record.
     * Subclasses must implement this method to define the specific gameplay logic
     * @return A GameRecord representing the result of the gameplay.
     */
    abstract GameRecord play();
    /**
     * This is an abstract method representing the action to play the next turn or move.
     * Subclasses must implement this method to define the specific logic for playing the next turn.
     * @return True if the next turn or move can be played, false otherwise.
     */
    abstract boolean playNext();
    /**
     * Returns a string representation of the object Game.
     * @return A string representation of the object Game.
     */
    @Override
    public String toString() {
        return "Game";
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
