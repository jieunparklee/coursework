package ds.list;

public class LinkedList<E> implements List<E> {
	private Link<E> head;
	private Link<E> tail;
	protected Link<E> curr;
	int cnt;
	
	public LinkedList() {
		curr = tail = head = new Link<E>(null, null);
		cnt = 0;	
	}

	@Override
	public void clear() {
		head.setNext(null);
		curr = tail = head = new Link<E>(null, null);
		cnt = 0;
	}

	@Override
	public void insert(int pos, E item) {
		if (moveToPos(pos)) {
			curr.setNext(new Link<E>(item, curr.next()));
			if (tail == curr) tail = curr.next();
			cnt++;
		}
	}

	@Override
	public E remove(int pos) {
		if (moveToPos(pos) && (pos!=cnt)) {
			if (curr.next() == null) return null;
			E it = curr.next().getElement();
			if (tail == curr.next()) tail = curr;
			curr.setNext(curr.next().next());
			cnt--;
			return it;	
		} else return null;
	}

	@Override
	public int length() {
		return cnt;
	}

	@Override
	public E getValue(int pos) {
		if (moveToPos(pos) && (pos!=cnt)) {
			if (curr.next() != null) return curr.next().getElement();	 
			else return null;
		} else return null;
	}
	
	public boolean moveToPos(int pos) {
		if ((pos>=0) && (pos<=cnt)) {
			curr = head;
			for(int i=0; i<pos; i++) curr = curr.next();
			return true;
		} else return false;
	}
	
	public void printer() {
		Link<E> temp = head;
		for(int i=0; i<cnt; i++) {
			System.out.println(i + ": " + temp.next().getElement());
			temp = temp.next();
		}
		System.out.println(temp.next() == null);
	}
}
