package gr.codelearn.service;

import gr.codelearn.domain.Category;
import gr.codelearn.domain.Item;
import gr.codelearn.exception.BusinessException;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CartServiceImpl implements CartService {

	private final List<Item> cart;

	@Override
	public boolean addItem(Item item) throws BusinessException {
		if (item == null){
			throw new BusinessException();
		}
		if (item.getQuantity() > 0 && item.getPrice().doubleValue() > 0){
			cart.add(item);
			return true;
		}
		return false;
	}

	@Override
	public boolean removeItem(Item item) {
		return cart.remove(item);
	}

	@Override
	public List<Item> getCartItems() {
		return new ArrayList<>(cart);
	}

	@Override
	public BigDecimal getTotalPrice() {
		// @formatter:off
		return cart.stream()
				   .map(i -> i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
				   .reduce(BigDecimal.ZERO, BigDecimal::add);
		// @formatter:on
	}

	@Override
	public boolean checkout() {
		cart.clear();
		return true;
	}
}
