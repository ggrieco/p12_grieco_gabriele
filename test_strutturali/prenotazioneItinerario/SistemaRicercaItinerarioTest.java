package prenotazioneItinerario;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SistemaRicercaItinerarioTest {
	Sistema s=new Sistema();
	RicercaVoli r=new RicercaVoli();	
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatExceptionSoloAndata() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=2;
		assertEquals("NumberFormatException solo andata",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testNumberFormatExceptionAndataRitorno() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=2;
		assertEquals("NumberFormatException andata e ritorno",exp,
					 s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOException() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");		
		r.setSoloAndata(true);
		s.setInd6("asd/qwe");
		
		Integer exp=4;
		assertEquals("IOException file Connessioni.txt",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd6("src/prenotazioneItinerario/Connessioni.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAeroportoPartenzaVuoto() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("Aeroporto partenza vuoto",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAeroportoDestinazioneVuoto() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("aeroporto destinazione vuoto",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPartenzaDestinazioneUguali() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("ROMA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("partenza e destinazione uguali",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAdultiMinore0() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("-1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("adulti < 0",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testBambiniMinore0() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("0");
		r.setStrbambini("-1");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("bambini < 0",exp,s.ricercaItinerario(r));		
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testZeroPasseggeriInseriti() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("0");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("totale passeggeri = 0",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoPartenzaMinore1() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("0");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("giorno partenza < 1",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoPartenzaMaggiore31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("32");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("giorno partenza > 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoRitornoMinore1() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("0");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("giorno ritorno < 1",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testGiornoRitornoMaggiore31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("32");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("giorno ritorno > 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitornoMinore1() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("18");
		r.setStrmmR("0");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno < 1",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitornoMaggiore12() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("18");
		r.setStrmmR("13");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno > 12",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoRitornoMinore2017() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("18");
		r.setStrmmR("07");
		r.setStraaaaR("2016");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("anno ritorno < 2017",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoRitornoMaggiore2020() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("18");
		r.setStrmmR("07");
		r.setStraaaaR("2021");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("anno ritorno > 2020",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndataMinore1() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("0");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata < 1",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndataMaggiore12() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("13");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata > 12",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoAndataMinore2017() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2016");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("anno andata < 2017",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoAndataMaggiore2020() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2021");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("anno andata > 2020",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata4Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("31");
		r.setStrmmA("04");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata aprile giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata6Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("31");
		r.setStrmmA("06");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata giugno giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata9Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("31");
		r.setStrmmA("09");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata settembre giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata11Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("31");
		r.setStrmmA("11");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(true);
		
		Integer exp=-1;
		assertEquals("mese andata novembre giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno4Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("04");
		r.setStraaaaA("2017");		
		r.setStrggR("31");
		r.setStrmmR("04");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno aprile giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno6Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("06");
		r.setStraaaaA("2017");		
		r.setStrggR("31");
		r.setStrmmR("06");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno giugno giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno9Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("09");
		r.setStraaaaA("2017");		
		r.setStrggR("31");
		r.setStrmmR("09");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno settembre giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno11Giorno31() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("11");
		r.setStraaaaA("2017");		
		r.setStrggR("31");
		r.setStrmmR("11");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno novembre giorno 31",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno2Giorno29AnnoNonBisestile() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("02");
		r.setStraaaaA("2017");		
		r.setStrggR("29");
		r.setStrmmR("02");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno febbraio giorno 29 anno non bisestile",exp,
					 s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseRitorno2Giorno30AnnoBisestile() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("02");
		r.setStraaaaA("2017");		
		r.setStrggR("30");
		r.setStrmmR("02");
		r.setStraaaaR("2020");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese ritorno febbraio giorno 30 anno bisestile",exp,
					 s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata2Giorno29AnnoNonBisestile() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("29");
		r.setStrmmA("02");
		r.setStraaaaA("2017");		
		r.setStrggR("03");
		r.setStrmmR("04");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese andata febbraio giorno 29 anno non bisestile",exp,
					 s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testMeseAndata2Giorno30AnnoBisestile() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("30");
		r.setStrmmA("02");
		r.setStraaaaA("2020");		
		r.setStrggR("05");
		r.setStrmmR("03");
		r.setStraaaaR("2020");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("mese andata febbraio giorno 30 anno bisestile",exp,
					 s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoRitornoMinoreAnnoAndata() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("20");
		r.setStrmmA("11");
		r.setStraaaaA("2020");		
		r.setStrggR("30");
		r.setStrmmR("11");
		r.setStraaaaR("2019");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("anno ritorno < anno andata",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoRitUgualeeAnnoAndMeseRitMinMeseAnd() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("10");
		r.setStrmmA("11");
		r.setStraaaaA("2017");		
		r.setStrggR("15");
		r.setStrmmR("10");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("anno ritorno = anno andata, mese ritorno < mese andata",
					 exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testAnnoRitUgualeAnnoAndMeseRitUgualeMeseAndGiornoRitMinGiornoAnd() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("10");
		r.setStrmmA("11");
		r.setStraaaaA("2017");		
		r.setStrggR("09");
		r.setStrmmR("11");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=-1;
		assertEquals("anno ritorno = anno andata, mese ritorno = mese andata, "
				   + "giorno ritorno < giorno andata",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFebraioOkNonBisestileAndata() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("28");
		r.setStrmmA("02");
		r.setStraaaaA("2017");		
		r.setStrggR("01");
		r.setStrmmR("03");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=3;
		assertEquals("dati ok febbraio non bisestile andata",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFebbraioOkBisestileAndata() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("29");
		r.setStrmmA("02");
		r.setStraaaaA("2020");		
		r.setStrggR("03");
		r.setStrmmR("03");
		r.setStraaaaR("2020");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=3;
		assertEquals("dati ok febbraio bisestile andata",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFebraioOkNonBisestileRitorno() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("20");
		r.setStrmmA("02");
		r.setStraaaaA("2017");		
		r.setStrggR("28");
		r.setStrmmR("02");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=3;
		assertEquals("dati ok febbraio non bisestile ritorno",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testFebbraioOkBisestileRitorno() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("20");
		r.setStrmmA("02");
		r.setStraaaaA("2020");		
		r.setStrggR("29");
		r.setStrmmR("02");
		r.setStraaaaR("2020");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setSoloAndata(false);
		
		Integer exp=3;
		assertEquals("dati ok febbraio bisestile ritorno",exp,s.ricercaItinerario(r));		
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testdatiOk() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setClasseDiViaggio("Economy");
		r.setStrggA("10");
		r.setStrmmA("12");
		r.setStraaaaA("2017");		
		r.setStrggR("15");
		r.setStrmmR("01");
		r.setStraaaaR("2018");
		r.setStradulti("1");
		r.setStrbambini("1");
		r.setSoloAndata(false);
		
		Integer exp=3;
		assertEquals("dati ok",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il file di testo Connessioni.txt è organizzato in righe contenenti le diverse
	 * località: la prima località rappresenta l'hub, dal quale partono i voli diretti per le
	 * località presenti sulla medesima riga. Esiste anche un volo diretto tra i vari hub,
	 * ossia tra tutte le prime località scritte sulle diverse righe.
	 * I test che seguono coprono i vari casi nei quali la funzione può trovare le località
	 * di partenza e destinazine sulle diverse righe del file
	 */
	
	@Before
	public void setUp() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
	}

	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga1Riga1() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=3;
		assertEquals("from=1 to=1",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga1Riga2() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("OSLO");
				
		Integer exp=3;
		assertEquals("from=1 to=2",exp,s.ricercaItinerario(r));
	}
		
	@SuppressWarnings("static-access")
	@Test
	public void testRiga1Riga3() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("from=1 to=3",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga2Riga1() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("LONDRA");
				
		Integer exp=3;
		assertEquals("from=2 to=1",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga2Riga2() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("STOCCOLMA");
		
		Integer exp=3;
		assertEquals("from=2 to=2",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRoga2Riga3() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("from=2 to=3",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga3Riga1() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("LONDRA");
				
		Integer exp=3;
		assertEquals("from=3 to=1",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga3Riga2() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("OSLO");
		
		Integer exp=3;
		assertEquals("from=3 to=2",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga3Riga3() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("JOHANNESBURG");
		
		Integer exp=3;
		assertEquals("from=3 to=3",exp,s.ricercaItinerario(r));
	}
	
	@Before
	public void setUp2() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setClasseDiViaggio("Economy");
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga1Riga1Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=3;
		assertEquals("from=1 to=1 con ritorno",exp,s.ricercaItinerario(r));
	}	
	
	@SuppressWarnings("static-access")
	@Test
	public void testriga1Riga2Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("OSLO");
		
		Integer exp=3;
		assertEquals("from=1 to=2 con ritorno",exp,s.ricercaItinerario(r));
	}	
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga1Riga3Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("LONDRA");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("from=1 to=3 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testriga2Riga1Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("LONDRA");
		
		Integer exp=3;
		assertEquals("from=2 to=1 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga2Riga2Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("STOCCOLMA");
		
		Integer exp=3;
		assertEquals("from=2 to=2 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga2Riga3Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("from=2 to=3 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testriga3Riga1Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("LONDRA");
		
		Integer exp=3;
		assertEquals("from=3 to=1 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga3Riga2Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("OSLO");
		
		Integer exp=3;
		assertEquals("from=3 to=2 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testRiga3Riga3Rit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("JOHANNESBURG");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("from=3 to=3 con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreDestinazione() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("TORINO");
		
		Integer exp=1;
		assertEquals("errore destinazione",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreOrigine() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("TORINO");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=0;
		assertEquals("errore origine",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreDestinazioneRit() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("GENOVA");
		r.setAeroportoDestinazione("TORINO");
		
		Integer exp=1;
		assertEquals("errore destinazione",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testErroreEntrambe() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("TORINO");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=0;
		assertEquals("errore origine e destinazione",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneMonaco() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Monaco",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneParigi() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Parigi",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneRoma() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("MILANO");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Roma",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2PartenzaMonaco() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("OSLO");
		
		Integer exp=3;
		assertEquals("caso 2  partenza Monaco",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneRoma() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Roma",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneMonaco() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Monaco",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneParigi() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Parigi",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3PartenzaParigi() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=3;
		assertEquals("caso 3 partenza Parigi",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneRoma() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Roma",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneMonaco() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Monaco",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneParigi() {
		r.setSoloAndata(true);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Parigi",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1PartenzaRomaRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("MILANO");
		
		Integer exp=3;
		assertEquals("caso 1 partenza Roma con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneRomaRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("MILANO");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Roma con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneMonacoRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Monaco con Rotorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso1DestinazioneParigiRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 1 destinazione Parigi con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2PartenzaMonacoRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("OSLO");
		
		Integer exp=3;
		assertEquals("caso 2 partenza Monaco con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneRomaRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Roma con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneMonacoRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("OSLO");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Monaco con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso2DestinazioneParigiRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("MONACO");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 2 destinazione Parigi con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3PartenzaParigiRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("NIZZA");
		
		Integer exp=3;
		assertEquals("caso 3 partenza Parigi con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneRomaRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("ROMA");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Roma con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneMonacoRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("PARIGI");
		r.setAeroportoDestinazione("MONACO");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Monaco con ritorno",exp,s.ricercaItinerario(r));
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testCaso3DestinazioneParigiRit() {
		r.setSoloAndata(false);
		r.setAeroportoPartenza("NIZZA");
		r.setAeroportoDestinazione("PARIGI");
		
		Integer exp=3;
		assertEquals("caso 3 destinazione Parigi con ritorno",exp,s.ricercaItinerario(r));
	}
}
