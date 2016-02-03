package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Location {

	public IntegerProperty standortid;
	public StringProperty name;
	public StringProperty strasse;
	public IntegerProperty hausnummer;
	public IntegerProperty plz;
	public IntegerProperty pls;
	public IntegerProperty postfachnummer;
	public IntegerProperty telefon;
	public IntegerProperty fikusid;
	public IntegerProperty perkusid;
	int standortnummer;
	
	
	public Location(int standortid, String name, String strasse, int hausnummer,
			int plz, int pls, int postfachnummer, int telefon, int fikusid, int perkusid, int zähler){
		
		this.standortid = new SimpleIntegerProperty(standortid);
		this.name = new SimpleStringProperty(name);
		this.strasse = new SimpleStringProperty(strasse);
		this.hausnummer = new SimpleIntegerProperty(hausnummer);
		this.plz = new SimpleIntegerProperty(plz);
		this.pls = new SimpleIntegerProperty(pls);
		this.postfachnummer = new SimpleIntegerProperty(postfachnummer);
		this.telefon = new SimpleIntegerProperty(telefon);
		this.fikusid = new SimpleIntegerProperty(fikusid);
		this.perkusid = new SimpleIntegerProperty(perkusid);
		this.standortnummer = zähler;
	}
	
	public Integer getstandortid(){
		return standortid.get();
	}
	
	public String getname(){
		return name.get();
	}
	
	public String getstrasse(){
		return strasse.get();
	}
	
	public Integer gethausnummer(){
		return hausnummer.get();
	}
	
	public Integer getplz(){
		return plz.get();
	}
	
	public Integer getpls(){
		return pls.get();
	}
	
	public Integer getpostfachnummer(){
		return postfachnummer.get();
	}
	
	public Integer gettelefon(){
		return telefon.get();
	}
	
	public Integer getfikusid(){
		return fikusid.get();
	}
	
	public Integer getperkusid(){
		return perkusid.get();
	}
	
	public String toString(){
		return (standortnummer+".Location:\nID: "+ standortid.get() +"	Name: "+ name.get()
		+"	Strasse: "+ strasse.get()+"	   Hausnummer: "+hausnummer.get()+"	 Plz: "+plz.get()
		+"\nPls: "+pls.get()+"	  Postfachnummer: "+postfachnummer.get()
		+"	  Telefon: "+telefon.get()+"\nFikusid: "+fikusid.get()+"		Perkusid: "+perkusid.get());
	}
}
