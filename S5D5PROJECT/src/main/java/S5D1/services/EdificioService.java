package S5D1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import S5D1.entities.Edificio;
import S5D1.repositories.EdificioRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EdificioService {
	@Autowired
	private EdificioRepository edificioRepo;

	public void salvaEdificio(Edificio e) {
		edificioRepo.save(e);
		log.info("EDIFICIO: " + e + "Salvato nel Database!");
		log.info("--------------------");
	}

	public void eliminaEdificio(Edificio e) {
		edificioRepo.delete(e);
		log.info("EDIFICIO: " + e.getNome() + " " + e.getIndirizzo() + " " + e.getCitta() + " "
				+ "Eliminato dal Database!");
		log.info("--------------------");
	}

}
