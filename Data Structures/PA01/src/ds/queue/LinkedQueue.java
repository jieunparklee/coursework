package ds.queue;

public class LinkedQueue<E> implements Queue<E> {
	
	private ds.stack.LinkedStack<E> stack;
	
	public LinkedQueue() {
		this.stack = new ds.stack.LinkedStack<E>();
	}

	@Override
	public void clear() {
		this.stack.clear();
	}

	@Override
	public void enqueue(E item) {
		this.stack.push(item);
	}

	@Override
	public E dequeue() {
		return this.stack.popEnd();
	}

	@Override
	public int length() {
		return this.stack.length();
	}

	@Override
	public boolean isEmpty() {
		return this.stack.isEmpty();
	}

	@Override
	public void reverse() {
		ds.stack.Stack<E> temp = this.stack;
		this.stack = new ds.stack.LinkedStack<E>();
		while (!temp.isEmpty()) {
			this.stack.push(temp.pop());
		}
	}

}
