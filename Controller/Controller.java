package hieu.Controller;

import hieu.Tree.AVL;
import hieu.Tree.BST;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

        @FXML
        public Button button1, button2, button3, button4, button5,button6,button7,button8,button9,button10,button11,button12;
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
        @FXML


        public TextInputDialog dialog,dialog2;


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


                        /*Button 1	--	EmtyTree()*/
                        button1.setOnAction(b1->
                        {

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Emty Tree");
                            tree.emtyTree();
                            gc.setStroke(Color.WHITE);

                        });

                        /*Button 2	--	Randomize()*/
                        button2.setOnAction(b2->
                        {
                            txt1.setText("Randomize Tree Chosen");
                            tree.randomize(1,gc);
                            tree.traverse(1);


                        });

                        /*Button 3	--	InsertManually*/
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

                        /*Button 4	--	SkewedRight()*/
                        button4.setOnAction(b4->{

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Skewed Right Chosen");
                            tree.skewedRight(5,gc);
                            tree.traverse(1);
                            tree.emtyTree();

                        });

                        /*Button 5	--	SkewedLeft*/
                        button5.setOnAction(b5->
                        {

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Skewed Left Chosen");
                            tree.skewedLeft(5,gc);
                            tree.traverse(3);
                            tree.emtyTree();

                        });

                        /*Button 6	--	Delete()*/
                        button6.setOnAction(b6 ->{
                            dialog = new TextInputDialog();
                            dialog.setTitle("Search Node to delete");
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

                        /*Button 7	-- Search()	*/
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

                        /*Button 8	--	Parent()*/
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

                        /*Button 9	--	Predecessor()*/
                        button9.setOnAction(b9 ->{
                            dialog = new TextInputDialog();
                            dialog.setTitle("Find node Predecessor");
                            dialog.setContentText("Please enter node's key");

                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();

                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    String pre = tree.preDecessor(n);
                                    txt1.setText("Predecessor of "+n+" is "+pre);
                                }


                            }catch(NullPointerException error){
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText("Cannot find node");
                                alert.setContentText("Maybe Node doesn't have predecessor");
                                alert.showAndWait();
                                error.printStackTrace();
                            }
                        });

                        /*Button 10	--	Successor*/
                        button10.setOnAction(b10 -> {
                            dialog = new TextInputDialog();
                            dialog.setTitle("Find node Successor");
                            dialog.setContentText("Please enter node's key");

                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();

                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    String Succ = tree.sucCessor(n);
                                    txt1.setText("Successor of "+n+" is "+Succ);
                                }


                            }catch(NullPointerException error){
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText("Cannot find node");
                                alert.setContentText("Maybe Node doesn't have Successor");
                                alert.showAndWait();
                                error.printStackTrace();
                            }
                        });
                        /*Button 11	--	Update()*/
                        button11.setOnAction(b11 ->{
                            /*1st input diaglog*/
                            dialog = new TextInputDialog();
                            dialog.setTitle("Find node");
                            dialog.setContentText("Please enter node's key");
                            dialog.setHeaderText(null);
                            Optional<String> result = dialog.showAndWait();
                            try{
                                if(result.isPresent()){
                                    Integer n = Integer.parseInt(result.get());
                                    /*2nd input dialog*/
                                    dialog2 = new TextInputDialog();
                                    dialog2.setTitle("Update node information");
                                    dialog2.setContentText("Please enter new info seperated by '-'");
                                    dialog2.setHeaderText(null);
                                    Optional<String> result2 = dialog2.showAndWait();
                                    String[] st = result2.get().split("-");
                                    tree.update(n,st[0],st[1],Double.parseDouble(st[2]),Integer.parseInt(st[3]));
                                    txt1.setText("Update complete\nNode "+n+" is updated to "+tree.getInfo(n));

                                }

                            }catch(NullPointerException error){
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText("Cannot find node");
                                alert.setContentText("Node doesn't existed");
                                alert.showAndWait();
                                error.printStackTrace();
                            }

                        });
