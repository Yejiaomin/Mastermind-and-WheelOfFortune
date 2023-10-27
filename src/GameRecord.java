import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameRecord implements Comparable<GameRecord>{
    int score;
    String playerId;
    List<Integer> playerScoreList = new ArrayList<>();
    public GameRecord(int score, String playerId){
        this.score = score;
        this.playerId = playerId;
        playerScoreList.add(score);
    }

    @Override
    public int compareTo(GameRecord o) {
        return Integer.compare(this.score, o.score);
    }

    @Override
    public String toString() {
        return "GameRecord{" +
                "playerId='" + playerId + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameRecord that = (GameRecord) o;
        return score == that.score && Objects.equals(playerId, that.playerId) && Objects.equals(playerScoreList, that.playerScoreList);
    }

}
