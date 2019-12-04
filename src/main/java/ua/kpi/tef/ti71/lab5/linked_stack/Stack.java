package ua.kpi.tef.ti71.lab5.linked_stack;

/**
 *
 * Stack is a data structure that follows "last in, first out" rule (LIFO).
 */
public interface Stack<T> {
    /**
     * Adds an element to the begining of the linked_stack.
     *
     * @param element the element to add
     */
    void push(T element);

    /**
     * Retrieves and removes linked_stack head.
     *
     * @return an element that was retrieved from the head or null if linked_stack is empty
     */
    T pop();

    /**
     * Returns a size of the linked_stack.
     *
     * @return an integer value that is a size of linked_stack
     */
    int size();

    /**
     * Checks if the linked_stack is empty.
     *
     * @return {@code true} if the linked_stack is empty, returns {@code false} if it's not
     */
    boolean isEmpty();
}
