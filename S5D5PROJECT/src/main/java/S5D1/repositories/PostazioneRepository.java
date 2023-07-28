package S5D1.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import S5D1.entities.Postazione;
import S5D1.utils.TipoPostazione;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {
	List<Postazione> findByEdificioCitta(String citta);

	List<Postazione> findByTipo(TipoPostazione tipo);
}
