package ds.stack;

public class LinkedStack<E> implements Stack<E> {
	
	private ds.list.LinkedList<E> linkedlist;

	public LinkedStack() {
		this.linkedlist = new ds.list.LinkedList<E>(); 
	}
	
	@Override
	public void clear() {
		this.linkedlist.clear();
	}

	@Override
	public void push(E item) {
		this.linkedlist.insert(0, item);
	}

	@Override
	public E pop() {
		return this.linkedlist.remove(0);
	}

	@Override
	public int length() {
		return this.linkedlist.length();
	}

	@Override
	public boolean isEmpty() {
		return (this.linkedlist.length() == 0);
	}
	
	public E popEnd() {
		return this.linkedlist.remove(linkedlist.length() - 1);
	}
}
