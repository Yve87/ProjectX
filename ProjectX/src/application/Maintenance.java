package application;

import java.sql.Date;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Maintenance {

	public IntegerProperty maintenanceid;
	public ObjectProperty<Date> gueltigkeit;
	public FloatProperty betrag;
	int mnummer;
	
	
	public Maintenance(int maintenanceid,Date gueltigkeit,float betrag,int mnummer){
		
		this.maintenanceid = new SimpleIntegerProperty(maintenanceid);
		this.gueltigkeit = new SimpleObjectProperty<Date>(gueltigkeit);
		this.betrag = new SimpleFloatProperty(betrag);
		this.mnummer = mnummer;
	}
	
	public Integer getmaintenanceid(){
		return maintenanceid.get();
	}
	
	public Date getgueltigkeit(){
		return gueltigkeit.get();
	}
	
	public Float getbetrag(){
		return betrag.get();
	}
	
	public String toString(){
		return (mnummer+".Maintenance:\nID: "+ maintenanceid.get() +"	 Gueltigkeit: "+ gueltigkeit.get()
		+"	 Betrag: "+ betrag.get());
	}
}
