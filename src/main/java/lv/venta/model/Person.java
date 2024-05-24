package lv.venta.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "Person")
@Entity
// @Inheritance(strategy = InheritanceType.JOINED) // kopigas lietas (idpe, name, surname) ir personas tabula un atskirigas bernu tabula
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE) // viss Students, Professor, Personas) nus viena tabula
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // katrai clasei sava tabula, bet bazes tabula ir tuksa
public class Person {

	@Id
	@Column(name = "Idpe")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpe;
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Only letters and space are allowed")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 2, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅa-zēūīļķģšāžčņ ]+", message = "Only letters and space are allowed")
	private String surname;
	
	
	public Person(String name, String surnmame) {
		setName(name);
		setSurname(surnmame);
	}
	
}
