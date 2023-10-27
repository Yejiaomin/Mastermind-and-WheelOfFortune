import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Class to build a game record.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class GameRecord implements Comparable<GameRecord>{
    protected int score;
    protected String playerId;
    private final List<Integer> playerScoreList = new ArrayList<>();

    /**
     * A constructor to initialize the GameRecord.
     * @param score GameRecord's score
     * @param playerId GameRecord's playerId
     */
    public GameRecord(int score, String playerId){
        this.score = score;
        this.playerId = playerId;
        playerScoreList.add(score);
    }
    /**
     * Compare two game records to determine their order based on scores.
     * This method is used to compare the current game record with another game record to establish their ranking order. The comparison is based on the scores of the game records. If the scores are equal, the two game records are considered equal.
     * @param o Another game record to compare with the current game record.
     * @return A negative integer, zero, or a positive integer, indicating that the current game record is less than, equal to, or greater than another game record based on score comparison.
     */
    @Override
    public int compareTo(GameRecord o) {
        return Integer.compare(this.score, o.score);
    }
    /**
     * Returns a string representation of the object GameRecord.
     * @return A string representation of the object GameRecord.
     */
    @Override
    public String toString() {
        return "GameRecord{" +
                "playerId='" + playerId + '\'' +
                ", score=" + score +
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
        GameRecord that = (GameRecord) o;
        return score == that.score && Objects.equals(playerId, that.playerId) && Objects.equals(playerScoreList, that.playerScoreList);
    }

}
