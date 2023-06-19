package gr.codelearn.core.showcase.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Invoice {
	private String invoiceNo;
	private BigDecimal price;
	private BigDecimal quantity;
}
