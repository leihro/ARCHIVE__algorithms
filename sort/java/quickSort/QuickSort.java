package quickSort;

import java.util.Arrays;

public class QuickSort {
	/**
	 * 快速排序：不断根据pivot点将arr分成sub arrs进行迭代的排序
	 * 
	 * Test
	 * @param args
	 */
	public static void main(String[] args){
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Quick algo = new Quick();
		System.out.println("原数组为： " + Arrays.toString(intArr));
		System.out.println("排序后的数组为： " + Arrays.toString(algo.quick(intArr)));
	
	}
}	

class Quick{
	public Integer[] quick(Integer[] arr){
		// in order to call outside recursively
		return quickSort(arr, 0, arr.length-1);
	}
	/**
	 * recursive call based on the partition result, 
	 * always find a pivot and sort a sub arr
	 * @param arr
	 * @param low
	 * @param high
	 * @return
	 */
	private Integer[] quickSort(Integer[] arr, int low, int high) {
		if(low < high) {
			int pivot = patition(arr, low, high);
			
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
		return arr;
	}
	/**
	 * patition arr into two parts based on a random pivot
	 * @param arr
	 * @param low		low border of the arr to partition
	 * @param high		high border of the arr to partition
	 * @return 			the pivot
	 */
	private int patition(Integer[] arr, int low, int high){
		// pivotElem is an elem now with index low
		Integer pivotElem = arr[low];
		//border is an index
		int border = low;
		
		for(int i = low +1; i<=high; i++) {
			if((arr[i].compareTo(pivotElem)) < 0){
				swap(arr, ++border, i);
			}
		}
		// swap the pivot elem to the middle somewhere in the arr
		swap(arr, border, low);
		
		return border;
	}
	/**
	 * swap two values in the arr given indexes
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(Integer[] arr, int i, int j){
		if(i != j){
			Integer temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}

