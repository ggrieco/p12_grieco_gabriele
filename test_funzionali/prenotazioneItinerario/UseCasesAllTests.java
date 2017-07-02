package prenotazioneItinerario;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * TestSuite contenente tutti i test funzionali
 */
@RunWith(Suite.class)
@SuiteClasses({ UC10AutenticarsiTest.class, UC11PrenotareUnViaggioTest.class, UC12ScrivereUnaRecensione.class,
		UC1RegistrazioneNuovoAccount.class, UC2RicercaVoli.class })
public class UseCasesAllTests {
}
