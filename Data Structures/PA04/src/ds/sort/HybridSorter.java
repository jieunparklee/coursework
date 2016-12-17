package ds.sort;

public class HybridSorter<K extends Comparable<? super K>> implements Sorter<K> {
	Sorter<K> heapSort = new AlternativeSorter<K>();
	/**
	 * Sorts the elements in given array from `left` to `right in lexicographic order
	 * using the hybrid sorting algorithm.
	 */
	@Override
	public void sort(Pair<K, ?>[] array, int left, int right) {
		quickSort(array, left, right, (int) (2 * Math.floor((Math.log(right - left + 1)/Math.log(2)))));
	}
	
	private void quickSort(Pair<K, ?>[] array, int l, int r, int maxdepth) {
		if (maxdepth == 0)
			heapSort.sort(array, l, r);
		else {
			if(l < r) {
				int q = partition(array, l, r);
				quickSort(array, l, q, maxdepth - 1);
				quickSort(array, q + 1, r, maxdepth - 1);
			} 
		}
	}

	private int partition(Pair<K, ?>[] array, int l, int r) {
		Pair<K, ?> x = array[l];
		int i = l - 1 ;
		int j = r + 1 ;

		while (true) {
			i++;
			while ((i < r) && (array[i].getKey().compareTo(x.getKey()) < 0))
				i++;
			j--;
			while ((j > l) && (array[j].getKey().compareTo(x.getKey()) > 0))
				j--;

			if (i < j) 
				swap(array, i, j);
			else {
				swap(array, l, j);
				return j;
			}
		}
	}

	private void swap(Pair<K, ?>[] array, int i, int j) {
		Pair<K, ?> helper = array[i];
		array[i] = array[j];
		array[j] = helper;
	}
}