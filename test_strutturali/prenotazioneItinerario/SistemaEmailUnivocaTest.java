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

public class SistemaEmailUnivocaTest {
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
		String e="gg1991@hotmail.it";
		s.setInd1("");
		
		assertFalse("IOException",s.emailUnivoca(e));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd1("src/prenotazioneItinerario/UtentiRegistrati.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEmailNonPresente() {		
		String e="gg1991@gmail.com";
		
		assertTrue("L'email non è presente presente nel sistema",s.emailUnivoca(e));
}

	@SuppressWarnings("static-access")
	@Test
	public void testEmailPresente() {
		String e="gg1991@hotmail.it";
		
		assertFalse("L'email è già presente nel sistema",s.emailUnivoca(e));
	}
}
