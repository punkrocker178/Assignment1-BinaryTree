package hieu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GuiMain extends Application  {



    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Controller/TreeGui.fxml"));                  //Get file fxml
        primaryStage.setTitle("Binary Tree and AVL Tree");
        Image img = new Image("file:hieu\\mineIcon.jpg");
        primaryStage.getIcons().add(img);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void main(String[] args){
        launch(args);
    }

}
