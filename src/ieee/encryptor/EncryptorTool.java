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

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

		if (this.type == "encrypt") {			
			String dec = this.decimal.getText();
	    	
			try {
				float value = Float.parseFloat(dec);
			
				IEEEFloat bin = Encryptor.encryptIEEEFloat(value);
				
				binary.setText(bin.toString());
				
			} catch (Exception e1) {
				binary.setText("ERROR: Invalid Float Input!");
			} 		
		    
		} else if (this.type == "decrypt") {
			String bin = this.binary.getText();

	        Pattern ieeeRegex = Pattern.compile("^[01]{32}$");
			Matcher m = ieeeRegex.matcher(bin);
			
			if (m.matches()) {
		    	IEEEFloat value = Encryptor.getIEEEFloat(bin);
		    	
				float dec = Encryptor.decryptIEEEFloat(value);

				decimal.setText(Float.toString(dec));
		    } else {
		    	decimal.setText("ERROR: Invalid Binary Input!");
		    }

		} 
	}
}
