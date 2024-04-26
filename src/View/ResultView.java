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
     * @param maxKey
     */
    public void showLongestWord(String maxKey){
        System.out.println("\nTask_2. The longest word is " + maxKey);
    }

    /**
     * Метод выводит результат третьего задания на экран
     * @param keyValueSortList
     */
    public void showFrequencyWord(List<Map.Entry<String, Integer>> keyValueSortList){
        System.out.println("\nTask_3. The frequency of words is decreasing:");
        for (Map.Entry<String, Integer> keyValue : keyValueSortList) {
            System.out.println(keyValue.getKey() + ": " + keyValue.getValue());
        }
    }
}
