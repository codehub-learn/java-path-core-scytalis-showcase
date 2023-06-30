package gr.codelearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Entity
public class Product extends BaseEntity{
	private String serial;
	private String name;
	private BigDecimal price;
	@ManyToOne
	private Category category;
}
