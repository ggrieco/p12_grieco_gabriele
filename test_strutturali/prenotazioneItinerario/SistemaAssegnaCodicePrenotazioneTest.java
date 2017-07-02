package prenotazioneItinerario;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SistemaAssegnaCodicePrenotazioneTest {
	Sistema s=new Sistema();
	
	@Before
	public void setUp() throws IOException {
		BufferedReader b=new BufferedReader(new FileReader("src/prenotazioneItinerario/"
														 + "PrenotazioniOriginal.txt"));
		FileWriter w= new FileWriter("src/prenotazioneItinerario/Prenotazioni.txt");			
	    PrintWriter out = new PrintWriter(w);
	    String l=b.readLine();
	    
	    while(l!=null){
	    	out.println(l);
	    	l=b.readLine();
	    }
	    b.close();
	    out.close();	   
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOException() {
		s.setInd2("");
		String exp="errore";
		
		assertEquals("IOException",exp, s.assegnaCodicePrenotazione());
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd2("src/prenotazioneItinerario/Prenotazioni.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test() {
		String exp="PNR110";
		assertEquals("assegnazione codice prenotazione univoco",exp,
					 s.assegnaCodicePrenotazione());
	}
}
