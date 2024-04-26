package Controller;

import Model.Exceptions.LongestWordException;
import Model.FileModel;
import View.ResultView;

public class Controller {

    private final FileModel fileModel;
    private final ResultView resultView;

    /**
     * Конструктор класса Controller
     * @param fileModel
     * @param resultView
     */
    public Controller(FileModel fileModel, ResultView resultView) {
        this.fileModel = fileModel;
        this.resultView = resultView;
    }

    /**
     * Метод соединения view и model в модели MVC. в нашем случае ShowResult
     */
    public void update() throws LongestWordException {

        /**
         * У экземпляра класса ResultTranslator вызываем методы с приставкой show для отображения входящих данных,
         * которые получаем в результате вызова методов с приставкой get у экземпляра класса FileReader.
         */
        resultView.showTotalWord(fileModel.getTotalWord());
        resultView.showLongestWord(fileModel.getLongestWord());
        resultView.showFrequencyWord(fileModel.getFrequencyWord());

    }
}
