package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Rechnungschreiben {

	public void schreibeString(String input){
	
		File a = new File("./Rechnung.txt");
		FileWriter fw=null;
			try {
			fw = new FileWriter(a);
			} catch (IOException e) {
				System.out.println("Kann nicht auf Datei zugreifen");
			}
			try {
				fw.write(input);
			} catch (IOException e) {
				System.out.println("Kann nicht auf Datei schreiben");
			}
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Kann nicht den FileWriter schliessen");
			}
	}
}