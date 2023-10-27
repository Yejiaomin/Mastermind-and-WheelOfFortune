import java.util.Objects;

public class AlphabeticalPlayer implements WheelOfFortunePlayer{
    private int index;
    @Override
    public char nextGuess() {
        char guessCh = (char) ('a'+index);
        System.out.println(guessCh);
        index++;
        return guessCh;
    }

    @Override
    public String playerId() {
        return "AlphabeticalOrder player";
    }
    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public String toString() {
        return "AlphabeticalPlayer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlphabeticalPlayer that = (AlphabeticalPlayer) o;
        return index == that.index;
    }

}
