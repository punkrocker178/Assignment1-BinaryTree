package hieu;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javax.swing.*;
import java.io.IOException;
import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GuiMain extends Application  {



    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("TreeGui.fxml"));                  //Get file fxml
        primaryStage.setTitle("Binary Tree and AVL Tree");

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }

    public static void main(String[] args){
        launch(args);
    }

}
