package prenotazioneItinerario;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SetGetTest {
	Sistema s=new Sistema();
	CartaDiCredito c=new CartaDiCredito();
	UtenteRegistrato u= new UtenteRegistrato();
	Prenotazione p=new Prenotazione();
	Persona pers=new Persona();
	
	@SuppressWarnings("static-access")
	@Test
	public void testUtente() {
		s.getUtente().setUsername("abcde12");
		
		String exp="abcde12";
		assertEquals("utente",exp,s.getUtente().getUsername());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testUser() {
		s.setUser("abcde12");
		
		String exp="abcde12";
		assertEquals("User",exp,s.getUser());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd1() {
		s.setInd1("abcde");
		
		String exp="abcde";
		assertEquals("ind1",exp,s.getInd1());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd2() {
		s.setInd2("abcde");
		
		String exp="abcde";
		assertEquals("ind2",exp,s.getInd2());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd3() {
		s.setInd3("abcde");
		
		String exp="abcde";
		assertEquals("ind3",exp,s.getInd3());
	}

	@SuppressWarnings("static-access")
	@Test
	public void testInd4() {
		s.setInd4("abcde");
		
		String exp="abcde";
		assertEquals("ind4",exp,s.getInd4());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd5() {
		s.setInd5("abcde");
		
		String exp="abcde";
		assertEquals("ind5",exp,s.getInd5());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd6() {
		s.setInd6("abcde");
		
		String exp="abcde";
		assertEquals("ind6",exp,s.getInd6());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testInd7() {
		s.setInd7("abcde");
		
		String exp="abcde";
		assertEquals("ind7",exp,s.getInd7());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdulti() {
		Integer exp=1;		
		assertEquals("adulti",exp,s.getAdulti());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBambini() {
		Integer exp=0;		
		assertEquals("bambini",exp,s.getBambini());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRighe() {
		s.setRighe(0);
		
		Integer exp=0;		
		assertEquals("righe",exp,s.getRighe());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrezzo() {
		s.setPrezzo(0.0);
		
		Double exp=0.0;		
		assertEquals("prezzo",exp,s.getPrezzo());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCarta() {
		s.setCarta(false);
				
		assertFalse("carta",s.getCarta());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAssicurazione() {
		s.setAssicurazione("abcde");
		
		String exp="abcde";		
		assertEquals("Assicurazione",exp,s.getAssicurazione());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testClasse() {
		s.setClasse("abcde");
		
		String exp="abcde";		
		assertEquals("classe",exp,s.getClasse());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAddPrezzo() {
		s.setPrezzo(1.0);
		s.addPrezzo(1.1);
		
		Double exp=2.1;		
		assertEquals("add prezzo",exp,s.getPrezzo());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testItinerariPrezzo() {		
		ArrayList<ArrayList<Volo>> i = new ArrayList<ArrayList<Volo>>();
		ArrayList<Volo>  n=new ArrayList<Volo>();
		Volo v=new Volo();
	
		v.setAeroportoPartenza("GENOVA");
		v.setAeroportoDestinazione("PARIGI");
		
		n.add(v);
		i.add(n);
		s.setItinerari(i);
		
		String exp="PARIGI";		
		assertEquals("itinerari",exp,s.getItinerari().get(0).get(0).getAeroportoDestinazione());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPrenotazione() {		
		s.getPrenotazione().setRichieste("abcde");
		
		String exp="abcde";		
		assertEquals("itinerari",exp,s.getPrenotazione().getRichieste());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testLogged() {		
		s.setLogged(true);
				
		assertTrue("logged true",s.getLogged());
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCriteri() {		
		s.getCriteri().setAeroportoPartenza("OSLO");
		
		String exp="OSLO";		
		assertEquals("criteri",exp,s.getCriteri().getAeroportoPartenza());
	}
	
	@Test
	public void testNumeroCarta() {		
		c.setNumeroCarta(1234);
		
		Integer exp=1234;		
		assertEquals("numero carta",exp,c.getNumeroCarta());
	}
	
	@Test
	public void testMeseScadenza() {		
		c.setMeseScadenza(12);
		
		Integer exp=12;		
		assertEquals("mese scadenza",exp,c.getMeseScadenza());
	}
	
	@Test
	public void testAnnoScadenza() {		
		c.setAnnoScadenza(2017);
		
		Integer exp=2017;		
		assertEquals("anno scadenza",exp,c.getAnnoScadenza());
	}
	
	@Test
	public void testCodiceSicurezza() {		
		c.setCodiceSicurezza(123);
		
		Integer exp=123;		
		assertEquals("codice sicurezza",exp,c.getCodiceSicurezza());
	}
	
	@Test
	public void testFrequentFlyer() {		
		u.setCodiceFrequentFlyer("AA12345");
		
		String exp="AA12345";		
		assertEquals("frequent flyer",exp,u.getCodiceFrequentFlyer());
	}
	
	@Test
	public void testCodiceIdentificativo() {		
		p.setCodiceIdentificativo("AA12345");
		
		String exp="AA12345";		
		assertEquals("codice identificativo",exp,p.getCodiceIdentificativo());
	}
	
	@Test
	public void testPasseggeri() {
		pers.setCognome("Grieco");
		p.setPasseggeri(pers);
		
		String exp="Grieco";		
		assertEquals("passeggeri",exp,p.getPasseggeri().get(0).getCognome());
	}
	
	@Test
	public void testTicketNumber() {
		p.setTicketNumber("AA12345");
		
		String exp="AA12345";		
		assertEquals("ticket number",exp,p.getTicketNumber().get(0));
	}
}
