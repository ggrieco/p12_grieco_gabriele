package prenotazioneItinerario;

import static org.junit.Assert.*;

import org.junit.Test;
/*
 * I seguenti test case si riferiscono al caso d'uso UC12 presente nel file di
 * documentazione "srs_p12_grieco_gabriele.odt".
 */
public class UC12ScrivereUnaRecensione {
	Sistema s=new Sistema();
	Recensione r=new Recensione();
	
	/*
	 * Il seguente test riguarda lo scenario principale che considera il caso
	 * nel quale la procedura di inserimento di una nuova recensione avviene
	 * con successo
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioPrincipale() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("Testo");
		r.setStrvalutazione("1");
		
		Integer exp=1;
		assertEquals("recensione scritta correttamente",exp,s.scriviRecensione(r));
		
		assertTrue("recensione salvata correttamente",s.salvaRecensione(r));
	}
	
	/*
	 * Il test seguente riguarda lo scenario alternativo 9a che considera il caso
	 * nel quale sono presenti errori di compilazione nei dati relativi alla nuova
	 * recensione da inserire
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testScenarioAlternativo9a() {
		r.setTitolo("");
		r.setAmbito("Ambito");
		r.setTesto("Testo");
		r.setStrvalutazione("1");
		
		Integer exp=-2;
		assertEquals("errore dati recensione",exp,s.scriviRecensione(r));
	}
}
