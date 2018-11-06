package view;

// import packages
import model.Arbre;

import java.io.IOException;
import java.net.URL;

import controller.GArbre;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application{
	
	static Stage parentWindow;

	@Override
	public void start(Stage primaryStage) throws IOException {
		// TODO Auto-generated method stub
		parentWindow = primaryStage;
		
		final URL fxmlUrl = getClass().getResource("/MorseTranslator.fxml");
		final FXMLLoader fxmlLoader = new FXMLLoader(fxmlUrl);
		final BorderPane borderpane = (BorderPane) fxmlLoader.load();
		Scene scene = new Scene(borderpane);
		
		parentWindow.setScene(scene);
		
		parentWindow.show();
	}
	
	public static void main(String[] args) {
		GArbre.creerArbre();
		launch(args);
	}

}
