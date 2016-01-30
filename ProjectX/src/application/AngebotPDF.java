package application;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class AngebotPDF {

	public void schreibeString(String input){
	
		File file = new File("./Angebot.pdf");
		FileWriter fw=null;
			try {
			fw = new FileWriter(file);
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