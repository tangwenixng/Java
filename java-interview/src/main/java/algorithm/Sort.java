package algorithm;

public class Sort {
	/**
	 * 插入排序 平均时间复杂度O(n^2)
	 * 原理：对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
	 * @param array
	 */
	public void insertSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j>0;j--){
				if(array[j] > array[j-1]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				else {
					break;
				}
			}
		}
	}
	/**
	 * 冒泡排序 时间复杂度O(n^2)
	 * @param array
	 */
	public void bubbleSort(int[] array){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length-1-i;j++){
				if(array[j+1] > array[j]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
	/**
	 * 选择排序  时间复杂度O(N^2)
	 * 工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置<br>
	 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
	 * @param arr
	 */
	public void selectSort(int[] arr){
		int len = arr.length;
		int min;
		for(int i=0;i<len-1;i++){
			min = i;
			for(int j=i+1;j<len;j++){
				if(arr[j]<arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	
	/**
	 * 二分查找算法
	 * @param arr
	 * @param start
	 * @param end
	 * @param key
	 * @return
	 */
	public int binary_search(int[] arr,int start,int end,int key){
		if(start>end)
			return -1;
		int center = (start+end)/2;
		if(key<arr[center])
			return binary_search(arr, start, center-1, key);
		if(key>arr[center])
			return binary_search(arr, center+1, end, key);
		return center;
	}
	
	
	public static void main(String[] args) {
		/*Sort sort = new Sort();
		int[] array = {8,5,2,6,9,3};
		sort.selectSort(array);
		for(int n:array)
			System.out.print(n+"　");*/
		/*Random rdRandom = new Random();
		for(int i=0;i<5;i++){
			int c = rdRandom.nextInt(1000)+1000;
			System.out.print(c+" ");
		}*/
		int[] array = {1,2,3,4,5,6,7};
		Sort sort = new Sort();
		int index = sort.binary_search(array, 0, array.length, 2);
		System.out.println(index);
	}
}
