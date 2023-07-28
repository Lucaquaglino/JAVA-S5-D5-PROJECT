package S5D1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S5D1.entities.Prenotazione;
import S5D1.entities.Utente;
import S5D1.repositories.PrenotazioneRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PrenotazioneService {

	@Autowired
	private PrenotazioneRepository prenotazioneRepo;

	public void salvarePrenotazioneSeNonEsiste(Prenotazione prenotazione) {
		Utente utente = prenotazione.getUtente();
		if (!prenotazioneRepo.existsByUtenteAndDataPrenotazione(utente, prenotazione.getDataPrenotazione())) {
			prenotazioneRepo.save(prenotazione);
			log.info("Prenotazione salvata: {}", prenotazione);
			log.info("--------------------");
		} else {
			log.warn("Prenotazione già esistente per l'utente {} alla data {}", utente.getUserName(),
					prenotazione.getDataPrenotazione());
			log.info("--------------------");

		}
	}

	public void getPrenotazioniByUtente(Utente utente) {
		List<Prenotazione> prenotazioni = prenotazioneRepo.findByUtente(utente);

		if (prenotazioni.isEmpty()) {
			log.info("Nessuna prenotazione trovata per l'utente: {}", utente.getUserName());
		} else {
			log.info("Prenotazioni per l'utente: {}", utente.getUserName());
			for (Prenotazione prenotazione : prenotazioni) {
				log.info("ID: {}", prenotazione.getId());
				log.info("Data prenotazione: {}", prenotazione.getDataPrenotazione());
				log.info("Postazione: {}", prenotazione.getPostazione());

				log.info("--------------------");
			}
		}
	}

}
