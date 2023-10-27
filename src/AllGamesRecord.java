import java.util.*;

public class AllGamesRecord {
    private final
    List<GameRecord> list = new ArrayList<>();

    public void add(GameRecord gameRecord) {
        list.add(gameRecord);
    }

    public int average() {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).score;
        }
        return sum / list.size();
    }

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
        averageOfPlayer = sum/times;
        return averageOfPlayer;
    }

    public List<GameRecord> highGameList(int n) {
        list.sort(Collections.reverseOrder());
        return list.subList(0, n);
    }

    public List<Integer> highGameList(String playerId, int n) {
        List<Integer> playerScorelist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).playerId.equals(playerId)) {
                playerScorelist.add(list.get(i).score);
                }
            }
        playerScorelist.sort(Collections.reverseOrder());
        return playerScorelist.subList(0,n);
    }

    public int getNumberOfRecords(){
        return list.size();
    }
    @Override
    public String toString() {
        return "AllGamesRecord{" +
                "list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllGamesRecord that = (AllGamesRecord) o;
        return Objects.equals(list, that.list);
    }
}
