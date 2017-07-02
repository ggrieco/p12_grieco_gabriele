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

public class SistemaAssegnaFFTest {
	Sistema s=new Sistema();
	
	@Before
	public void setUp() throws IOException {
		BufferedReader b=new BufferedReader(new FileReader("src/prenotazioneItinerario/"
														 + "UtentiRegistratiOriginal.txt"));
		FileWriter w= new FileWriter("src/prenotazioneItinerario/UtentiRegistrati.txt");			
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
		s.setInd1("");
		String exp="errore";
		
		assertEquals("IOException",exp, s.assegnaFF());
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd1("src/prenotazioneItinerario/UtentiRegistrati.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void test() {
		String exp="GG942110";
		assertEquals("assegna FF univoco",exp,s.assegnaFF());
	}	
}
