import Controller.Controller;
import Model.Exceptions.EmptyFileException;
import Model.Exceptions.LongestWordException;
import Model.Exceptions.NoFileException;
import Model.FileModel;
import View.ResultView;

import java.io.IOException;
import java.util.zip.DataFormatException;

public class FilerApp {
    public static void main(String[] args) {

        String fileName = "D://Coding/intermediate_certifications/Java/virtual_picnic/src/input.txt";

        try {
            FileModel model = new FileModel(fileName);
            ResultView view = new ResultView();
            Controller controller = new Controller(model, view);

            controller.update();
        }
        catch (NoFileException | EmptyFileException | IOException e){
            System.out.println(e.getMessage());
        }
        catch (LongestWordException e){
            System.out.println(e.getMessage() + " " + e.getLongestWords());
        }
    }
}
