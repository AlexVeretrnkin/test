package ua.procamp.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ua.procamp.collections.EmptyStackException;
import ua.procamp.collections.LinkedStack;
import ua.procamp.collections.Stack;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class LinkedStackTest {
    private Stack<Integer> intStack = new LinkedStack<>();

    @Test
    public void testPushElementOntoEmptyStack() {
        intStack.push(234);
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

        assertEquals(intStack.pop(), 55);
    }

    @Test
    public void testPopElements() {
        intStack.push(87);
        intStack.push(53);
        intStack.push(66);

        intStack.pop();
        intStack.push(234);
        Integer lastElement = intStack.pop();

        assertEquals(lastElement, 234);
    }

    @Test
    public void testSize(){
        intStack.push(87);
        intStack.push(53);
        intStack.push(66);

        int actualSize = intStack.size();

        assertEquals(actualSize, 3);
    }

    @Test
    public void testSizeOnEmptyStack(){
        int actualSize = intStack.size();

        assertEquals(actualSize, 0);
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