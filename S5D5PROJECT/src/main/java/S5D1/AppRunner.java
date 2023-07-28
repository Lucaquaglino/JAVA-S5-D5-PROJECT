package S5D1;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import S5D1.configuration.Config;
import S5D1.entities.Utente;
import S5D1.services.EdificioService;
import S5D1.services.PostazioneService;
import S5D1.services.PrenotazioneService;
import S5D1.services.UtenteService;
import S5D1.utils.TipoPostazione;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AppRunner implements CommandLineRunner {

	@Autowired
	private Config appConfig;

	@Autowired
	private EdificioService edificioService;

	@Autowired
	private PostazioneService postazioneService;

	@Autowired
	private PrenotazioneService prenotazioneService;

	@Autowired
	private UtenteService utenteService;

	@Override
	public void run(String... args) throws Exception {
		log.info("--------------------");
		utenteService.salvaUtente(appConfig.utente1());
		utenteService.salvaUtente(appConfig.utente2());
		edificioService.salvaEdificio(appConfig.edificio1());
//		edificioService.eliminaEdificio(appConfig.edificio2());
		postazioneService.salvaPostazione(appConfig.postazione2());
//	
//		prenotazioneService.salvarePrenotazioneSeNonEsiste(appConfig.prenotazione1());
//		prenotazioneService.getPrenotazioniByUtente(appConfig.utente1());
//		postazioneService.getPostazioneByTipo(TipoPostazione.OPEN_SPACE);
//		postazioneService.getPostazioneByCitta("Quarto Morgana");
		Scanner scanner = new Scanner(System.in);

		// Chiedi all'utente di inserire l'username
		System.out.println("Inserisci il tuo username:");
		String username = scanner.nextLine();

		// Trova l'utente nel sistema in base all'username
		Utente utente = utenteService.trovaUtenteByUsername(username);

		if (utente != null) {
			System.out.println("Benvenuto, " + utente.getNomeCognome() + "!");

			// MENU
			boolean continua = true;
			while (continua) {
				System.out.println("\nMenu:");
				System.out.println("1. Visualizza le tue prenotazioni");
				System.out.println("2. Crea una nuova prenotazione");
				System.out.println("3. Cerca postazioni per città");
				System.out.println("4. Cerca postazioni per tipo");
				System.out.println("0. Esci");

				int scelta = scanner.nextInt();
				scanner.nextLine();

				switch (scelta) {
				case 1:
					// PRENOTAZIONI UTENTE
					prenotazioneService.getPrenotazioniByUtente(appConfig.utente1());
					break;
				case 2:

					// CREO NUOVA PRENOTAZIONE
					prenotazioneService.salvarePrenotazioneSeNonEsiste(appConfig.prenotazione1());
					break;
				case 3:
					// CERCO POSTAZIONI PER CITTA
					System.out.println("Inserisci il nome della città:");
					String citta = scanner.nextLine();

					// Trova le postazioni per la città specificata
					postazioneService.getPostazioneByCitta(citta);
					break;
				case 4:
					// CERCO POSTAZIONI PER TIPO
					System.out.println("Seleziona il tipo di postazione:");
					System.out.println("1. OPEN_SPACE");
					System.out.println("2. PRIVATO");
					System.out.println("3. SALA_RIUNIONI");
					int tipoScelto = scanner.nextInt();
					scanner.nextLine();
					// SWITCH PER SCEGLIERE QUALE TIPO
					TipoPostazione tipoPostazione;
					switch (tipoScelto) {
					case 1:
						tipoPostazione = TipoPostazione.OPEN_SPACE;
						break;
					case 2:
						tipoPostazione = TipoPostazione.PRIVATO;
						break;
					case 3:
						tipoPostazione = TipoPostazione.SALA_RIUNIONE;
						break;
					default:
						System.out.println("Scelta non valida. Riprova.");
						continue;
					}

					// POSTAZIONI PER TIPO
					postazioneService.getPostazioneByTipo(tipoPostazione);
					break;
				case 0:
					// USCITA MENU
					continua = false;
					break;
				default:
					System.out.println("Scelta non valida. Riprova.");
					break;
				}
			}
		} else

		{
			System.out.println("Utente non trovato. Controlla l'username inserito.");
		}

		scanner.close();
	}

}
