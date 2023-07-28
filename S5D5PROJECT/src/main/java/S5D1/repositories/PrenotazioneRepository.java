package S5D1.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import S5D1.entities.Prenotazione;
import S5D1.entities.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
	List<Prenotazione> findByUtente(Utente utente);

	boolean existsByUtenteAndDataPrenotazione(Utente utente, LocalDate dataPrenotazione);
}
