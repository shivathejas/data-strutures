package practice.sort;

public class QuickSort {

	public void sort(int arr[],int left,int right) {
		if(left >= right) {
			return;
		}
		int pivot  = arr[(left+right)/2];
		System.out.println((left+right)/2);
		int index = partition(arr,left,right,pivot);
		sort(arr,left,index-1);
		sort(arr,index,right);
	}
	public int partition(int arr[],int left,int right,int pivot) {
		while(left <= right) {
			while(arr[left] < pivot) {
				left++;
			}
			while(arr[right] > pivot) {
				right--;
			}
			if(left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
	public static void main(String[] args) {
		QuickSort quickSort = new QuickSort();
		int arr[] = {6,3,9,8,5,2,7,1,4};
		int right = arr.length-1;
		int n = arr.length;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		quickSort.sort(arr, 0, right);	
		System.out.println();
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
