package S5D1.entities;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
public class Prenotazione {
	@Id
	@GeneratedValue
	private UUID id;
	private LocalDate dataPrenotazione;
	private LocalDate dataScadenza;
	@ManyToOne
	private Postazione postazione;

	@ManyToOne
	private Utente utente;

}
