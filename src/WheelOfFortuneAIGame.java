import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class WheelOfFortuneAIGame extends WheelOfFortune {
    List<WheelOfFortunePlayer> playerList = new ArrayList<>();
    int playerIndex = 0;

    @Override
    char getGuess(String previousGuesses) {
        char guessCh = playerList.get(playerIndex).nextGuess();
        return guessCh;
    }

    public WheelOfFortuneAIGame() {
        this.playerList.add(new AlphabeticalPlayer());
    }

    public WheelOfFortuneAIGame(WheelOfFortunePlayer player) {
        this.playerList.add(player);
    }

    public WheelOfFortuneAIGame(List<WheelOfFortunePlayer> playerList) {
        this.playerList.addAll(playerList);
    }

    GameRecord play() {
        System.out.println("`````starting a new game``````");
        GameRecord gameRecord =  this.processGuess(playerList.get(playerIndex).playerId());
        super.reset();
        playerList.get(playerIndex).reset();
        return gameRecord;
    }


    @Override
    boolean playNext() {
        if(this.phraseList.isEmpty()){
            playerIndex++;
            if(playerIndex < playerList.size()) {
                this.phraseList = super.getPhraseList();
                System.out.println("---------- "+this.playerList.get(playerIndex).playerId() + " starts the game----------");
            }else {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WheelOfFortuneAIGame that = (WheelOfFortuneAIGame) o;
        return playerIndex == that.playerIndex && Objects.equals(playerList, that.playerList);
    }

    @Override
    public String toString() {
        return "WheelOfFortuneAIGame{" +
                "playerList=" + playerList +
                ", playerIndex=" + playerIndex +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Ai playing");
        WheelOfFortunePlayer randomPlayer = new RandomPlayer();
        WheelOfFortunePlayer alphabeticalPlayer = new AlphabeticalPlayer();
        WheelOfFortunePlayer frequencyPlayer = new FrequencyPlayer();
        List<WheelOfFortunePlayer> playerList = new ArrayList<>();
        playerList.add(randomPlayer);
        playerList.add(alphabeticalPlayer);
        playerList.add(frequencyPlayer);
        Game aiGame = new WheelOfFortuneAIGame(playerList);
        AllGamesRecord allGamesRecord = aiGame.playAll();
        System.out.println("Number of records are: " +allGamesRecord.getNumberOfRecords());
        System.out.println( "All players : " +allGamesRecord.highGameList(3));  // or call specific functions of record
        System.out.println(frequencyPlayer + "'s highGameList:" + allGamesRecord.highGameList(frequencyPlayer.playerId(),3));  // or call specific functions of record
        System.out.println(alphabeticalPlayer +"'s highGameList:" +allGamesRecord.highGameList(alphabeticalPlayer.playerId(),3));  // or call specific functions of record
        System.out.println(randomPlayer +"'s highGameList:" +allGamesRecord.highGameList(randomPlayer.playerId(),3));  // or call specific functions of record
        System.out.println("All players average score is: "+allGamesRecord.average());
        System.out.println(frequencyPlayer + "'s Average score is: "+allGamesRecord.average(frequencyPlayer.playerId()));
        System.out.println(alphabeticalPlayer + "'s Average score is: "+allGamesRecord.average(alphabeticalPlayer.playerId()));
        System.out.println(randomPlayer + "'s Average score is: "+allGamesRecord.average(randomPlayer.playerId()));

    }
}
