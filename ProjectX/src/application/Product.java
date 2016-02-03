package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Product {

	public IntegerProperty produktid;
	public StringProperty name;
	public IntegerProperty versionsnummer;
	public IntegerProperty listenpreis;
	public StringProperty systemvoraussetzung;
	public StringProperty produktcol;
	int produktnummer;
	
	
	public Product(int produktid,String name, int versionsnummer,int listenpreis,
			String systemvoraussetzung,String produktcol,int produktnummer){
		
		this.produktid = new SimpleIntegerProperty(produktid);
		this.name = new SimpleStringProperty(name);
		this.versionsnummer = new SimpleIntegerProperty(versionsnummer);
		this.listenpreis = new SimpleIntegerProperty(listenpreis);
		this.systemvoraussetzung = new SimpleStringProperty(systemvoraussetzung);
		this.produktcol = new SimpleStringProperty(produktcol);
		this.produktnummer = produktnummer;
	}
	
	public Integer getproduktid(){
		return produktid.get();
	}
	
	public String getname(){
		return name.get();
	}
	
	public Integer getversionsnummer(){
		return versionsnummer.get();
	}
	
	public Integer getlistenspreis(){
		return listenpreis.get();
	}
	
	public String getsystemvoraussetzung(){
		return systemvoraussetzung.get();
	}
	
	public String getproduktcol(){
		return produktcol.get();
	}
	
	public String toString(){
		return (produktnummer+".Product:\nID: "+ produktid.get() +"	Name: "+ name.get()
		+"	Versionsnummer: "+ versionsnummer.get()+"	  Listenpreis: "+listenpreis.get()
		+"	  Systemvoraussetzung: "+systemvoraussetzung.get()
		+"\nProduktcol: "+produktcol.get());
	}
}
