package S5D1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import S5D1.entities.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, String> {

}
