package application;

import javafx.stage.Stage;

public class MainControler {
	
	Between_Window window;
	Stage primaryStage = new Stage();
	
	public void search(){
		BetweenControler.counter = 1;
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void insert(){
		BetweenControler.counter = 2;
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void delete(){
		BetweenControler.counter = 3;
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void create(){
		BetweenControler.counter = 4;
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void show(){
		BetweenControler.counter = 5;
		window = new Between_Window();
		window.start(primaryStage);
	}
	
	public void update(){
		BetweenControler.counter = 6;
		window = new Between_Window();
		window.start(primaryStage);
	}

}
