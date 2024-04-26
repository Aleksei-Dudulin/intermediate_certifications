package View;

import java.util.List;
import java.util.Map;

public class ResultView {

    /**
     * Метод выводит результат первого задания на экран
     * @param wordCounter
     */
    public void showTotalWord(Integer wordCounter){
        System.out.println("\nTask_1. Total number of words in the file \"input.txt\" is " + wordCounter);
    }

    /**
     * Метод выводит результат второго задания на экран
     * @param longestWords
     */
    public void showLongestWord(List<String> longestWords) {
        if (longestWords.size() == 1) {
            System.out.print("\nTask_2. The longest word in the file \"input.txt\" is ");
            printList(longestWords);
        } else {
            System.out.print("\nTask_2. File \"input.txt\" has more than one longest word: ");
            printList(longestWords);
        }
    }

    /**
     * Метод для вывода на экран элементов списка самых длинных слов
     * @param longestWords
     * @return слово или слова
     */
    private static void printList(List<String> longestWords){
        for (String longestWord : longestWords){
            System.out.print(longestWord + " ");
        }
    }


    /**
     * Метод выводит результат третьего задания на экран
     * @param keyValueSortList
     */
    public void showFrequencyWord(List<Map.Entry<String, Integer>> keyValueSortList){
        System.out.println("\n\nTask_3. The frequency of words in the file \"input.txt\":");
        for (Map.Entry<String, Integer> keyValue : keyValueSortList) {
            System.out.println(keyValue.getKey() + ": " + keyValue.getValue());
        }
    }
}
