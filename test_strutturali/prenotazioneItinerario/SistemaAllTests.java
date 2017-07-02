package prenotazioneItinerario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * TestSuite contenente tutti i test strutturali
 */
@RunWith(Suite.class)
@SuiteClasses({ SistemaAssegnaCodicePrenotazioneTest.class, SistemaAssegnaFFTest.class,
		SistemaAssegnaTicketNumber.class, SistemaAutenticazioneTest.class, SistemaCallPrenota1Test.class,
		SistemaCallPrenota2Test.class, SistemaCallPrenota3Test.class, SistemaCallPrenota4Test.class, SistemaDatiAnagraficaTest.class,
		SistemaDettagliVoliTest.class, SistemaEmailUnivocaTest.class, SistemaLoginTest.class,
		SistemaRegistrazioneAccountTest.class, SistemaRicercaItinerarioTest.class, SistemaSalvaPrenotazioneTest.class,
		SistemaSalvaRecensioneTest.class, SistemaScriviRecensioneTest.class, SistemaUsernameUnivocoTest.class,
		SetGetTest.class})
public class SistemaAllTests {

}
