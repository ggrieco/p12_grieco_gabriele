Gestione Voli Compagnia Aerea

Nella directory doc :
sono contenute le directory srs e sdd contenenti i rispettivi documenti;
è contenuto il file note.odt dove sono raccolti i dati riguardanti implementazione e testing
tutti il resto della documentazione derivante dall'implementazione

Nella directory src:
sono contenute tutti i file necessari alla compilazione ed esecuzione del programma implementato

Nelle directory test_strutturali e test_funzionali:
sono contenuti tutti i file riguardanti i test; in particolare la test suite per il test strutturali è il file SistemaAlltests.java, mentre la test suite per i test funzionali è il file UseCasesAllTests.java

Compilazione:
-creare un nuovo java project in eclipse
-nella cartella src del nuovo progetto creare un nuovo package chiamato "prenotazioneItinerario"
-copiare tutti i file contenuti nella directory src/prenotazioneItinerario nel nuovo package creato

-nella cartella contenente l'intero progetto creare una nuova source folder chiamata test_strutturali
-nella nuova source folder creare un nuovo package chiamato "prenotazioneItinerario"
-copiare tutti i file contenuti nella directory test_strutturali/prenotazioneItinerario nel nuovo package creato
-se i file presentano errori importare la libreria JUnit4 (io la ho importata con tasto destro sulla cartella del progetto->Build Path       ->AddLibraries->JUnit->JUnit4

-per i test funzionali la procedura è analoga a quella descritta per i test strutturali, prendendo i file dalla directory                   test_funzionali/prenotazioneItinerario
