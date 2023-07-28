package S5D1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S5D1.entities.Postazione;
import S5D1.repositories.PostazioneRepository;
import S5D1.utils.TipoPostazione;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostazioneService {
	@Autowired
	private PostazioneRepository postazioneRepo;

	public void salvaPostazione(Postazione p) {
		postazioneRepo.save(p);
		log.info("POSTAZIONE: " + p + "salvata nel Database!");
		log.info("--------------------");
	}

	public List<Postazione> getPostazioneByCitta(String citta) {
		List<Postazione> postazioni = postazioneRepo.findByEdificioCitta(citta);

		if (postazioni.isEmpty()) {
			log.info("Nessuna postazione trovata per la città: {}", citta);
		} else {
			log.info("Postazioni trovate per la città {}: ", citta);
			for (Postazione postazione : postazioni) {
				log.info("ID: {}, Descrizione: {}, Tipo: {}, Occupati Max: {}, Edificio: {}", postazione.getId(),
						postazione.getDescrizione(), postazione.getTipo(), postazione.getOccupatiMax(),
						postazione.getEdificio().getCitta());
			}
		}

		return postazioni;
	}

	public List<Postazione> getPostazioneByTipo(TipoPostazione tipo) {
		List<Postazione> postazioni = postazioneRepo.findByTipo(tipo);

		if (postazioni.isEmpty()) {
			log.info("Nessuna postazione trovata per il tipo: {}", tipo);
		} else {
			log.info("Postazioni trovate per il tipo {}: ", tipo);
			for (Postazione postazione : postazioni) {
				log.info("ID: {}, Descrizione: {}, Tipo: {}, Occupati Max: {}, Edificio: {}", postazione.getId(),
						postazione.getDescrizione(), postazione.getTipo(), postazione.getOccupatiMax(),
						postazione.getEdificio().getCitta());
			}
		}

		return postazioni;
	}
}