package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class BetweenWindow_Controller {
	
	public void fikus_button(){

			Stage primarystage = new Stage();
			PeopleCustomersWindow window = new PeopleCustomersWindow();
			window.start(primarystage);
	}
		
	public void perkus_button(){

			Stage primarystage = new Stage();
			CorporateCustomers_window window = new CorporateCustomers_window();
			window.start(primarystage);
	}
	
	public void standort_button(){

			Stage primarystage = new Stage();
			LocationWindow window = new LocationWindow();
			window.start(primarystage);
	}
	
	public void produkt_button(){

			Stage primarystage = new Stage();
			ProductWindow window = new ProductWindow();
			window.start(primarystage);
	}
	
	public void lizenz_button(){
		
			Stage primaryStage = new Stage();
			LicenseWindow window = new LicenseWindow();
			window.start(primaryStage);
	}
	
	public void maintenance_button(){
		
			Stage primaryStage = new Stage();
			MaintenanceWindow window = new MaintenanceWindow();
			window.start(primaryStage);
	}
	
	public void leasing_button() {
		Stage primaryStage = new Stage();
		LeasingWindow window = new LeasingWindow();
		window.start(primaryStage);
	}
}