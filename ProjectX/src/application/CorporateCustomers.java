package application;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CorporateCustomers {
	
	public final IntegerProperty id;
	public final StringProperty name; 
	int fikusnummer;
	
	public CorporateCustomers(){
		this(0,null,0);		
	}
	
	public CorporateCustomers(int sid,String sname, int szähler){
		this.id = new SimpleIntegerProperty(sid);
		this.name = new SimpleStringProperty(sname);
		this.fikusnummer = szähler;
	}

	public Integer getid(){
		return id.get();
	}
	
	public void setid(int fid){
		id.set(fid);
	}
	
	public String getName(){
		return name.get();
	}	
	
	public void setname(String fname){
		name.set(fname);
	}
	
	public IntegerProperty idproperty(){
		return id;
	}
	
	public StringProperty stringproperty(){
		return name;
	}
	
	public String toString(){
		return (fikusnummer+".Fikus:\nID : "+ id.get() +"\nName : "+ name.get());
	}
}
