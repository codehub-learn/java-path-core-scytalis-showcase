package gr.codelearn.service;

import gr.codelearn.domain.Category;
import gr.codelearn.domain.Item;
import gr.codelearn.exception.BusinessException;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
	boolean addItem(Item item) throws BusinessException;
	boolean removeItem(Item item);
	List<Item> getCartItems();
	BigDecimal getTotalPrice();
	boolean checkout();
}
