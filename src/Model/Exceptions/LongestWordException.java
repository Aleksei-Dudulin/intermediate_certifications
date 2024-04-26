package Model.Exceptions;

import java.util.List;

public class LongestWordException extends Exception {
    private final List<String> longestWords;

    /**
     * В файле 2 и более слов с одинаковой максимальной длиной
     * @param message
     * @param longestWords
     */
    public LongestWordException(String message, List<String> longestWords) {
        super(message);
        this.longestWords = longestWords;
    }

    public List<String> getLongestWords() {
        return longestWords;
    }
}
