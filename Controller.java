package hieu;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
		public ComboBox comboBox;
        @FXML
        public  TextField txt2;

        String choice;

        public TextInputDialog dialog;


    @Override
        public void initialize(URL location, ResourceBundle resources) {

            GraphicsContext gc = layer1.getGraphicsContext2D();
            GraphicsContext gc2 = layer2.getGraphicsContext2D();
            comboBox.getItems().addAll("Binary Tree","AVL Tree");
            comboBox.setOnAction(e->{
                String tempString = comboBox.getSelectionModel().getSelectedItem()+"";

                switch(tempString)
                {
                    case "Binary Tree":
                        txt1.setText("Binary Tree Chosen");
                        gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                        BST tree = new BST();


                        /*Button 1*/
                        button1.setOnAction(b1->
                        {

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Emty Tree");
                            tree.emtyTree();
                            gc.setStroke(Color.WHITE);

                        });

                        /*Button 2*/
                        button2.setOnAction(b2->
                        {
                            txt1.setText("Randomize Tree Chosen");
                            tree.randomize(1,gc);
                            tree.traverse(1);


                        });

                        /*Button 3*/
                        button3.setOnAction(b3->
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
                        button4.setOnAction(b4->{

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());

                            txt1.setText("Skewed Right Chosen");
                            tree.skewedRight(5,gc);

                            tree.traverse(1);
                            tree.emtyTree();

                        });

                        /*Button 5*/
                        button5.setOnAction(b5->
                        {

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());

                            txt1.setText("Skewed Left Chosen");
                            tree.skewedLeft(5,gc);

                            tree.traverse(3);
                            tree.emtyTree();


                        });

                        /*Button 6*/
                        button6.setOnAction(b6 ->{
                            dialog = new TextInputDialog();
                            dialog.setTitle("Search Node");
                            dialog.setContentText("Please enter node's key");

                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();

                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    tree.del(n);
                                    txt1.setText("Node "+n+" is deleted");
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

                        /*Button 7*/
                        button7.setOnAction(b7->{
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
                        button8.setOnAction(b8->{
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

                        break;

                    case "AVL Tree":
                        txt1.setText("AVL Tree Chosen");
                        gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                        AVL tree2 = new AVL();

                        /*Button 1*/
                        button1.setOnAction(ab1->
                        {
                            System.out.println("AVL!!!!");
                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Emty Tree");
                            tree2.emtyTree();


                        });

//                        /*Button 2*/
//                        button2.setOnAction(ab2->
//                        {
//                            txt1.setText("Randomize Tree Chosen");
//                            tree2.randomize(1,gc);
//                            tree2.traverse(1);
//                            int n = tree2.Balance();
//                            txt2.setText(String.valueOf(n));
//
//
//                        });

                        /*Button 3*/
                        button3.setOnAction(ab3->
                        {
                            try{
                                System.out.println("AVL!!!!");
                                txt1.setText("Insert Manually Chosen");
                                dialog = new TextInputDialog();
                                dialog.setTitle("Insert tree node manually");
                                dialog.setContentText("Please enter all data seperated by '-' :\nExample: MSSV-Ho Ten-NgaySinh-DTB-TinChi");

                                dialog.setHeaderText(null);
                                Optional<String> result = dialog.showAndWait();

                                if (result.isPresent()){

                                    String[] st = result.get().split("-");
                                    tree2.insert(gc,300,30,Integer.parseInt(st[0]),st[1],st[2],Double.parseDouble(st[3]),Integer.parseInt(st[4])); // Key - Name - DOB - AVG - Credits

                                }
                                tree2.traverse(1);
                                int n = tree2.Balance();
                                txt2.setText(String.valueOf(n));
                            }catch(Exception er){
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText("Missing information");
                                alert.setContentText("You need to type all the data mentioned above");
                                alert.showAndWait();

                            }
                        });

//                        /*Button 4*/
//                        button4.setOnAction(ab4->{
//
//                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
//
//                            txt1.setText("Skewed Right Chosen");
//                            tree2.skewedRight(5,gc);
//
//                            tree2.traverse(1);
//                            tree2.emtyTree();
//
//                        });
//
//                        /*Button 5*/
//                        button5.setOnAction(ab5->
//                        {
//
//                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
//
//                            txt1.setText("Skewed Left Chosen");
//                            tree2.skewedLeft(5,gc);
//
//                            tree2.traverse(3);
//                            tree2.emtyTree();
//
//
//                        });

                        /*Button 7*/
                        button7.setOnAction(ab6->{
                            dialog = new TextInputDialog();
                            dialog.setTitle("Search Node");
                            dialog.setContentText("Please enter node's key");

                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();

                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    txt1.setText("Info of "+n+" is :\nMSSV - Name - AVG - Credits\n"+tree2.getInfo(n));
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
                        button8.setOnAction(ab8->{
                            dialog = new TextInputDialog();
                            dialog.setTitle("Check parent of node ");
                            dialog.setContentText("Please enter node's key");

                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();

                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    Integer p = tree2.checkParent(n);
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

                        break;

                }

            });
        }
        @FXML
        public void buttonChoose(){


        }

        public void buttonChoose2(){

        }




}
