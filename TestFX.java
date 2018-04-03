package hieu;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TestFX extends Application {
    Button button;
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception {
        Label label = new Label("This is the label");
        label.setTranslateY(-10);
        label.setStyle("-fx-border-color: blue;");

        button = new Button();
        button.setText("CLICK");
        button.setOnAction(e -> System.out.println("ABC"));
        button.setTranslateY(20);

        button.setAlignment(Pos.BOTTOM_CENTER);

        StackPane layout = new StackPane();
        layout.getChildren().add(button);

        primaryStage.setTitle("This is the title");

        BorderPane border = new BorderPane();








        Scene scene = new Scene(layout,300,300);
        primaryStage.setScene(scene);

        primaryStage.show();


    }

}
