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


//        BST tree = new BST();
//        button1 = new Button();
//        button2 = new Button();
//        button3 = new Button();
//        button4 = new Button();
//        button5 = new Button();
//
//        button2.setOnAction(e->
//        {
//            txt1.setText("Randomize Tree Chosen");
//            tree.randomize(5);
//            tree.traverse(1);
//
//        });
//
//        button3.setOnAction(e->
//        {
//            txt1.setText("Insert Manually Chosen");
//            dialog = new TextInputDialog();
//            dialog.setTitle("Insert tree node manually");
//            dialog.setContentText("Please enter all data seperated by '-' :");
//            dialog.setHeaderText(null);
//            Optional<String> result = dialog.showAndWait();
//
//            if (result.isPresent()){
//
//                String[] st = result.get().split("-");
//                tree.insert(Integer.parseInt(st[0]),st[1],st[2],Double.parseDouble(st[3]),Integer.parseInt(st[4])); // Key - Name - DOB - AVG - Credits
//
//            }
//
//            tree.traverse(1);
//        });
//
//        button4.setOnAction(e->{
//            txt1.setText("Skewed Right Chosen");
//            tree.skewedRight(5);
//            tree.traverse(1);
//        });
//
//        button5.setOnAction(e->
//        {
//            txt1.setText("Skewed Left Chosen");
//        });

        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }




    public static void main(String[] args){
        launch(args);


    }

}
