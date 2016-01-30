package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Fikus {
	
	public final int id;
	public final String name;
	
	
	public Fikus(int id,String name){
		this.id = id;
		this.name = name;
	}

	public Integer getid(){
		return id;
	}
	
	public String getName(){
		return name;
	}	
}
