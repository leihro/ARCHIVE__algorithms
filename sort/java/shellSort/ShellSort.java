package shellSort;

import java.util.Arrays;


public class ShellSort {
	/**
	 * 希尔排序：变化step的插入排序，先把乱的arr拍成大概从小到大，再发挥插入排序的性能优势
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] intArr = {2,4,5,66,4,232,454,3,2,454,64,23};
		Shell algo = new Shell();
		System.out.println(Arrays.toString(intArr));
		System.out.println(Arrays.toString(algo.shell(intArr)));
	}
}

class Shell{
	/**
	 * 以step为单位进行插入排序
	 * @param arr
	 * @return
	 */
	public Integer[] shell(Integer[] arr) {
		int step = initialStep(arr.length);
		//每做一个for循环，step减到下一个level
		for(; step >=1; step = (step + 1) / 2 - 1){
			//每个step长度中一个一个的进行插入排序
			for(int indexInGroup = 0; indexInGroup < step; indexInGroup++) {
				insertSort(arr, indexInGroup, step);
			}
		}
		return arr;
	}
	/**
	 * 
	 * @param arr
	 * @param index 组的index
	 * @param step	每次增加的step
	 */
	public void insertSort(Integer[] arr, int index, int step){
		int start = index;
		int end = start;
		
		while((end + step) <= arr.length-1){
			end += step;
		}
		
		for(int i = index + step; i <= arr.length-1; i += step){
			for(int j = index; j < i; j += step){
				// 一次插入的过程
				Integer insertedElem = arr[i];
				if((arr[j].compareTo(insertedElem)) > 0){
					//从第j个开始到i前一个step的向后移动一个step
					move(arr, j, i -step, step);
					arr[j] = insertedElem;
					break;
				}
			}
		}
	}
	/**
	 * 根据arr的length初始化step
	 * @param len
	 * @return
	 */
	public static int initialStep(int len){
		//step = {1,3,7,15,...,2^(k-1)-1,2^k-1}
		//step设置为一系列离散值，根据arr length调整，逐渐减为1，编程insertSort
		int step = 1;
		while((step + 1) * 2 - 1 < len -1){
			step = (step +1) * 2 - 1;
		}
		
		return step; 
	}
	/**
	 * 以step为单位向后移动arr，填补插入留下的空
	 * @param arr
	 * @param start
	 * @param end
	 * @param step
	 */
	public void move(Integer[] arr, int start, int end, int step) {
		for(int i = end; i>= start; i-= step){
			arr[i + step] = arr[i];
		}
	}
}