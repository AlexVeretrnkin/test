package ua.procamp.util;

/**
 * Node is a companion data structure for linked-type iterables, e.g lists, queues, stacks;
 * @param <T>
 */
public class Node<T> {
    private Node<T> previous;
    private Node<T> next;
    private T value;

    public Node() {
    }

    public Node(Node<T> previous, T value, Node<T> next) {
        setPrevious(previous);
        this.value = value;
        setNext(next);
    }

    public Node(Node<T> previous, T value) {
        this(previous, value, null);
    }

    public Node(T value, Node<T> next) {
        this(null, value, next);
    }

    public Node(T value) {
        this(null, value, null);
    }

    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Sets previous node for the called one while also setting the next for the previous one.
     * @param previous
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
        if (previous != null) {
            previous.next = this;
        }
    }

    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets next node for the called one while also setting the previous for the next one.
     * @param next
     */
    public void setNext(Node<T> next) {
        this.next = next;
        if (next != null) {
            next.previous = this;
        }
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Removes references to this node from the neighboured ones thus allowing JVM to free up memory faster.
     * @return value stored in unlinked node
     */
    public T unlink() {
        if (this.previous != null) {
            this.previous.setNext(this.next);
        }
        if (this.next != null) {
            this.next.setPrevious(this.previous);
        }
        this.previous = null;
        this.next = null;
        return this.value;
    }
}