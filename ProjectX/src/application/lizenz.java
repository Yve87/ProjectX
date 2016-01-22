package application;

import java.sql.Date;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class lizenz {

	public int idlizenz;
	public String typ;
	public int status;
	public int maintenanceinfo;
	public int rabatt;
	public Date verkaufsdatum;
	public Date ablaufdatum;
	public String lizenzcol;
	public int maintenanceid;
	public int produktid;
	public int perkusid;
	public String installationsschluessel;
	
	
	public lizenz(int idlizenz,String typ,int status,int maintenanceinfo,int rabatt,
			Date verkaufsdatum,Date ablaufdatum,String lizenzcol,int mainenanceid,
			int produktid,int perkusid,String installationsschluessel){
		
		this.idlizenz = idlizenz;
		this.typ = typ;
		this.status = status;
		this.maintenanceinfo = maintenanceinfo;
		this.rabatt = rabatt;
		this.verkaufsdatum = verkaufsdatum;
		this.ablaufdatum = ablaufdatum;
		this.lizenzcol = lizenzcol;
		this.produktid = produktid;
		this.perkusid = perkusid;
		this.installationsschluessel = installationsschluessel;
		
	}
}
