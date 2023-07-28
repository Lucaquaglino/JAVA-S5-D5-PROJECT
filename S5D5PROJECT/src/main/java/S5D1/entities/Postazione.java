package S5D1.entities;

import java.util.UUID;

import S5D1.utils.TipoPostazione;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class Postazione {
	@Id
	private UUID id;
	private String descrizione;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private Integer occupatiMax;
	@ManyToOne

	private Edificio edificio;

}
