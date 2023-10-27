import java.util.*;

/**
 * Class to build and deal with a list of all the game record.
 * @author Jiaomin Ye
 * @version 1.0
 * @since 10-26-2023
 */
public class AllGamesRecord {
    private final List<GameRecord> list = new ArrayList<>();

    public void add(GameRecord gameRecord) {
        list.add(gameRecord);
    }

    /**
     * This method is used to get the average score for all games.
     * @return returns the average score for all games.
     */
    public int average() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).score;
        }
        return sum / list.size();
    }
    /**
     * This method is used to get the average score for the specified player.
     * @return returns the average score for the specified player.
     */
    public int average(String playerId) {
        int sum = 0;
        int times = 0;
        int averageOfPlayer;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).playerId.equals(playerId)) {
                sum += list.get(i).score;
                times++;
            }
        }
        averageOfPlayer = sum / times;
        return averageOfPlayer;
    }
    /**
     * This method is used to get the top n scores for all the game records.
     * @return returns a sorted list of the top n scores including player and score.
     */
    public List<GameRecord> highGameList(int n) {
        list.sort(Collections.reverseOrder());
        return list.subList(0, n);
    }
    /**
     * This method is used to get the top n scores for the specified player.
     * @return returns a sorted list of the top n scores for the specified player.
     */
    public List<Integer> highGameList(String playerId, int n) {
        List<Integer> playerScorelist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).playerId.equals(playerId)) {
                playerScorelist.add(list.get(i).score);
            }
        }
        playerScorelist.sort(Collections.reverseOrder());
        return playerScorelist.subList(0, n);
    }
    /**
     * This method is used to get the number of records.
     * @return returns the number of records.
     */
    public int getNumberOfRecords() {
        return list.size();
    }
    /**
     * Returns a string representation of the object AllGamesRecord.
     * @return A string representation of the object AllGamesRecord.
     */
    @Override
    public String toString() {
        return "AllGamesRecord{" +
                "list=" + list +
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
        AllGamesRecord that = (AllGamesRecord) o;
        return Objects.equals(list, that.list);
    }
}
