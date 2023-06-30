package gr.codelearn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order extends BaseEntity{
	@ManyToOne
	private Customer customer;
	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
	private Date submitDate;
	private PaymentMethod paymentMethod;
	private BigDecimal totalPrice;
}
