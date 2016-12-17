package ds.sort;

public class AlternativeSorter<K extends Comparable<? super K>> implements Sorter<K> {

	/**
	 * Sorts the elements in given array from `left` to `right` in lexicograph order without
	 * the quicksort algorithm.
	 */
	// heapsort
	@Override
	public void sort(Pair<K, ?>[] array, int left, int right) {
		for(int i = ((right + left - 1)/2); i >= left; i--){
			siftDown(array, left ,i, right + 1);
		}
		for (int j = right; j > left; j--){
			swap(array, left, j);
			siftDown(array, left, left, j);
		}
	}
	
	private void siftDown(Pair<K, ?>[] array, int min, int i, int max) {
		int child;
		int rightchild;
		while ((child = (2 * i) + 1 - min) < max) {
			rightchild = child + 1;
			if ((rightchild < max) && (array[child].getKey().compareTo(array[rightchild].getKey()) < 0))
				child = rightchild;
			if (array[i].getKey().compareTo(array[child].getKey()) < 0){
				swap(array, i, child);
				i = child;
			} else break;
		}
	}
	
	private void swap(Pair<K, ?>[] array, int i, int j) {
		Pair<K, ?> helper = array[i];
		array[i] = array[j];
		array[j] = helper;
	}
}