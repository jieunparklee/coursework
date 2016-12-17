package CCFinder;

public class ParPtrTree {
	private Integer[] array; // Node array

	public ParPtrTree(int size) {
		array = new Integer[size]; // Create node array
		for (int i = 0; i < size; i++)
			array[i] = null;
	}

	/** Determine if nodes are in different trees */
	public boolean differ(int node1, int node2) {
		int root1 = FIND(node1);
		int root2 = FIND(node2);
		return root1 != root2;
	}

	/** Merge two subtrees */
	public void UNION(int node1, int node2) {
		Integer root1 = FIND(node1); 
		Integer root2 = FIND(node2); 
		if (root1 != root2) array[root2] = root1;
	}

	public Integer FIND(Integer node) { //using path compression
		if (array[node] == null) return node;
		array[node] = FIND(array[node]);
		return array[node];
	}
	
	public String print(Integer node) {
		int compare = FIND(node);
		String result = "";
		for (int i = 0; i < array.length; i++) {
			if (FIND(i) == compare) result += i + " ";
		} return result.substring(0, result.length() - 1);
	}
	
	public Integer number() {
        int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null) result++;
		} return result;
	}
	
	public Integer size(Integer node) {
		int compare = FIND(node);
		int result = 0;
		for (int i = 0; i < array.length; i++) {
			if (FIND(i) == compare) result++; 
		} return result;
	}
}
