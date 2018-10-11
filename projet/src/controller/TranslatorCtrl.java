package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class TranslatorCtrl implements EventHandler<ActionEvent> {

	@FXML
	TextArea txtLetters;
	@FXML
	TextArea txtMorse;
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void OnMorseClick() {
		System.out.println(txtMorse.getText());
	}
	
	@FXML
	public void OnLettersClick() {
		System.out.println(txtLetters.getText());
	}

	@FXML
	public void OnPlayClick() {
		//jouer le son
	}
	
	@FXML
	public void OnMorseKeyReleased() {
		//controller la saisie des caracteres
		String txt = "";
		for (int i = 0; i < txtMorse.getText().length(); i++) {
			if (txtMorse.getText().charAt(i) == '-' || txtMorse.getText().charAt(i) == '.' || txtMorse.getText().charAt(i) == ' ') {
				txt += txtMorse.getText().charAt(i);
			}
		}
		txtMorse.setText(txt);
		txtMorse.positionCaret(txtMorse.getText().length()+1);
	}
}
