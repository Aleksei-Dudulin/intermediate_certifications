package Model.Exceptions;

public class NoFileException extends Exception {

    /**
     * Ошибка чтения из файла - он пустой!
     *
     * @param message
     */
    public NoFileException(String message) {
        super(message);
    }

}
