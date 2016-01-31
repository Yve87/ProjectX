package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Perkus {

	public IntegerProperty id;
	public StringProperty name;
	public StringProperty vorname;
	public StringProperty anrede;
	public StringProperty titel;
	public StringProperty abteilung;
	public StringProperty gebaeudenummer;
	public StringProperty zimmernummer;
	public StringProperty tel;
	public StringProperty fax;
	public StringProperty email;
	public StringProperty position;
	public IntegerProperty fikusid;
	int perkusnummer;
	
	
	public Perkus(){
		this(0,null,null,null,null,null,null,null,null,null,null,null,0,0);
		
	}
	
	public Perkus(int id,String name,String vorname, String anrede, String titel, 
			String abteilung,String gebaeudenummer, String zimmernummer,String tel,
			String fax,String email,String position,int fikusid,int zähler){
		
		this.id = new SimpleIntegerProperty(id);
		this.name = new SimpleStringProperty(name);
		this.vorname = new SimpleStringProperty(vorname);
		this.anrede = new SimpleStringProperty(anrede);
		this.titel = new SimpleStringProperty(titel);
		this.abteilung = new SimpleStringProperty(abteilung);
		this.gebaeudenummer = new SimpleStringProperty(gebaeudenummer);
		this.zimmernummer = new SimpleStringProperty(zimmernummer);
		this.tel = new SimpleStringProperty(tel);
		this.fax = new SimpleStringProperty(fax);
		this.email = new SimpleStringProperty(email);
		this.position = new SimpleStringProperty(position);
		this.fikusid = new SimpleIntegerProperty(fikusid);
		this.perkusnummer = zähler;
	}
	
	public Integer getid(){
		return id.get();
	}
	
	public String getname(){
		return name.get();
	}
	
	public String getvorname(){
		return vorname.get();
	}
	
	public String getanrede(){
		return anrede.get();
	}
	
	public String gettitel(){
		return titel.get();
	}
	
	public String getabteilung(){
		return abteilung.get();
	}
	
	public String getgebaeudenummer(){
		return gebaeudenummer.get();
	}
	
	public String getzimmernummer(){
		return zimmernummer.get();
	}
	
	public String gettel(){
		return tel.get();
	}
	
	public String getemail(){
		return email.get();
	}
	
	public String getposition(){
		return position.get();
	}
	
	public String getfax(){
		return fax.get();
	}
	
	public Integer getfikusid(){
		return fikusid.get();
	}
	
	public String toString(){
		return (perkusnummer+".Perkus:\nID: "+ id.get() +"	Name: "+ name.get()
		+"	Vorname: "+ vorname.get()+"	Anrede: "+anrede.get());
	}
}
