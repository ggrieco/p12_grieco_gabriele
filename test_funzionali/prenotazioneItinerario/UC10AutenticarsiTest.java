package prenotazioneItinerario;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Before;
import org.junit.Test;
/*
 * I seguenti test case si riferiscono al caso d'uso UC10 presente nel file di
 * documentazione "srs_p12_grieco_gabriele.odt"; gli scenari alternativi 4a,
 * 4a.3a, 4a.5a, 4a.8a, 4a.8a.2a non sono stati inclusi nei test, poichè riguardano
 * la parte di recupero della password mediante risposta alla domanda di ripristino,
 * e tale parte non è stata implementata in questa release del programma.
 */
public class UC10AutenticarsiTest {
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
	
	/*
	 * Il test seguente riprende lo scenario principale nel quale la
	 * procedura completa di autenticazione avviene con successo
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioPrincipale() {
		String usr="gabry91";
		String pwd="Pass@word";
		
		assertTrue("credenziali ok",s.autenticazione(usr,pwd));
		
		Integer exp=1;		
		assertEquals("login ok",exp,s.login(usr,pwd));
	}
	
	/*
	 * Il test seguente riprende lo scenario alternativo 7a che considera
	 * il caso nel quale lo username non venga trovato dal sistema tra
	 * quelli degli utenti registrati
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo7a() {
		String usr="gabry99";
		String pwd="Pass@word";
		
		assertTrue("credenziali ok",s.autenticazione(usr,pwd));
		
		Integer exp=-1;		
		assertEquals("username non riconosciuto",exp,s.login(usr,pwd));
	}
	
	/*
	 * Il test seguente riprende lo scenario alternativo 7b che considera il caso
	 * nel quale lo username inserito è riconosciuto dal sistema ma la password
	 * non è corretta; non è però ancora stato raggiunto il limite di tentativi
	 * errati
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo7b() {
		String usr="gabry91";
		String pwd="Aaaa@word";
		
		assertTrue("credenziali ok",s.autenticazione(usr,pwd));
		
		Integer exp=2;		
		assertEquals("username ok, password errata",exp,s.login(usr,pwd));
	}
	
	/*
	 * Il test seguente riprende lo scenario alternativo 7c che considera il caso
	 * nel quale ci siano errori di compilazione nello username o nella password
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo7c() {
		String usr="";
		String pwd="Pass@word@word";
		
		assertFalse("errore inserimento credenziali",s.autenticazione(usr,pwd));
	}
	
	/*
	 * Il test seguente riprende lo scenario alternativo 7b.2a che considera il
	 * caso nel quale è stata inserita tre volte consecutive la password errata
	 * e quindi l'account è stato bloccato
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo7b2a() {
		String usr="anna83";
		String pwd="Aaaa@word";
		
		assertTrue("credenziali ok",s.autenticazione(usr,pwd));
		
		Integer exp=0;		
		assertEquals("username ok, password errata, limite tentativi raggiunto",
					 exp,s.login(usr,pwd));
	}
	
	/*
	 * Il test seguente riprende lo scenario alternativo 8a che considera il
	 * caso nel quale l'account al quale si tenta di accedere è già stato 
	 * bloccato precedentemente
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo8a() {
		String usr="rita63";
		String pwd="Pass@word";
		
		assertTrue("credenziali ok",s.autenticazione(usr,pwd));
		
		Integer exp=0;		
		assertEquals("username ok, password ok, account già bloccato",
					 exp,s.login(usr,pwd));
	}
}
