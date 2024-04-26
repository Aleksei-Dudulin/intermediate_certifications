package Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public class FileModel {

    private final String fileName;

    private final Map<String, Integer> wordBase;

    /**
     * Конструктор класса FileReader
     * @param fileName ссылка на файл
     */
    public FileModel(String fileName) throws IOException, DataFormatException {
        this.fileName = fileName;
        this.wordBase = createWordBase();
    }


    /**
     * Метод создания виртуальной базы из данных файла "input.txt"
     * @return объект класса Map<String, Integer>
     * @throws IOException
     */
    public Map<String, Integer> createWordBase() throws IOException, DataFormatException {

        Map<String, Integer> newWordBase = new HashMap<>();
        BufferedReader readerFile = new BufferedReader(new java.io.FileReader(fileName));
        String line;
        while ((line = readerFile.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i].trim();
                if (!word.isEmpty()){
                    if (newWordBase.containsKey(word)) {
                        int countWord = newWordBase.get(word);
                        newWordBase.put(word, countWord + 1);
                    } else {
                        newWordBase.put(word, 1);
                    }
                }
            }
        }
        if (!newWordBase.isEmpty()){
            return newWordBase;
        } else {
            throw new DataFormatException();
        }

    }

    /**
     * Метод считает общее число слов в wordBase
     * @return количество слов
     */
    public int getTotalWord(){
        int wordCounter = 0;
        for (Map.Entry<String, Integer> keyValue : wordBase.entrySet()){
            wordCounter += keyValue.getValue();
        }
        return wordCounter;
    }

    /**
     * Метод находит самое длинное слово в wordBase
     * @return самое длинное слово
     */
    public String getLongestWord(){
        String longestWord = "";
        for (Map.Entry<String, Integer> keyValue : wordBase.entrySet()){
            String key = keyValue.getKey();
            if (key.length() > longestWord.length()){
                longestWord = key;
            }
        }
        return longestWord;
    }

    /**
     * Метод сортирует в порядке убывания по значению value элементы wordBase
     * @return отсортированный wordBase формата List<Map.Entry<String, Integer>>
     */
    public List<Map.Entry<String, Integer>> getFrequencyWord(){
        List<Map.Entry<String, Integer>> keyValueList = new ArrayList<>(wordBase.entrySet());
        keyValueList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return keyValueList;
    }
}
