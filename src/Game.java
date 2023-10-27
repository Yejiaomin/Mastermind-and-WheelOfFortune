import java.util.ArrayList;
import java.util.List;

public abstract class Game {

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
    abstract GameRecord play();
    abstract boolean playNext();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
