package application;

import java.sql.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class License {

	public IntegerProperty idlizenz;
	public StringProperty typ;
	public IntegerProperty status;
	public IntegerProperty maintenanceinfo;
	public IntegerProperty rabatt;
	public ObjectProperty<Date> verkaufsdatum;
	public ObjectProperty<Date> ablaufdatum;
	public StringProperty lizenzcol;
	public IntegerProperty maintenanceid;
	public IntegerProperty produktid;
	public IntegerProperty perkusid;
	public StringProperty installationsschluessel;
	int lizenznummer;
	
	
	public License(int idlizenz,String typ,String installationsschluessel,int status,
			int maintenanceinfo,int rabatt,Date verkaufsdatum,Date ablaufdatum,String lizenzcol,
			int maintenanceid,int produktid,int perkusid,int lizenznummer){
		
		this.idlizenz = new SimpleIntegerProperty(idlizenz);
		this.typ = new SimpleStringProperty(typ);
		this.status = new SimpleIntegerProperty(status);
		this.maintenanceinfo = new SimpleIntegerProperty(maintenanceinfo);
		this.rabatt = new SimpleIntegerProperty(rabatt);
		this.verkaufsdatum = new SimpleObjectProperty<Date>(verkaufsdatum);
		this.ablaufdatum = new SimpleObjectProperty<Date>(ablaufdatum);
		this.lizenzcol = new SimpleStringProperty(lizenzcol);
		this.produktid = new SimpleIntegerProperty(produktid);
		this.perkusid = new SimpleIntegerProperty(perkusid);
		this.installationsschluessel = new SimpleStringProperty(installationsschluessel);
		this.maintenanceid = new SimpleIntegerProperty(maintenanceid);
		this.lizenznummer = lizenznummer;
		
	}
	
	public Integer getidlizenz(){
		return idlizenz.get();
	}
	
	public String gettyp(){
		return typ.get();
	}
	
	public String getinstallationsschluessel(){
		return installationsschluessel.get();
	}
	
	public Integer getstatus(){
		return status.get();
	}
	
	public Integer getmaintenanceinfo(){
		return maintenanceinfo.get();
	}
	
	public Integer getrabatt(){
		return rabatt.get();
	}
	
	public Date getverkaufsdatum(){
		return verkaufsdatum.get();
	}
	
	public Date getablaufdatum(){
		return ablaufdatum.get();
	}
	
	public String getlizenzcol(){
		return lizenzcol.get();
	}
	
	public Integer getmaintenanceid(){
		return maintenanceid.get();
	}
	
	public Integer getproduktid(){
		return produktid.get();
	}
	
	public Integer getperkusid(){
		return perkusid.get();
	}
	
	public String toString(){
		return (lizenznummer+".License:\nID: "+ idlizenz.get() +"	Typ: "+ typ.get()
		+"	Installationsschluessel: "+installationsschluessel.get()+"  Status: "+ status.get()+"	Maintenanceinfo: "+maintenanceinfo.get()+"	Rabatt: "+rabatt.get()
		+"\nVerkaufsdatum: "+verkaufsdatum.get()+"	Ablaufdatum: "+ablaufdatum.get()
		+"		Lizenzcol: "+lizenzcol.get()+"\nMaintenanceid: "+maintenanceid.get()+"	Produktid: "+produktid.get()
		+"	Perkusid: "+perkusid.get());
	}
}
