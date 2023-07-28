package S5D1.configuration;

import java.time.LocalDate;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

import S5D1.entities.Edificio;
import S5D1.entities.Postazione;
import S5D1.entities.Prenotazione;
import S5D1.entities.Utente;
import S5D1.utils.TipoPostazione;

@Configuration
public class Config {

	private final Faker faker;

	public Config() {
		this.faker = new Faker(new Locale("it"));
	}

	@Bean("utente1")
	public Utente utente1() {
		return Utente.builder().userName("luca.quaglino").nomeCognome(faker.name().fullName())
				.mail(faker.internet().emailAddress()).build();
	}

	@Bean("utente2")
	public Utente utente2() {
		return Utente.builder().userName(faker.name().username()).nomeCognome(faker.name().fullName())
				.mail(faker.internet().emailAddress()).build();
	}

	@Bean("utente3")
	public Utente utente3() {
		return Utente.builder().userName(faker.name().username()).nomeCognome(faker.name().fullName())
				.mail(faker.internet().emailAddress()).build();
	}

	@Bean("edificio1")
	public Edificio edificio1() {
		return Edificio.builder().nome(faker.company().name()).indirizzo(faker.address().streetAddress())
				.citta(faker.address().city()).build();
	}

	@Bean("edificio2")
	public Edificio edificio2() {
		return Edificio.builder().nome(faker.company().name()).indirizzo(faker.address().streetAddress())
				.citta(faker.address().city()).build();
	}

	@Bean("edificio3")
	public Edificio edificio3() {
		return Edificio.builder().nome(faker.company().name()).indirizzo(faker.address().streetAddress())
				.citta(faker.address().city()).build();
	}

	@Bean("postazione1")

	public Postazione postazione1() {

		return Postazione.builder().id(UUID.randomUUID()).descrizione(faker.lorem().sentence())
				.tipo(getRandomTipoPostazione()).occupatiMax(faker.number().numberBetween(1, 10)).edificio(edificio1())
				.build();
	}

//metodo per impostare il valore dell enum in maniera casuale tra quelli inseriti 
	private TipoPostazione getRandomTipoPostazione() {
		TipoPostazione[] values = TipoPostazione.values();
		int randomIndex = ThreadLocalRandom.current().nextInt(values.length);
		return values[randomIndex];
	}

	@Bean("postazione2")
	public Postazione postazione2() {
		return Postazione.builder().id(UUID.randomUUID()).descrizione(faker.lorem().sentence())
				.tipo(getRandomTipoPostazione()).occupatiMax(faker.number().numberBetween(1, 10)).edificio(edificio1())
				.build();
	}

	@Bean("prenotazione1")

	public Prenotazione prenotazione1() {
		LocalDate dataPrenotazione = LocalDate.of(2023, 8, 10);
		return Prenotazione.builder().id(UUID.randomUUID()).dataPrenotazione(dataPrenotazione).postazione(postazione2())
				.utente(utente1()).build();
	}

	@Bean("prenotazione2")

	public Prenotazione prenotazione2() {
		LocalDate dataPrenotazione = LocalDate.of(2023, 8, 10);
		return Prenotazione.builder().id(UUID.randomUUID()).dataPrenotazione(dataPrenotazione).postazione(postazione2())
				.utente(utente1()).build();
	}
}
