package ua.kpi.tef.ti71.lab5.linked_stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
	private Stack<Integer> intStack = new LinkedStack<>();

	@Test
	public void testPushElementOntoEmptyStack() {
		intStack.push(234);

		assertEquals(1, intStack.size());
	}

	@Test
	public void testPopElementFromEmptyStack() {
		assertThrows(EmptyStackException.class, () -> intStack.pop());
	}

	@Test
	public void testPushElements() {
		intStack.push(23);
		intStack.push(35);
		intStack.push(72);

		intStack.push(55);

		assertEquals(55, intStack.pop());
	}

	@Test
	public void testPopElements() {
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		intStack.pop();
		intStack.push(234);
		Integer lastElement = intStack.pop();

		assertEquals(234, lastElement);
	}

	@Test
	public void testSize(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		int actualSize = intStack.size();

		assertEquals(3, actualSize);
	}

	@Test
	public void testSizeOnEmptyStack(){
		int actualSize = intStack.size();

		assertEquals(0, actualSize);
	}

	@Test
	public void testIsEmpty(){
		intStack.push(87);
		intStack.push(53);
		intStack.push(66);

		boolean stackEmpty = intStack.isEmpty();

		assertFalse(stackEmpty);
	}

	@Test
	public void testIsEmptyOnEmptyStack(){
		boolean stackEmpty = intStack.isEmpty();

		assertTrue(stackEmpty);
	}
}
