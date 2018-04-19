package hieu;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

        @FXML
        public Button button1, button2, button3, button4, button5;
        @FXML
        public TextArea txt1;
        @FXML
        public Label label1;

        public TextInputDialog dialog;

        @Override
        public void initialize(URL location, ResourceBundle resources) {

        }
        @FXML
        public void buttonChoose(){
            BST tree = new BST();

            button1.setOnAction(e->
            {
                txt1.setText("Emty Tree");
                tree.emtyTree();
            });

            button2.setOnAction(e->
            {
                txt1.setText("Randomize Tree Chosen");
                tree.randomize(5);
                tree.traverse(1);

            });

            button3.setOnAction(e->
            {
                txt1.setText("Insert Manually Chosen");
//                Tooltip tooltip = new Tooltip();
//                tooltip.setText("Example: MSSV-Ho ten-Ngay sinh-DTB-Tin chi");
                dialog = new TextInputDialog();
                dialog.setTitle("Insert tree node manually");
                dialog.setContentText("Please enter all data seperated by '-' :\nExample: MSSV-Ho Ten-NgaySinh-DTB-TinChi");

                dialog.setHeaderText(null);
                Optional<String> result = dialog.showAndWait();

                if (result.isPresent()){

                    String[] st = result.get().split("-");
                    tree.insert(Integer.parseInt(st[0]),st[1],st[2],Double.parseDouble(st[3]),Integer.parseInt(st[4])); // Key - Name - DOB - AVG - Credits

                }

                tree.traverse(1);
            });

            button4.setOnAction(e->{
                txt1.setText("Skewed Right Chosen");
                tree.skewedRight(5);
                tree.traverse(1);
            });

            button5.setOnAction(e->
            {
                txt1.setText("Skewed Left Chosen");
                tree.skewedLeft(5);
                tree.traverse(3);

            });
        }


}
