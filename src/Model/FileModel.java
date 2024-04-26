package Model;

import Model.Exceptions.EmptyFileException;
import Model.Exceptions.LongestWordException;
import Model.Exceptions.NoFileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
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
    public FileModel(String fileName) throws NoFileException, EmptyFileException, IOException {
        this.fileName = fileName;
        this.wordBase = createWordBase();
    }


    /**
     * Метод создания виртуальной базы из данных файла "input.txt"
     * @return объект класса Map<String, Integer>
     * @throws IOException
     */
    public Map<String, Integer> createWordBase() throws NoFileException, EmptyFileException, IOException {

        File checker = new File(fileName);
        if (checker.exists()){ // Проверяем существование файла
            if (checker.length() != 0) { // Проверяем наличие данных в файле
                Map<String, Integer> newWordBase = new HashMap<>();
                BufferedReader readerFile = new BufferedReader(new java.io.FileReader(fileName));
                String line;
                while ((line = readerFile.readLine()) != null) {
                    String[] words = line.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        String word = words[i].trim();
                        if (!word.isEmpty()) {
                            if (newWordBase.containsKey(word)) {
                                int countWord = newWordBase.get(word);
                                newWordBase.put(word, countWord + 1);
                            } else {
                                newWordBase.put(word, 1);
                            }
                        }
                    }
                }
                return newWordBase;
            } else {
                throw new EmptyFileException("Your file is empty!");
            }
        } else {
            throw new NoFileException("File not found!");
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
//    public String getLongestWord() throws LongestWordException {
//        String longestWord = "";
//        List<String> longestWords = new ArrayList<>();
//        for (Map.Entry<String, Integer> keyValue : wordBase.entrySet()){
//            String key = keyValue.getKey();
//            if (key.length() > longestWord.length()){
//                longestWord = key;
//                longestWords.clear();
//                longestWords.add(longestWord);
//            } else if (key.length() == longestWord.length() & !key.equals(longestWord)){
//                longestWords.add(key);
//            }
//
//        }
//        if (longestWords.size() > 1){
//            throw new LongestWordException("File have more than one longest word!", longestWords);
//        } else {
//            return longestWord;
//        }
//    }

    public List<String> getLongestWord() throws LongestWordException {
        String longestWord = "";
        List<String> longestWords = new ArrayList<>();
        for (Map.Entry<String, Integer> keyValue : wordBase.entrySet()){
            String key = keyValue.getKey();
            if (key.length() > longestWord.length()){
                longestWord = key;
                longestWords.clear();
                longestWords.add(longestWord);
            } else if (key.length() == longestWord.length() & !key.equals(longestWord)){
                longestWords.add(key);
            }
        }
        return longestWords;
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
