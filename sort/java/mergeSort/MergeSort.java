package mergeSort;

import java.util.Arrays;


public class MergeSort {
	/**
	 * 合并排序：把arr分到length为1，然后每分开的组之间进行排序，
	 * 一层一层的合并找到最终有序arr
	 * 
	 * Test
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Merge algo = new Merge();
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(algo.mergeSort(intArr)));
	}

}

class Merge{
	/**
	 * run the recursive merge function separately
	 * @param arr
	 * @return
	 */
	public Integer[] mergeSort(Integer[] arr){
		return partition(arr, 0, arr.length-1);
	}
	/**
	 * recursive partition and merge from unit arr
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	private Integer[] partition(Integer[] arr, int start, int end){
		if(start<end) {
			int middle = (start + end) / 2;
			partition(arr, start, middle);
			partition(arr, middle +1, end);
			
			merge(arr, start, end, middle);
		}
		
		return arr;
	}
	/**
	 * compare elems in both ordered arrs 
	 * and merge a double sized ordered arr 
	 * @param arr
	 * @param start
	 * @param end
	 * @param mid
	 */
	private void merge(Integer[] arr, int start, int end, int mid) {
		//arr buufer has to be big enough
		Integer[] tempArr = new Integer[100];
		int tempIndex = 0;
		int part1Index = start;
		int part2Index = mid +1;
		
		while((part1Index <= mid) && (part2Index <= end)){
			if(arr[part1Index] - arr[part2Index] < 0) {
				tempArr[tempIndex++] = arr[part1Index++];
			} else {
				tempArr[tempIndex++] = arr[part2Index++];
			}
		}
		while(part1Index <= mid) {
			tempArr[tempIndex] = arr[part1Index];
			tempIndex++;
			part1Index++;
		}
		while(part2Index <= end) {
			tempArr[tempIndex] = arr[part2Index];
			tempIndex++;
			part2Index++;
		}
		System.arraycopy(tempArr, 0, arr, start, end-start+1);
	}
}
