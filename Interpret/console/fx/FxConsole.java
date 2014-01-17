package console.fx;

import java.io.PrintStream;
import java.util.ArrayList;

import console.Console;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class FxConsole extends Console {

    private Stage stage = new Stage();
    private TextArea textArea = new TextArea();
    private TextField textField = new TextField();

    private ArrayList<String> textList = new ArrayList<String>();
    private int textIndex;

    private String text;

    public FxConsole() {
        this(600, 400);
    }

    public FxConsole(int width, int height) {
        super(width, height);

        TextAreaOutputStream stream = new TextAreaOutputStream(textArea);
        System.setOut(new PrintStream(stream, true));

        Stage stage = new Stage();
        this.start(stage);
    }

    @Override
    public void show() {
        stage.show();
        textField.requestFocus();
    }

    private void start(Stage stage) {
        this.stage = stage;

        stage.initStyle(StageStyle.DECORATED);
        stage.setTitle("Console");
        stage.setWidth(width);
        stage.setHeight(height);
        stage.setOpacity(0.85);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(null);
        this.layout(scene);
        stage.setScene(scene);
    }

    private void layout(Scene scene) {

        // --------------------
        // setting TextArea
        // --------------------
        textArea.setEditable(false);
        textArea.setStyle(
                "-fx-text-fill: lime;" +
                "-fx-background-color: black;" +
                "-fx-font-family: arial;" +
                "-fx-font-size: 14;"
        );
        textArea.setWrapText(true);

        // --------------------
        // setting TextField
        // --------------------
        textField = new TextField();
        textField.setStyle(
                "-fx-font-family: arial;" +
                "-fx-font-size: 14;"
        );
        textField.addEventHandler(KeyEvent.KEY_PRESSED,
                new EventHandler<KeyEvent>() {

                    @Override
                    public void handle(KeyEvent event) {

                        switch (event.getCode()) {
                        case ENTER:
                            text = textField.getText();

                            if (text.trim().length() == 0)
                                return;

                            textList.add(text);
                            textIndex = textList.size();
                            textField.setText("");

                            setChanged();
                            notifyObservers(text);
                            break;

                        case UP:
                            if (textIndex <= 0)
                                return;

                            textIndex--;

                            text = textList.get(textIndex);
                            textField.setText(text);
                            break;

                        case DOWN:
                            if (textIndex >= textList.size() - 1)
                                return;

                            textIndex++;

                            text = textList.get(textIndex);
                            textField.setText(text);
                            break;
                        }
                    }
                });

        // --------------------
        // bind
        // --------------------
        textArea.minHeightProperty().bind(
                scene.heightProperty().subtract(textField.heightProperty())
        );

        // --------------------
        // setting VBox
        // --------------------
        VBox vbox = new VBox();
        vbox.getChildren().addAll(
                textArea,
                textField
        );

        scene.setRoot(vbox);
    }

}
