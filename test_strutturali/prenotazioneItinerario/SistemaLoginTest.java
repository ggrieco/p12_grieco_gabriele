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

public class SistemaLoginTest {
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
	public void testIOExceptionFileInput() {
		String usr="anna83";
		String pwd="word";
		s.setInd1("asd/qwe");
		
		Integer exp=3;
		assertEquals("IOException file UtentiRegistrati.txt",exp,s.login(usr,pwd));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd1("src/prenotazioneItinerario/UtentiRegistrati.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOExceptionFileOutput() {
		String usr="anna83";
		String pwd="word";
		s.setInd7("asd/qwe");
		
		Integer exp=3;
		assertEquals("IOException file tmpUtentiRegistrati.txt",exp,s.login(usr,pwd));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown2() {
		s.setInd7("src/prenotazioneItinerario/tmpUtentiRegistrati.txt");
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameOkPasswordErrata2ErroriPrecedenti() {
		String usr="anna83";
		String pwd="word";
		
		Integer exp=0;
		assertEquals("username ok, password errata, tentativi precedenti 2",
					 exp,s.login(usr,pwd));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameOkPasswordOkAccountBloccato() {
		String usr="rita63";
		String pwd="Pass@word";
		
		Integer exp=0;
		assertEquals("username ok, password ok, account già bloccato",
					 exp,s.login(usr,pwd));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameOkPasswordErrata0TentativiPrecedenti() {
		String usr="francy73";
		String pwd="Pass@";
		
		Integer exp=2;
		assertEquals("username ok, password ko, tentativi precedenti 0",
					 exp,s.login(usr,pwd));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameOkPasswordErrata1TentativoPrecedente() {
		String usr="giulia87";
		String pwd="@word";
		
		Integer exp=2;		
		assertEquals("username ok, password ko, tentativi precedenti 1",
					 exp,s.login(usr,pwd));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameOkPasswordOkAccountOk() {
		String usr="gabry91";
		String pwd="Pass@word";
		
		Integer exp=1;
		assertEquals("username ok, password ok, account non bloccato",
					 exp,s.login(usr,pwd));
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUsernameNonPresente() {
		String usr="andrea78";
		String pwd="word@Pass";
		
		Integer exp=-1;
		assertEquals("username non presente nel sistema",exp,s.login(usr,pwd));
	}
}

