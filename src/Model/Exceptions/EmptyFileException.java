package Model.Exceptions;

public class EmptyFileException extends Exception {

    /**
     * Ошибка чтения из файла - он пустой!
     *
     * @param message
     */
    public EmptyFileException(String message) {
        super(message);
    }
}
