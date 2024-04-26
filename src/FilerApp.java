import Controller.Controller;
import Model.Exceptions.EmptyFileException;
import Model.Exceptions.NoFileException;
import Model.FileModel;
import View.ResultView;

import java.io.IOException;

public class FilerApp {
    public static void main(String[] args) {

        String fileName = "D://Coding/intermediate_certifications/Java/virtual_picnic/src/input.txt";

        try {
            FileModel model = new FileModel(fileName);
            ResultView view = new ResultView();
            Controller controller = new Controller(model, view);

            controller.update();
        } catch (NoFileException | EmptyFileException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
