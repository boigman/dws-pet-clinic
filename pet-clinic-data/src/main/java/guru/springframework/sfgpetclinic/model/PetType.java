package guru.springframework.sfgpetclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import guru.springframework.sfgpetclinic.model.Pet.PetBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="types")
public class PetType extends BaseEntity {
	
	@Column(name="name")
	private String name;


}
