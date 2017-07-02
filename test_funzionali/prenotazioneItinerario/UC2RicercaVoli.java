package prenotazioneItinerario;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * I seguenti test case si riferiscono al caso d'uso UC2 presente nel file di
 * documentazione "srs_p12_grieco_gabriele.odt".
 */
public class UC2RicercaVoli {
	Sistema s=new Sistema();
	RicercaVoli r=new RicercaVoli();
	
	/*
	 * Il test seguente si riferisce allo scenario principale che considera il
	 * caso nel quale la procedura di ricerca di itinerari disponibili avvenga
	 * con successo
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioPrincipale() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=3;
		assertEquals("dati ricerca ok itinerari andata e ritorno",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 3a che considera il
	 * caso nel quale sia stata selezionata l'opzione di ricerca di itinerari
	 * di sola andata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo3a() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setSoloAndata(true);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=3;
		assertEquals("dati ricerca ok itinerari sola andata",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11a che considera il
	 * caso nel quale la località di partenza sia stata inserita in modo errato
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11a() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("RMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=0;
		assertEquals("errore località partenza",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11a.3a che considera il
	 * caso nel quale la località di partenza sia stata inserita correttamente ma
	 * non è inclusa tra le località raggiunte dai voli gestiti dal sistema
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11a3a() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("TORINO");
		r.setAeroportoDestinazione("GENOVA");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=0;
		assertEquals("località partenza non presente nel sistema",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11b che considera il
	 * caso nel quale la località di destinazione sia stata inserita in modo errato
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11b() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GNOVA");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=1;
		assertEquals("errore località destinazione",exp,s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 11b.3a che considera il
	 * caso nel quale la località di destinazione sia stata inserita correttamente ma
	 * non è inclusa tra le località raggiunte dai voli gestiti dal sistema
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11b3a() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("TORINO");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("19");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=1;
		assertEquals("località destinazione non presente nel sistema",exp,
					 s.ricercaItinerario(r));		
	}
	
	/*
	 * Il test seguente considera lo scenario alternativo 11c che riguarda il
	 * caso nel quale la data di ritorno inserita sia precedenta a quella del
	 * viaggio di andata
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo11c() {
		r.inizializzaDataPartenza();
		r.inizializzaDataRitorno();
		r.setAeroportoPartenza("ROMA");
		r.setAeroportoDestinazione("GENOVA");
		r.setSoloAndata(false);
		r.setStrggA("17");
		r.setStrmmA("07");
		r.setStraaaaA("2017");
		r.setStrggR("15");
		r.setStrmmR("07");
		r.setStraaaaR("2017");
		r.setStradulti("1");
		r.setStrbambini("0");
		r.setClasseDiViaggio("Economy");
		
		Integer exp=-1;
		assertEquals("data ritorno antecedente alla data di andata",exp,
					 s.ricercaItinerario(r));		
	}
}
