package S5D1.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S5D1.entities.Utente;
import S5D1.repositories.UtenteRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UtenteService {
	@Autowired
	private UtenteRepository utenteRepo;

	public void salvaUtente(Utente u) {
		utenteRepo.save(u);
		log.info("UTENTE: " + u + "Salvato nel Database!");
		log.info("--------------------");
	}

	public Utente trovaUtenteByUsername(String username) {
		Optional<Utente> utenteOptional = utenteRepo.findById(username);
		return utenteOptional
				.orElseThrow(() -> new NoSuchElementException("Utente non trovato con l'username: " + username));
	}

}
