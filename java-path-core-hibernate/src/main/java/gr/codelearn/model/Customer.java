package gr.codelearn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer extends BaseEntity{
	@Column(nullable = false, unique = true)
	private String email;
	private String firstname;
	private String lastname;
	private Integer age;
	private String address;
	@Enumerated(EnumType.STRING)
	private CustomerCategory customerCategory;
}