//
                        /*Button 12	--	TreeTraversal*/
                        button12.setOnAction( b12 ->{
                            try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreeTraverse.fxml"));
                            Parent root2 =(Parent) fxmlLoader.load();
                            Controller2 window2 = fxmlLoader.getController();
                            /*Ask for option*/
                                dialog = new TextInputDialog();
                                dialog.setTitle("Tree Traversal");
                                dialog.setContentText("Please enter options\n1/LNR\n2/NLR\n3/LRN\n4/RNL\n5/NRL\n6/RLN");
                                dialog.setHeaderText(null);
                                Optional<String> result = dialog.showAndWait();

                                try{
                                    if(result.isPresent()){
                                        Integer n = Integer.parseInt(result.get());
                                        String s = tree.traverse(n);
                                        window2.getText(s);
                                    }

                                }catch(NullPointerException error){
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Error");
                                    alert.setHeaderText("Not an option");
                                    alert.setContentText("Option not existed");
                                    alert.showAndWait();
                                    error.printStackTrace();
                                }

                            Scene scene = new Scene(root2, 600, 400);
                            Stage stage = new Stage();
                            stage.setTitle("Tree Traversal view");
                            stage.setScene(scene);
                            stage.show();
                    } catch (IOException error) {
                        Logger logger = Logger.getLogger(getClass().getName());
                        logger.log(Level.SEVERE, "Failed to create new Window.", error);
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

                        /*Button 2*/
                        button2.setOnAction(ab2->
                        {
                            txt1.setText("Randomize Tree Chosen");
                            tree2.randomize(1,gc);
                            tree2.traverse(1);
                            int n = tree2.Balance();
                            txt2.setText(String.valueOf(n));

                        });

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

                        /*Button 4*/
                        button4.setOnAction(ab4->{

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());
                            txt1.setText("Skewed Right Chosen");
                            tree2.skewedRight(5,gc);
                            tree2.traverse(1);
                            tree2.emtyTree();

                        });

                        /*Button 5*/
                        button5.setOnAction(ab5->
                        {

                            gc.clearRect(0, 0, layer1.getWidth(), layer1.getHeight());

                            txt1.setText("Skewed Left Chosen");
                            tree2.skewedLeft(5,gc);

                            tree2.traverse(3);
                            tree2.emtyTree();


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
									tree2.del(n);
									txt1.setText("Node "+n+" is deleted");
								}
								int n = tree2.Balance();
								txt2.setText(String.valueOf(n));


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
						/*Button 9	--	Predecessor()*/
						button9.setOnAction(ab9 ->{
							dialog = new TextInputDialog();
							dialog.setTitle("Find node Predecessor");
							dialog.setContentText("Please enter node's key");

							dialog.setHeaderText(null);
							Optional<String> result = dialog.showAndWait();

							try{
								if(result.isPresent()){
									Integer n = Integer.parseInt(result.get());
									String pre = tree2.preDecessor(n);
									txt1.setText("Predecessor of "+n+" is "+pre);
								}


							}catch(NullPointerException error){
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle("Error");
								alert.setHeaderText("Cannot find node");
								alert.setContentText("Maybe Node doesn't have predecessor");
								alert.showAndWait();
								error.printStackTrace();
							}
						});

						/*Button 10	--	Successor*/
						button10.setOnAction(ab10 -> {
							dialog = new TextInputDialog();
							dialog.setTitle("Find node Successor");
							dialog.setContentText("Please enter node's key");

							dialog.setHeaderText(null);
							Optional<String> result = dialog.showAndWait();

							try{
								if(result.isPresent()){
									Integer n = Integer.parseInt(result.get());
									String Succ = tree2.sucCessor(n);
									txt1.setText("Successor of "+n+" is "+Succ);
								}


							}catch(NullPointerException error){
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle("Error");
								alert.setHeaderText("Cannot find node");
								alert.setContentText("Maybe Node doesn't have Successor");
								alert.showAndWait();
								error.printStackTrace();
							}
						});
						/*Button 11	--	Update()*/
						button11.setOnAction(ab11 ->{
							/*1st input diaglog*/
							dialog = new TextInputDialog();
							dialog.setTitle("Find node");
							dialog.setContentText("Please enter node's key");
							dialog.setHeaderText(null);
							Optional<String> result = dialog.showAndWait();
							try{
								if(result.isPresent()){
									Integer n = Integer.parseInt(result.get());
									/*2nd input dialog*/
									dialog2 = new TextInputDialog();
									dialog2.setTitle("Update node information");
									dialog2.setContentText("Please enter new info seperated by '-'");
									dialog2.setHeaderText(null);
									Optional<String> result2 = dialog2.showAndWait();
									String[] st = result2.get().split("-");
									tree2.update(n,st[0],st[1],Double.parseDouble(st[2]),Integer.parseInt(st[3]));
									txt1.setText("Update complete\nNode "+n+" is updated to "+tree2.getInfo(n));

								}

							}catch(NullPointerException error){
								Alert alert = new Alert(Alert.AlertType.ERROR);
								alert.setTitle("Error");
								alert.setHeaderText("Cannot find node");
								alert.setContentText("Node doesn't existed");
								alert.showAndWait();
								error.printStackTrace();
							}

						});
//
						/*Button 12	--	TreeTraversal*/
						button12.setOnAction( ab12 ->{
							try {
								FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TreeTraverse.fxml"));
								Parent root2 =(Parent) fxmlLoader.load();
								Controller2 window2 = fxmlLoader.getController();
								/*Ask for option*/
								dialog = new TextInputDialog();
								dialog.setTitle("Tree Traversal");
								dialog.setContentText("Please enter options\n1/LNR\n2/NLR\n3/LRN\n4/RNL\n5/NRL\n6/RLN");
								dialog.setHeaderText(null);
								Optional<String> result = dialog.showAndWait();

								try{
									if(result.isPresent()){
										Integer n = Integer.parseInt(result.get());
										String s = tree2.traverse(n);
										window2.getText(s);
									}

								}catch(NullPointerException error){
									Alert alert = new Alert(Alert.AlertType.ERROR);
									alert.setTitle("Error");
									alert.setHeaderText("Not an option");
									alert.setContentText("Option not existed");
									alert.showAndWait();
									error.printStackTrace();
								}

								Scene scene = new Scene(root2, 600, 400);
								Stage stage = new Stage();
								stage.setTitle("Tree Traversal view");
								stage.setScene(scene);
								stage.show();
							} catch (IOException error) {
								Logger logger = Logger.getLogger(getClass().getName());
								logger.log(Level.SEVERE, "Failed to create new Window.", error);
							}
						});

                        break;

                }

            });
        }
        @FXML
        public String getText(){
            return "Back to window 1";

        }






}
