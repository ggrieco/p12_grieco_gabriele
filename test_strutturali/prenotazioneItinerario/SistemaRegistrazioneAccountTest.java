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

public class SistemaRegistrazioneAccountTest {
	Sistema s= new Sistema();
	UtenteRegistrato u=new UtenteRegistrato();
	Persona p=new Persona();
	Persona p2=new Persona();
	String d;
	
	@SuppressWarnings("static-access")
	@Before
	public void setUp()  throws IOException {
		
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
	    
		p.inizializzaDataNascita();
		p.setGiornoNascita(29);
		p.setMeseNascita(5);
		p.setAnnoNascita(1991);
		p.setEta(26);
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		s.getUtente().setAnagrafica(p);
		p2.setEmail("gg1991@hotmail.it");
		u.setAnagrafica(p2);
		s.getUtente().setDomicilio(d);
	}	
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOException() {
		p2.setEmail("gg1991@hotmail.it");
		u.setAnagrafica(p2);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome animale domestico");
		u.setRisposta("lola");
		s.setInd1("asd/qwe");
		
		Integer exp=4;
		assertEquals("IOException",exp,s.registrazioneAccount(u));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd1("src/prenotazioneItinerario/UtentiRegistrati.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEmailUnivoca() {
		p2.setEmail("gg1991@gmail.com");
		u.setAnagrafica(p2);
		u.setUsername("gabry29");
		u.setPwd1("Pass@word");
		u.setPwd2("Pass@word");
		u.setDomanda("nome animale domestico");
		u.setRisposta("lola");
		
		Integer exp=3;
		assertEquals("email univoca",exp,s.registrazioneAccount(u));		
	}
	
	@After
	public void tearDown2() {
		p2.setEmail("gg1991@hotmail.it");
		u.setAnagrafica(p2);
	}
	
	
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameMinore5Caratteri() {
			u.setUsername("gabr");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username < 5 caratteri",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameMaggiore10Caratteri() {
			u.setUsername("gabry91gabr");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("Username > 10 caratteri",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordMinore8Caratteri() {			
			u.setUsername("gabry91");
			u.setPwd1("Pass@wo");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("password < 8 caratteri",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordMaggiore12Caratteri() {			
			u.setUsername("gabry91");
			u.setPwd1("Pass@wordpass");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("password >12 caratteri",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere0() {
			u.setUsername("0gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 0",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere1() {
			u.setUsername("1gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 1",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere2() {
			u.setUsername("2gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 2",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere3() {
			u.setUsername("3gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 3",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere4() {
			u.setUsername("4gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 4",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere5() {
			u.setUsername("5gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 5",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere6() {
			u.setUsername("6gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 6",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere7() {
			u.setUsername("7gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 7",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere8() {
			u.setUsername("8gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 8",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernamePrimoCarattere9() {
			u.setUsername("9gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("primo carattere username = 9",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneSpazioVuoto() {
			u.setUsername("gabry 91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene spazio vuoto",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneChiocciola() {
			u.setUsername("gabry@91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene @",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneSlash() {
			u.setUsername("gabry/91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene /",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneBarraVerticale() {
			u.setUsername("gabry|91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene |",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneAsterisco() {
			u.setUsername("gabry*91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene *",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContienePuntoInterrogativo() {
			u.setUsername("gabry?91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene ?",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneSimboloMinore() {
			u.setUsername("gabry<91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene <",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneSimboloMaggiore() {
			u.setUsername("gabry>91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene >",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameContieneSimboloDuePunti() {
			u.setUsername("gabry:91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("username contiene :",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneSpazioVuoto() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@ word");
			u.setPwd2("Pass@ word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("password contiene spazio vuoto",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordNonContieneCaratteriSpeciali() {
			u.setUsername("gabry91");
			u.setPwd1("Password");
			u.setPwd2("Password");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("password non contiene caratteri speciali",exp,
						 s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneChiocciola() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene chiocciola",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneSlash() {
			u.setUsername("gabry91");
			u.setPwd1("Pass/word");
			u.setPwd2("Pass/word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene /",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneBarraVerticale() {
			u.setUsername("gabry91");
			u.setPwd1("Pass|word");
			u.setPwd2("Pass|word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene |",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneAsterisco() {
			u.setUsername("gabry91");
			u.setPwd1("Pass*word");
			u.setPwd2("Pass*word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene *",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContienePuntoInterrogativo() {
			u.setUsername("gabry91");
			u.setPwd1("Pass?word");
			u.setPwd2("Pass?word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene ?",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContienesimboloMinore() {
			u.setUsername("gabry91");
			u.setPwd1("Pass<word");
			u.setPwd2("Pass<word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene <",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneSimboloMaggiore() {
			u.setUsername("gabry91");
			u.setPwd1("Pass>word");
			u.setPwd2("Pass>word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene >",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContienesimboloDuePunti() {
			u.setUsername("gabry91");
			u.setPwd1("Pass:word");
			u.setPwd2("Pass:word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene :",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordNonContieneMaiuscole() {
			u.setUsername("gabry91");
			u.setPwd1("pass@word");
			u.setPwd2("pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("password non contiene Maiuscole",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneA() {
			u.setUsername("gabry91");
			u.setPwd1("Aass@word");
			u.setPwd2("Aass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene A",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneB() {
			u.setUsername("gabry91");
			u.setPwd1("Bass@word");
			u.setPwd2("Bass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene B",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneC() {
			u.setUsername("gabry91");
			u.setPwd1("Cass@word");
			u.setPwd2("Cass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene C",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneD() {
			u.setUsername("gabry91");
			u.setPwd1("Dass@word");
			u.setPwd2("Dass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene D",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneE() {
			u.setUsername("gabry91");
			u.setPwd1("Eass@word");
			u.setPwd2("Eass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene  E",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneF() {
			u.setUsername("gabry91");
			u.setPwd1("Fass@word");
			u.setPwd2("Fass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene F",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneg() {
			u.setUsername("gabry91");
			u.setPwd1("Gass@word");
			u.setPwd2("Gass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene G",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneH() {
			u.setUsername("gabry91");
			u.setPwd1("Hass@word");
			u.setPwd2("Hass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene H",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneI() {
			u.setUsername("gabry91");
			u.setPwd1("Iass@word");
			u.setPwd2("ass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene I",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneJ() {
			u.setUsername("gabry91");
			u.setPwd1("Jass@word");
			u.setPwd2("Jass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene J",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneK() {
			u.setUsername("gabry91");
			u.setPwd1("Kass@word");
			u.setPwd2("Kass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene K",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneL() {
			u.setUsername("gabry91");
			u.setPwd1("Lass@word");
			u.setPwd2("Lass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene L",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneM() {
			u.setUsername("gabry91");
			u.setPwd1("Mass@word");
			u.setPwd2("Mass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene M",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneN() {
			u.setUsername("gabry91");
			u.setPwd1("Nass@word");
			u.setPwd2("Nass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene N",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneO() {
			u.setUsername("gabry91");
			u.setPwd1("Oass@word");
			u.setPwd2("Oass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene O",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneP() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene P",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneQ() {
			u.setUsername("gabry91");
			u.setPwd1("Qass@word");
			u.setPwd2("Qass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene Q",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneR() {
			u.setUsername("gabry91");
			u.setPwd1("Rass@word");
			u.setPwd2("Rass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene R",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneS() {
			u.setUsername("gabry91");
			u.setPwd1("Sass@word");
			u.setPwd2("Sass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene S",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneT() {
			u.setUsername("gabry91");
			u.setPwd1("Tass@word");
			u.setPwd2("Tass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene T",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneU() {
			u.setUsername("gabry91");
			u.setPwd1("Uass@word");
			u.setPwd2("Uass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene U",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneV() {
			u.setUsername("gabry91");
			u.setPwd1("Vass@word");
			u.setPwd2("Vass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene V",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneW() {
			u.setUsername("gabry91");
			u.setPwd1("Wass@word");
			u.setPwd2("Wass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene W",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneX() {
			u.setUsername("gabry91");
			u.setPwd1("Xass@word");
			u.setPwd2("Xass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene X",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneY() {
			u.setUsername("gabry91");
			u.setPwd1("Yass@word");
			u.setPwd2("Yass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene Y",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPasswordContieneZ() {
			u.setUsername("gabry91");
			u.setPwd1("Zass@word");
			u.setPwd2("Zass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("password contiene Z",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testEmailNonContieneChiocciola() {			
			p2.setEmail("gg1991hotmail.it");
			u.setAnagrafica(p2);
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("e-mail non contiene @",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testEmailNonContienePunto() {			
			p2.setEmail("gg1991@hotmailit");
			u.setAnagrafica(p2);
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("e-mail non contiene .",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testEmailContieneSpazioVuoto() {			
			p2.setEmail("gg1991@ hotmail.it");
			u.setAnagrafica(p2);
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("e-mail contiene spazio vuoto",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testDomandaVuota() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("");
			u.setRisposta("lola");
			
			Integer exp=-1;
			assertEquals("domanda vuota",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testRispostaVuota() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("");
			
			Integer exp=-1;
			assertEquals("risposta vuota",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameNonUnivoco() {
			u.setUsername("gabry91");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=0;
			assertEquals("username non univoco",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testUsernameUnivoco() {
			u.setUsername("gabry92");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=2;
			assertEquals("username univoco",exp,s.registrazioneAccount(u));
		}
		
		@SuppressWarnings("static-access")
		@Test
		public void testPwd1DiversoPwd2() {
			u.setUsername("gabry92");
			u.setPwd1("Pass@word");
			u.setPwd2("Pass@word2");
			u.setDomanda("nome animale domestico");
			u.setRisposta("lola");
			
			Integer exp=1;
			assertEquals("",exp,s.registrazioneAccount(u));
		}		
	}