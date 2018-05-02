package hieu.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

	@FXML
	public TextArea txt;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void getText(String text){
		txt.setText(text);
	}
}
