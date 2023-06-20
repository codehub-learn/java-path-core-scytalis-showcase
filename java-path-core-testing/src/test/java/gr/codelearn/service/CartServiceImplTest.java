package gr.codelearn.service;

import gr.codelearn.domain.Category;
import gr.codelearn.domain.Item;
import gr.codelearn.exception.BusinessException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CartServiceImplTest {
	@Test
	void testMethod() {
		assertTrue(true);
	}

	@Test
	void addingCorrectItemToCartShouldReturnTrue() throws BusinessException {
		Item item = new Item("Potatoes", BigDecimal.valueOf(5), 3, Category.SOFTWARE);
		CartServiceImpl cartService = new CartServiceImpl(new ArrayList<>());
		boolean result = cartService.addItem(item);
		assertTrue(result);
	}

	@Test
	void addingZeroQuantityItemToCartShouldReturnFalse() throws BusinessException {
		Item item = new Item("Potatoes", BigDecimal.valueOf(0), 5, Category.SOFTWARE);
		CartServiceImpl cartService = new CartServiceImpl(new ArrayList<>());
		boolean result = cartService.addItem(item);
		assertFalse(result);
	}

	@Test
	void addingNullItemToCartShouldThrowException(){
		Item item = null;
		CartServiceImpl cartService = new CartServiceImpl(new ArrayList<>());
		assertThrows(BusinessException.class, () -> cartService.addItem(item));
	}

	@Test
	void cartIsUpdatedWhenCorrectItemIsAddedTwice() throws Exception {
		// test fails, should be refactored by reader
		Item item1 = new Item("Potatoes", BigDecimal.valueOf(2), 10, Category.SOFTWARE);
		Item item2 = new Item("Potatoes", BigDecimal.valueOf(2), 5, Category.SOFTWARE);
		CartServiceImpl cartService = new CartServiceImpl(new ArrayList<>());
		cartService.addItem(item1);
		cartService.addItem(item2);
		List<Item> cartItems = cartService.getCartItems();
		assertAll(
				() -> assertEquals(1, cartItems.size()),
				() -> assertEquals(3, cartItems.get(0).getQuantity())
				 );
	}

	@Test
	void addItemsToCartAndReturnedItemsAreSortedAccordingToInsertionOrder() throws Exception {
		Item item1 = new Item("Potatoes", BigDecimal.valueOf(1), 5, Category.SOFTWARE);
		Item item2 = new Item("Computer", BigDecimal.valueOf(2), 1, Category.HARDWARE);
		CartServiceImpl cartService = new CartServiceImpl(new ArrayList<>());
		cartService.addItem(item1);
		cartService.addItem(item2);
		// checks if given list is identical to list received from cart service (same objects same order)
		assertIterableEquals(List.of(item1,item2), cartService.getCartItems());
	}
}
