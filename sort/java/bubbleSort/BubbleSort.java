package bubbleSort;

import java.util.Arrays;

public class BubbleSort {

	/**
	 * 冒泡排序：相邻交换，遍历全部item，大的向后移，小的留在前面
	 * 
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Bubble algo = new Bubble();
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(algo.bubble(intArr)));
		
	}

	
	
}
class Bubble{
	/**
	 * swap each round to get the biggest and 'move' to the end
	 * @param arr
	 * @return
	 */
	public Integer[] bubble(Integer[] arr){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length-i-1; j++){
				if(arr[j].compareTo(arr[j+1]) > 0){
					swap(arr, j, j+1);
				}
			}
		}
		return arr;
	}
	
	/**
	 * Swap two values in an array
	 * @param array
	 * @param a
	 * @param b
	 */
	public void swap(Integer[] array, int a, int b){
		if(a!= b){
			int temp = array[a];
			array[a] = array[b];
			array[b] = temp;
		}
	}
}
