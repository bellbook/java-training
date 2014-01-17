import console.Console;
import console.fx.FxConsole;
import interpret.Interpreter;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppMain extends Application {

    public static void main(String[] args) {
        launch(AppMain.class, args);
    }

    @Override
    public void start(Stage arg0) throws Exception {

        Interpreter interpreter = new Interpreter();

        Console console = new FxConsole();
        console.addObserver(interpreter);
        console.show();

        System.out.println("# e.g.");
        System.out.println("# f = new java.awt.Frame");
        System.out.println("# set f.title \"TITLE\"");
        System.out.println("# title = get f.title");
        System.out.println("# invoke f.setVisible true");
        System.out.println("# a = array java.awt.Frame 5");
        System.out.println("# show f");
        System.out.println("# print f");
        System.out.println("# exit");
        System.out.println();
    }

}
