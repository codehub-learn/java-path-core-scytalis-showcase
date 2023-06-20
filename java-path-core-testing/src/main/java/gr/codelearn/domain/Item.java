package gr.codelearn.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@AllArgsConstructor
public class Item {
	private String name;
	private BigDecimal price;
	private Integer quantity;
	private Category category;

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Item item = (Item) o;
		return name.equals(item.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
