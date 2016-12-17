package ds.table;

/**
 * Class for Priority Hash Table.
 * You should add additional member variables and functions to this class.
 * You may implement more classes!
 * You must NOT print anything in this class (it will cause format errors).
 */
public class PriorityTable {
	Pair[] table;
	int size = 20003297;
	//int probe1 = 0; //503;
	int probe2 = 9739; //6737;
	//int probe3 = 0; //5003;
	//public int collision = 0;
	
	/**
	 * Constructor for the class.
	 */
	public PriorityTable() {
		table = new Pair[size];
	}
	
	/**
	 * Inserts (key, value) to the table.
	 * It returns nothing.
	 */
	public void insert(String key, double value) {
		//System.out.println("table insert called");
		int hash = Math.abs(key.hashCode());
		int slot = hash % size;
		int i = 1;
		while (table[slot] != null) {
			if (table[slot].key.equals(key)) {
				if (table[slot].value == null) table[slot].value = new MaxHeap(value);
				else table[slot].value.insert(value);
				return;
			}
			else if (table[slot].value == null) {
				table[slot].key = key;
				table[slot].value = new MaxHeap(value);
				//System.out.println("in here, inserted in slot: " + slot + " hash: " + hash);
				return;
			}
			else {
				//slot = (hash+ (probe1*i*i) + (probe2*i) + probe3) % size;
				slot = (hash+ (probe2*i)) % size;
				i++;
				//collision++;
			}
		}
		table[slot] = new Pair(key, value);
		//System.out.println("inserted in slot: " + slot + " hash: " + hash);
	}
	
	/**
	 * Removes the record having (key) in the table.
	 * The record having (key, the maximum value) should be removed.
	 * If there is no record having (key), do nothing.
	 */
	public void delete(String key) {
		int hash = Math.abs(key.hashCode()); 
		int slot = hash % size;
		int i = 1;
		while (table[slot] != null && i <= size) {
			if (table[slot].key.equals(key)) {
				if (table[slot].value == null) {}
				else if (table[slot].value.heapsize() == 1) table[slot].value = null;
				else table[slot].value.removeMax();
				return;
			}
			else {
				//slot = (hash + (probe1*i*i) + (probe2*i) + probe3) % size;
				slot = (hash+ (probe2*i)) % size;
				i++;
			}
		} 
	}
	
	/**
	 * Searches for the record having (key) in the table.
	 * It returns the maximum value among the records having (key).
	 * If there is no record having (key), return zero.
	 */
	public double search(String key) {
		int hash = Math.abs(key.hashCode()); 
		int slot = hash % size;
		int i = 1;
		while (table[slot] != null && i <= size) {
			if (table[slot].key.equals(key)) {
				if (table[slot].value != null) return table[slot].value.heap[0];
				else return 0.0;
			}
			else {
				//slot = (hash + (probe1*i*i) + (probe2*i) + probe3) % size;
				slot = (hash+ (probe2*i)) % size;
				i++;
			}
		} 
		return 0.0;
	}
}

class Pair {
	String key;
	MaxHeap value;
	
	Pair(String key, double value) {
		this.key = key;
		this.value = new MaxHeap(value);
	}
}

class MaxHeap {
	public double[] heap; 
	private int n; 
	
	public MaxHeap(double val) { 
		heap = new double[10]; 
		heap[0] = val;
		n = 1;
	}
	
	public int heapsize() { return n; }
	public boolean isLeaf (int pos) { 
		return (pos>= n/2) && (pos< n); 
	}
	public int leftchild(int pos) { 
		return 2*pos+ 1;
	}
	public int rightchild(int pos) { 
		return 2*pos+ 2;
	}
	public int parent(int pos) {
		return (pos-1)/2;
	}
	
	public void buildheap() { 
		for (int i=n/2-1; i>=0; i--) 
			siftdown(i); 
	}
	private void siftdown(int pos) {
		while (!isLeaf(pos)) {
			int j = leftchild(pos);
			if ((j<(n-1)) && (heap[j] < (heap[j+1])))
				j++; 
			if (heap[pos] >= heap[j])
				return;
			swap(heap, pos, j);
			pos= j; 
		}
	}
	
	public void insert(double val) {
		int curr = n++;
		ensureCapacity(curr);
		heap[curr] = val;
		while ((curr != 0) && (heap[curr] > (heap[parent(curr)]))) {
			swap(heap, curr, parent(curr));
			curr = parent(curr);
		}
	}
	
	public void removeMax() {
		if (n > 0) {
			swap(heap, 0, --n);
			if (n != 0) siftdown(0);
		} 
	}
	
	private void swap(double[] value, int i, int j) {
		double helper = value[i];
		value[i] = value[j];
		value[j] = helper;
	}
	
	private void ensureCapacity(int n) {
	    if (n == heap.length) {
	        int newSize = heap.length * 2;
	        double[] newHeap = new double[newSize];
	        System.arraycopy(heap, 0, newHeap, 0, heap.length);
	        heap = newHeap;
	    }
	}
}