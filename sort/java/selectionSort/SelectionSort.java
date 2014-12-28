package selectionSort;

import java.util.Arrays;


public class SelectionSort {
	/**
	 * 选择排序：一次for循环选出一个最小的
	 * 
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Select algo = new Select();
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(algo.select(intArr)));
	}

}

class Select{
	/**
	 * each for loop select the min value and swap to the front
	 * @param intArr
	 * @return
	 */
	public Integer[] select(Integer[] intArr){
		int minIndex;
		
		for (int i = 0; i < intArr.length; i++) {
			minIndex = i;
			for (int j = i+1; j < intArr.length; j++) {
				if(intArr[j].compareTo(intArr[minIndex]) < 0){
					minIndex = j;
				}
			}
			swap(intArr, i, minIndex);
		}
		
		
		return intArr;
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