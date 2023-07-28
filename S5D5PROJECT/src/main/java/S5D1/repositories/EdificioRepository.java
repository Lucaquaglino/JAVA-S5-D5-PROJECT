package S5D1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import S5D1.entities.Edificio;

@Repository
public interface EdificioRepository extends JpaRepository<Edificio, String> {

}
