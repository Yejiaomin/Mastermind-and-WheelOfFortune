import java.util.Objects;

public class FrequencyPlayer implements WheelOfFortunePlayer{
    String frequencyLetterOrder = "etaonrishdlfcmugypwbvkjxzq";
    int index = 0;
    @Override
    public char nextGuess() {
        char guessCh = frequencyLetterOrder.charAt(index);
        System.out.println(guessCh);
        index++;
        return guessCh;
    }

    @Override
    public String playerId() {
        return "Frequency Player";
    }

    @Override
    public void reset() {
        index = 0;
    }

    @Override
    public String toString() {
        return "FrequencyPlayer";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrequencyPlayer that = (FrequencyPlayer) o;
        return index == that.index && Objects.equals(frequencyLetterOrder, that.frequencyLetterOrder);
    }

}
