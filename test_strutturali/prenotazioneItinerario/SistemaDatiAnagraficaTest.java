package prenotazioneItinerario;

import static org.junit.Assert.*;
import org.junit.Test;

public class SistemaDatiAnagraficaTest {
	Sistema s=new Sistema();
	Persona p=new Persona();
	String d;
	
	@SuppressWarnings("static-access")
	@Test
	public void testNomeVuoto() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("nome vuoto",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCognomeVuoto() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("cognome vuoto",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSessoVuoto() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("sesso",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNazionalitaVuota() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("nazionalità vuoto",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEtaMinore18() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("17");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("età < 18 anni",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testEtaMaggiore100() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1917");
		p.setStreta("101");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("età > 100",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testDomicilioVuoto() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="";
		
		Integer exp=-1;
		assertEquals("domicilio vuoto",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoMinore1() {
		p.inizializzaDataNascita();
		p.setStrgg("-1");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("giorno < 1",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoMaggiore31() {
		p.inizializzaDataNascita();
		p.setStrgg("32");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("giorno > 31",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseMinore1() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("-1");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese < 1",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseMaggiore12() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("13");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese > 12",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoMinore1917() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1916");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("anno < 1917",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoMaggiore1999() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("2000");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("anno > 1999",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMese4Giorno31() {
		p.inizializzaDataNascita();
		p.setStrgg("31");
		p.setStrmm("04");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese aprile giorno 31",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMese6Giorno31() {
		p.inizializzaDataNascita();
		p.setStrgg("31");
		p.setStrmm("06");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese giugno giorno 31",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMese9Giorno31() {
		p.inizializzaDataNascita();
		p.setStrgg("31");
		p.setStrmm("09");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese settembre giorno 31",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMese11Giorno31() {
		p.inizializzaDataNascita();
		p.setStrgg("31");
		p.setStrmm("11");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("mese novembre giorno 31",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMese11Giorno30() {
		p.inizializzaDataNascita();
		p.setStrgg("30");
		p.setStrmm("11");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=1;
		assertEquals("mese novembre giorno 30",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatException() {
		p.inizializzaDataNascita();
		p.setStrgg("");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=0;
		assertEquals("NumberFormatException",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testOK() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("05");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=1;
		assertEquals("tutto corretto",exp,s.datiAnagrafica(p, d));
	}	
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoMaggiore28Mese2AnnoNonBisestile() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("02");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("giorno > 28 mese febbraio anno non bisestile",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoUguale28Mese2AnnoNonBisestile() {
		p.inizializzaDataNascita();
		p.setStrgg("28");
		p.setStrmm("02");
		p.setStraaaa("1991");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=1;
		assertEquals("giorno = 28 mese febbraio anno non bisestile",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoMaggiore29Mese2AnnoBiosestile() {
		p.inizializzaDataNascita();
		p.setStrgg("30");
		p.setStrmm("02");
		p.setStraaaa("1992");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=-1;
		assertEquals("giorno > 29 mese febbraio anno bisestile",exp,s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoUguale29Mese2AnnoBisestile() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("02");
		p.setStraaaa("1992");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=1;
		assertEquals("giorno = 29 mese febbraio anno bisestile",exp,
				 	 s.datiAnagrafica(p, d));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiorno29Mese3AnnoBisestile() {
		p.inizializzaDataNascita();
		p.setStrgg("29");
		p.setStrmm("03");
		p.setStraaaa("1992");
		p.setStreta("26");
		p.setNome("Gabriele");
		p.setCognome("Grieco");
		p.setSesso("M");
		p.setNazionalita("Italiana");
		p.setEmail("gg1991@hotmail.it");
		d="corso Sardegna 10, 16100 GENOVA, ITALIA";
		
		Integer exp=1;
		assertEquals("giorno = 29 mese marzo anno bisestile",exp,
					 s.datiAnagrafica(p, d));
	}
}
