package application;
	
import java.sql.SQLException;

import application.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import java.sql.*;


public class Main extends Application {
	
	public void start(Stage primaryStage) {
		try {
			Between_Window between = new Between_Window();
			AnchorPane pane = new AnchorPane();
			Parent root = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
			Scene scene = new Scene(pane, 500,500);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Button button = new Button("Drück mich:D");
			button.setOnAction(e -> between.start(primaryStage));
			pane.getChildren().add(button);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Test");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			java.sql.Connection conn = Connection.connecten();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Database connected!");
		launch(args);

		
	}
}
