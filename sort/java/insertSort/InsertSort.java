package insertSort;

import java.util.Arrays;

public class InsertSort {
	/**
	 * 插入排序：遍历arr中的每个item，插入到排列好的有序arr中
	 * 
	 * Test
	 * @param args
	 */
	public static void main(String[] args){
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Insert algo = new Insert();
		System.out.println("原数组为： " + Arrays.toString(intArr));
		System.out.println("排序后的数组为： " + Arrays.toString(algo.insert(intArr)));
	}
}

class Insert{
	/**
	 * insert target to an ordered arr and move it one bit after
	 * @param arr
	 * @return
	 */
	public Integer[] insert(Integer[] arr) {
		for(int i= 1; i < arr.length; i++) {
			for(int j = 0; j < i; j++) {
				Integer insertedItem = arr[i]; 
				if(arr[j].compareTo(insertedItem) > 0) {
					move(arr, j, i-1);
					arr[j] = insertedItem;
					break;
				}
			}
		}
		return arr;
	}
	/**
	 * move each value between start and end in arr one bit afterwards 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public void move(Integer[] arr, int start,int end) {
		//必须倒叙移动，否则前面的数会覆盖掉后面的
		for(int i = end; i >= start; i--) {
			arr[i+1] = arr[i];
		}
	}
}
