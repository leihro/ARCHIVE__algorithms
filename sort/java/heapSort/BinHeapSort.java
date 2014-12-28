package heapSort;

import java.util.Arrays;

public class BinHeapSort {
	/**
	 * 堆排序：构建二叉堆（大根），因为根始终为最大的值，插入到最后，重复即可
	 * 
	 * TEST
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Heap algo = new Heap();
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(algo.heap(intArr)));
	}

}

class Heap {
	/**
	 * get the ordered arr using heapsort
	 * @param arr
	 * @return
	 */
	public Integer[] heap(Integer []arr){
		init(arr);
		// after init, the arr is a binary heap with bigger number front
		for(int i = arr.length-1; i >= 1; i--){
			//swap bigger number to the end of the arr each round
			swap(arr, 0, i);
			// adjust the heap arr for next round
			adjust(arr, 1, i);
		}
		
		return arr;
	}
	//to form an arr to a binary heap format
	/**
	 * arr -> bin heap format, where bigger numbers are in the front
	 * @param arr
	 */
	private void init(Integer[] arr){
		int lastBranchIndex = arr.length / 2; // last not leaf node
		for(int i = lastBranchIndex; i >= 1; i--){
			//index of the binary heap starts from 1
			//index of arr starts from 0
			//indexOfArray = indexOfBinHeap - 1
			adjust(arr, i, arr.length);
		}
	}
	/**
	 * swap two values in an arr given two indexes
	 * @param arr
	 * @param a
	 * @param b
	 */
	private void swap(Integer[] arr, int a, int b){
		if(a != b) {
			Integer temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
	/**
	 * compare between father and two leaves, biggest as the new father
	 * all the way down to the very end of each branch of the tree
	 * 
	 * @param arr
	 * @param fatherIndex
	 * @param length
	 */
	private void adjust(Integer[] arr, int fatherIndex, int length){
		int maxIndex = fatherIndex;
		// if left leaf node existed
		if(fatherIndex * 2 <= length){
			int leftChildIndex = fatherIndex * 2; // character of bin heap
			if((arr[fatherIndex - 1].compareTo(arr[leftChildIndex - 1])) < 0) {
				maxIndex = leftChildIndex;
			}
			//if right leaf node existed
			if(fatherIndex * 2 + 1 <= length){
				int rightChildIndex = fatherIndex * 2 +1;
				if((arr[maxIndex - 1].compareTo(arr[rightChildIndex -1])) < 0) {
					maxIndex = rightChildIndex;
				}
			}
		}
		//maxIndex up to now point to the biggest value in these 3
		if(maxIndex != fatherIndex) {
			swap(arr, fatherIndex -1, maxIndex -1);
			if(maxIndex * 2 <= length){
				//if there is still leaves left
				adjust(arr, maxIndex, length);
			}
		}
	}
}
