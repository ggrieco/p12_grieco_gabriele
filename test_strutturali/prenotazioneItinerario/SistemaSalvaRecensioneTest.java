package prenotazioneItinerario;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;

public class SistemaSalvaRecensioneTest {
	Sistema s=new Sistema();
	Recensione r=new Recensione();	
	
	@SuppressWarnings("static-access")
	@Test
	public void testIOException() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setValutazione(3);
		s.setInd3("asd/jhl");
		
		assertFalse("IOException",s.salvaRecensione(r));
	}
	
	@SuppressWarnings("static-access")
	@After
	public void tearDown() {
		s.setInd3("src/prenotazioneItinerario/Recensioni.txt");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testSalvaRecensione() {
		r.setTitolo("Titolo");
		r.setAmbito("Ambito");
		r.setTesto("testo");
		r.setValutazione(3);
		
		assertTrue("salva recensione",s.salvaRecensione(r));
	}
}
