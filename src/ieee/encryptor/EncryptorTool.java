package ieee.encryptor;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
// import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class EncryptorTool extends Application {

	private TextArea decimal, binary;
	private Button encrypt, decrypt;

	
	public static void main(String[] args) {
		// TODO Implement GUI
		launch(args);
	}

	
	@Override
	public void start(Stage stage) throws Exception {
		VBox pane = new VBox();
		
		this.decimal = new TextArea("Enter decimal floating point here.");
		this.binary = new TextArea("Enter binary IEEE float here.");
		
		this.encrypt = new Button("Encrypt");
		this.decrypt = new Button("Decrypt");
		
		this.encrypt.setOnAction(new Conversion("encrypt", decimal, binary));
		this.decrypt.setOnAction(new Conversion("decrypt", decimal, binary));
		
		pane.getChildren().add(decimal);
		pane.getChildren().add(encrypt);
		pane.getChildren().add(decrypt);
		pane.getChildren().add(binary);
		
				
		Scene scene = new Scene(pane, 300, 300);
		
		stage.setTitle("Encyptor");
		stage.setScene(scene);
		stage.show();
		
	}
}

class Conversion implements EventHandler<ActionEvent> {
	private String type;
	private TextArea decimal, binary;
	
	public Conversion(String type, TextArea decimal, TextArea binary) {
		this.type = type;
		this.decimal = decimal;
		this.binary = binary;
	}
	
	public void handle(ActionEvent e) {
		// TODO Use Regexes "(\\d+\\.\\d+)" and "([01]+)"
		
		if (this.type == "encrypt") {
			// TODO implement conversion and use Encryptor
		} else if (this.type == "decrypt") {
			// TODO implement conversion and use Encryptor
		} 
	}
}
