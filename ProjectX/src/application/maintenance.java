package application;

import java.sql.Date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class maintenance {

	public int maintenanceid;
	public Date gueltigkeit;
	public float betrag;
	
	
	public maintenance(int maintenanceid,Date gueltigkeit,float betrag){
		
		this.maintenanceid = maintenanceid;
		this.gueltigkeit = gueltigkeit;
		this.betrag = betrag;
	}
}
