package ua.kpi.tef.ti71.lab5.linked_stack;


import ua.kpi.tef.ti71.util.Node;

public class LinkedStack<T> implements Stack<T> {
	private Node<T> lastElement;
	private int size;

	public LinkedStack() {
		this.lastElement = null;
		this.size = 0;
	}

	@Override
	public void push(T element) {
		this.lastElement = new Node<>(this.lastElement, element);
		this.size++;
	}

	@Override
	public T pop() {
		if (this.size > 0) {
			T value = this.lastElement.getValue();
			this.lastElement = this.lastElement.getPrevious();
			this.size--;
			return value;
		} else {
			throw new EmptyStackException();
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
}
