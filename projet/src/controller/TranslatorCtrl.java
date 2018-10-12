package controller;

import javax.sound.sampled.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import model.Arbre;

/**
 * classe Translator Controller
 * @author Mathieu
 * 
 */
public class TranslatorCtrl implements EventHandler<ActionEvent> {

	@FXML
	TextArea txtLetters;
	@FXML
	TextArea txtMorse;
	
	public static float SAMPLE_RATE = 8000f; 
	
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void OnMorseClick() {
		System.out.println(txtMorse.getText());
		//Arbre nd = new Arbre();
		//nd.getLetter(txtMorse.getText());
	}
	
	@FXML
	public void OnLettersClick() {
		System.out.println(txtLetters.getText());
	}

	@FXML
	public void OnPlayClick() throws InterruptedException, LineUnavailableException {
		//jouer le son
		String morse = txtMorse.getText();
		for (int i = 0; i < morse.length(); i++) {
			String c = morse.substring(i,  i+1);
			if (c.equals(".")) {
				tone(2500, 100, 1.0);
			}
			else if (c.equals("-")) {
				tone(2500, 200, 1.0);
			}
			else if (c.equals(" ")) {
				Thread.sleep(100);
			}
		}
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
	
	public static void tone(int hz, int msecs, double vol) throws LineUnavailableException 
	{ 
		byte[] buf = new byte[1]; 
		AudioFormat af = 
		new AudioFormat(
			SAMPLE_RATE, // sampleRate 
			8,   // sampleSizeInBits 
			1,   // channels 
			true,  // signed 
			false);  // bigEndian 
		SourceDataLine sdl = AudioSystem.getSourceDataLine(af); 
		sdl.open(af); 
		sdl.start(); 
		for (int i=0; i < msecs*8; i++) { 
			double angle = i/(SAMPLE_RATE/hz) * 2.0 * Math.PI; 
			buf[0] = (byte)(Math.sin(angle) * 127.0 * vol); 
			sdl.write(buf,0,1); 
		} 
		sdl.drain(); 
		sdl.stop(); 
		sdl.close(); 
	} 
}
