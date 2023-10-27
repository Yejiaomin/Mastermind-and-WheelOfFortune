import java.util.Objects;

public class RandomPlayer implements WheelOfFortunePlayer{
    private int randomNumber;
    @Override
    public char nextGuess() {
        randomNumber = (int) (Math.floor(Math.random()* 26)  + 1);
        char guessCh = (char) ('a'+randomNumber);
        System.out.println(guessCh);
        return guessCh;
    }

    @Override
    public String playerId() {
        return "RandomPlayer";
    }

    @Override
    public void reset() {
    }

    @Override
    public String toString() {
        return "RandomPlayer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomPlayer that = (RandomPlayer) o;
        return randomNumber == that.randomNumber;
    }

}
