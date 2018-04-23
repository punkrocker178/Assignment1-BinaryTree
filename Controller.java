package hieu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;

import javax.swing.tree.TreeNode;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

        @FXML
        public Button button1, button2, button3, button4, button5,button6,button7,button8;
        @FXML
        public TextArea txt1;
        @FXML
        public Label label1,label2;
        @FXML
        public Canvas layer1,layer2;
        @FXML
		public ChoiceBox choiceBox;


        public TextInputDialog dialog;


    @Override
        public void initialize(URL location, ResourceBundle resources) {
			choiceBox.getItems().addAll("Binary Tree","AVL Tree");

        }
        @FXML
        public void buttonChoose(){
			GraphicsContext gc = layer1.getGraphicsContext2D();
            GraphicsContext gc2 = layer2.getGraphicsContext2D();

            BST tree = new BST();

			/*Button 1*/
            button1.setOnAction(e->
            {

                gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                txt1.setText("Emty Tree");
                tree.emtyTree();
                gc.setStroke(Color.WHITE);

            });

			/*Button 2*/
            button2.setOnAction(e->
            {
                txt1.setText("Randomize Tree Chosen");
                tree.randomize(1,gc);
                tree.traverse(1);

//                try{
//                    tree.checkParent();
//                }catch(NullPointerException e){
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Error");
//                    alert.setHeaderText("Cannot find node");
//                    alert.setContentText("Try again");
//                    alert.showAndWait();
//                }

            });

			/*Button 3*/
            button3.setOnAction(e->
            {
                try{
                txt1.setText("Insert Manually Chosen");
                dialog = new TextInputDialog();
                dialog.setTitle("Insert tree node manually");
                dialog.setContentText("Please enter all data seperated by '-' :\nExample: MSSV-Ho Ten-NgaySinh-DTB-TinChi");

                dialog.setHeaderText(null);
                Optional<String> result = dialog.showAndWait();

                if (result.isPresent()){

                    String[] st = result.get().split("-");
                    tree.insert(gc,300,30,Integer.parseInt(st[0]),st[1],st[2],Double.parseDouble(st[3]),Integer.parseInt(st[4])); // Key - Name - DOB - AVG - Credits

                }

                tree.traverse(1);
            }catch(Exception er){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Missing information");
                    alert.setContentText("You need to type all the data mentioned above");
                    alert.showAndWait();

                }
            });

			/*Button 4*/
            button4.setOnAction(e->{

				gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());

                txt1.setText("Skewed Right Chosen");
                tree.skewedRight(5,gc);

                tree.traverse(1);
                tree.emtyTree();

            });

			/*Button 5*/
            button5.setOnAction(e->
            {

				gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());

                txt1.setText("Skewed Left Chosen");
                tree.skewedLeft(5,gc);

                tree.traverse(3);
                tree.emtyTree();


            });

            /*Button 7*/
            button7.setOnAction(e->{
                dialog = new TextInputDialog();
                dialog.setTitle("Search Node");
                dialog.setContentText("Please enter node's key");

                dialog.setHeaderText(null);
                Optional<String> result = dialog.showAndWait();

                try{
                    if(result.isPresent()){
                        Integer n = Integer.parseInt(result.get());
                        txt1.setText("Info of "+n+" is :\nMSSV - Name - AVG - Credits\n"+tree.getInfo(n));
                    }


                }catch(NullPointerException error){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Cannot find node");
                    alert.setContentText("Try input the correct key");
                    alert.showAndWait();
                    error.printStackTrace();
                }
            });

            /*Button 8*/
            button8.setOnAction(e->{
                dialog = new TextInputDialog();
                dialog.setTitle("Check parent of node ");
                dialog.setContentText("Please enter node's key");

                dialog.setHeaderText(null);
                Optional<String> result = dialog.showAndWait();

                try{
                    if(result.isPresent()){
                        Integer n = Integer.parseInt(result.get());
                        Integer p = tree.checkParent(n);
                        txt1.setText("Parent of "+n+" is "+p);
                    }


                }catch(NullPointerException error){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Cannot find node");
                    alert.setContentText("Try input the correct key");
                    alert.showAndWait();
                    error.printStackTrace();
                }
            });


        }


}
