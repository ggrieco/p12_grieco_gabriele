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

public class SistemaUsernameUnivocoTest {
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
		String usr="gabry91";
		s.setInd1("");
		
		assertFalse("IOException",s.userUnivoco(usr));		
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd1("src/prenotazioneItinerario/UtentiRegistrati.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameNonPresente() {		
		String usr="gabry19";
		
		assertTrue("username non presente nel sistema",s.userUnivoco(usr));
}

	@SuppressWarnings("static-access")
	@Test
	public void testUsernamePresente() {
		String usr="gabry91";
		
		assertFalse("username già presente nel sistema",s.userUnivoco(usr));
	}
}
