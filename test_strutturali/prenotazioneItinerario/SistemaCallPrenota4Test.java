package prenotazioneItinerario;

import static org.junit.Assert.*;
import org.junit.Test;

public class SistemaCallPrenota4Test {
	Sistema s=new Sistema();
	CartaDiCredito c=new CartaDiCredito();
	Paypal p=new Paypal();
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatException() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/17");
		c.setStrcodice("ccc");
		s.setCarta(true);
		
		Integer exp=0;
		assertEquals("NumberFormatException",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNomeVuoto() {
		c.setNomeIntestatario("");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("nome vuoto",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCognomeVuoto() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("cognome vuoto",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumeroVuoto() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("");
		c.setScadenza("09/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("numero vuoto",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testScadenzaVuota() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("scadenza vuota",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCodiceVuoto() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/19");
		c.setStrcodice("");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("codice vuoto",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreLunghezzaScadenza() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("009/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("errore lunghezza scadenza",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreFormatoScadenza() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09.19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("errore formato scadenza",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreNumeroCorto() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("1234567890123");
		c.setScadenza("09/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("errore numero corto",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreNumeroLungo() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234567");
		c.setScadenza("09/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("errore numero lungo",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreLunghezzaCodiceSicurezza() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/19");
		c.setStrcodice("9876");
		s.setCarta(true);
		
		Integer exp=-1;
		assertEquals("errore lunghezza codice sicurezza",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseScadenzaMinore1() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("00/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=2;
		assertEquals("mese scadenza < 1",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseScadenzaMaggiore12() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("13/19");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=2;
		assertEquals("mese scadenza > 12",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoScadenzaMinore2017() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("09/16");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=2;
		assertEquals("anno scadenza < 2017",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoScadenzaUguale2017MeseMinore7() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("06/17");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=2;
		assertEquals("anno scadenza = 2017 e mese scadenza < 7",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDatiCartaOk1() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("07/17");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=3;
		assertEquals("dati carta di credito ok con scadenza 2017",exp,s.callPrenota4(c));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDatiCartaOk2() {
		c.setNomeIntestatario("Gabriele");
		c.setCognomeIntestatario("Grieco");
		c.setStrnumero("12345678901234");
		c.setScadenza("06/18");
		c.setStrcodice("987");
		s.setCarta(true);
		
		Integer exp=3;
		assertEquals("dati carta di credito ok con scadenza 2018",exp,s.callPrenota4(c));
	}	
	
	@SuppressWarnings("static-access")
	@Test
	public void testEmailVuota() {
		p.setEmail("");
		p.setPasswordConto("password");
		s.setCarta(false);
		
		Integer exp=1;
		assertEquals("email vuota",exp,s.callPrenota4(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPasswordVuota() {
		p.setEmail("gg1991@hotmail.it");
		p.setPasswordConto("");
		s.setCarta(false);
		
		Integer exp=1;
		assertEquals("password vuota",exp,s.callPrenota4(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEmailNonContieneChiocciola() {
		p.setEmail("gg1991hotmail.it");
		p.setPasswordConto("password");
		s.setCarta(false);
		
		Integer exp=1;
		assertEquals("email senza @",exp,s.callPrenota4(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEmailNonContienePunto() {
		p.setEmail("gg1991@hotmailit");
		p.setPasswordConto("password");
		s.setCarta(false);
		
		Integer exp=1;
		assertEquals("email senza punto",exp,s.callPrenota4(p));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDatiPayPalOk() {
		p.setEmail("gg1991@hotmail.it");
		p.setPasswordConto("password");
		s.setCarta(false);
		
		Integer exp=3;
		assertEquals("dati PayPal ok",exp,s.callPrenota4(p));
	}
}
