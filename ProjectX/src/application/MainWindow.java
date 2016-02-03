package application;
	
import java.sql.SQLException;

import application.Connection;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import java.sql.*;


public class MainWindow extends Application {
	
	static Stage stage;
	static Alert alert = new Alert(AlertType.ERROR);
	
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("MainWindow_Controller.fxml"));
			Scene scene = new Scene(root, 1200,700);
			scene.getStylesheets().add(getClass().getResource("DarkTheme.css").toExternalForm());
			//System.setProperty( "javafx.userAgentStylesheetUrl", "CASPIAN" );
			//setUserAgentStylesheet(STYLESHEET_CASPIAN);
			stage = primaryStage;
			stage.setScene(scene);
			stage.setTitle("Start");
			stage.show();
					
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		try {
			java.sql.Connection conn = Connection.connecten();
			System.out.println("Database connected!");
		} catch (InstantiationException e) {
			// TODO Auto-generat3ed catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			/*alert.setTitle("Error");
			alert.setHeaderText("Database Connection Fail");
			alert.setContentText("Oops en Error occured");
			alert.showAndWait();
			System.out.println("Database Connection failed!");*/
		}
		launch(args);	
	}
}

