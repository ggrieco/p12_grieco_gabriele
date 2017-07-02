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
 * I seguenti test case si riferiscono al caso d'uso UC1 presente nel file di
 * documentazione "srs_p12_grieco_gabriele.odt". I passi dal numero 12 al numero
 * 18 dello scenario principale non sono inclusi nei testi poichè la parte di 
 * conferma della registrazione tramite mail non è stata implementata in questa
 * release del programma: per lo stesso motivo non è incluso nei test nemmeno
 * lo scenario alternativo 14a 
 */
public class UC1RegistrazioneNuovoAccount {
	Sistema s=new Sistema();
	Persona p=new Persona();
	UtenteRegistrato u=new UtenteRegistrato();
	String d="";
	
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
	 * Il test seguente riguarda lo scenario principale che considera il
	 * caso nel quale la precedura di registrazione di un nuovo account
	 * avvenga con successo
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioPrincipale() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@gmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome della madre");
		u.setRisposta("eleonora");
		
		exp=3;
		assertEquals("registrazione avvenuta con successo",exp,s.registrazioneAccount(u));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 6a che considera il
	 * caso nel quale siano presenti errori di compilazione nei dati personali
	 * inseriti
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo6a() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=-1;
		assertEquals("errore nei dati di anagrafica",exp,s.datiAnagrafica(p, d));	
	}
	
	/*
	 *Il test seguente riguarda lo scenario alternativo 11a che considera il
	 * caso nel quale l'indirizzo e-mail inserito è già presente nel sistema
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11a() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@hotmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome della madre");
		u.setRisposta("eleonora");
		
		exp=2;
		assertEquals("indirizzo e-mail già presente nel sistema",exp,s.registrazioneAccount(u));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11b che considera il
	 * caso nel quale lo username inserito è già presente nel sistema
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11b() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@gmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry91");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome della madre");
		u.setRisposta("eleonora");
		
		exp=0;
		assertEquals("username già presente nel sistema",exp,s.registrazioneAccount(u));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11c che considera il
	 * caso nel quale la password inserita per il nuovo account non rispetta
	 * le specifiche di sicurezza richieste
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11c() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@gmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry29");
		u.setPwd1("pass@word");
		u.setPwd2("pass@word");
		u.setDomanda("nome della madre");
		u.setRisposta("eleonora");
		
		exp=-1;
		assertEquals("password non rispetta gli standard di sicurezza richiesti",exp,
					 s.registrazioneAccount(u));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11d che considera il
	 * caso nel quale la domanda di ripristino password non sia stata inserita
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11d() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@gmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("");
		u.setRisposta("eleonora");
		
		exp=-1;
		assertEquals("domanda recupero password non inserita correttamente",
					 exp,s.registrazioneAccount(u));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11e che considera il
	 * caso nel quale la risposta alla domanda di ripristino password non sia
	 * stata inserita
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11e() {
		p.inizializzaDataNascita();
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="via xx settembre 11 genova ITALIA";
		
		Integer exp=1;
		assertEquals("dati ok",exp,s.datiAnagrafica(p, d));
		
		p.setEmail("gg1991@gmail.it");
		u.setAnagrafica(p);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome della madre");
		u.setRisposta("");
		
		exp=-1;
		assertEquals("risposta domanda recupero password non inserita correttamente",
					 exp,s.registrazioneAccount(u));		
	}
}
