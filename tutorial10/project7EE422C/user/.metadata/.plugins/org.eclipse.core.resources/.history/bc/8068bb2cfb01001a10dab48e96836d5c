package assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable{

	private static ClientThread myThread;

    public LoginController(Stage window) throws UnknownHostException, IOException {
		super();
		this.window = window;
		myThread = new ClientThread();
		
	}
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}

	@FXML
    private  TextField username;

	@FXML
    private PasswordField passwordField;

    @FXML
    private  Button loginButton;
    
    @FXML
    private  Label text;
    @FXML
    private FontAwesomeIconView minimizeIcon;

    @FXML
    private FontAwesomeIconView exitIcon;
    
    private double initialX= 0;
	private double initialY= 0;

    @FXML
    void handleCancelButtonAction(ActionEvent event) {
    	myThread.setState("quit");
    	myThread.sendWriter("");
    	
    	
    }

    @FXML
    void handleLoginButtonAction(ActionEvent event) throws InterruptedException {
    	
    	
    	//process a name change
    	if(username.getText().trim().length() > 0 && passwordField.getText().trim().length() > 0 )
    		{
    		myThread.setState("login");
    		myThread.sendWriter(username.getText() + " " + passwordField.getText());
    	}
    	else {
    		text.setText("Please input valid Strings for input");
    	}
    	
    	while(!myThread.isControllerReady()) {
    		System.out.println("Controller waiting......");
        	}
    	
    	//Checks if it can open the dash
    	if(myThread.isOpenDashBool()) {
    		mediaPlayerDashLogin.play();
    		openDash();
    	}
    	else {
    		text.setText(myThread.getServerMessage());
    	}
    	
    	
    	
    }
    @FXML
    void handleNewUserLogin(ActionEvent event) throws InterruptedException {
    	if(username.getText().trim().length() > 0 && passwordField.getText().trim().length() > 0 ) {
	    	mediaPlayerNotification.play();
	    	myThread.setState("newUser");
	    	

	    	myThread.sendWriter(username.getText().trim() + " " + passwordField.getText().trim());
	    	
    	}
    	else {
    		text.setText("Please input valid Strings for input");

    	}
    	
    	while(!myThread.isControllerReady()) {
        	System.out.println("Controller waiting.");
    	}
    	text.setText(myThread.getServerMessage());

    	if(myThread.isOpenDashBool()) {
    		mediaPlayerDashLogin.play();
    		openDash();
    	}
    	else {
    		text.setText(myThread.getServerMessage());
    	}
    }
    @FXML
    void exitProgram(MouseEvent event) {
    	myThread.setState("quit");
    	myThread.sendWriter("");
    	System.exit(2);
    	window.close();
    }

    @FXML
    void lowerScreen(MouseEvent event) {
    	window.toBack();
    }
    @FXML
    void getInitialStage(MouseEvent event) {
	  
	  	initialX = event.getSceneX();
      	initialY = event.getSceneY();
    }
  
  @FXML
    void stageDrag(MouseEvent event) {
	  window.setX(event.getScreenX() - initialX);
      window.setY(event.getScreenY() - initialY);
      
    }
    
    /*
	 * JavaFx scenes and files for music
	 */
    Stage window;
	
    Stage dashStage = new Stage();
	
    String error = "errorLogin.mp3";   
	Media errorSound = new Media(new File(error).toURI().toString());
	MediaPlayer mediaPlayerError = new MediaPlayer(errorSound);
	
	String dashLogin = "loginSuccess.mp3";   
	Media dashLoginSound = new Media(new File(dashLogin).toURI().toString());
	MediaPlayer mediaPlayerDashLogin = new MediaPlayer(dashLoginSound);
	
	String notification = "notification.mp3";   
	Media notificationSound = new Media(new File(notification).toURI().toString());
	MediaPlayer mediaPlayerNotification = new MediaPlayer(notificationSound);
	
    
    
    
    
   
	
	public void openDash() {
		
	
			
	new Dash(myThread, window);
	
	
		
	}

	
	
		
	

}
