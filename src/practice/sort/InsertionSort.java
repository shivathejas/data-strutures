package practice.sort;

public class InsertionSort {
	public void sort(int arr[]) {
		int n=arr.length;
		int j=0;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=1;i<n;++i) {
			int key = arr[i];
			for( j = i-1;j>=0 && arr[j] > key;j--) {
				arr[j+1] = arr[j];
			}
			arr[j+1] = key;	
		}
		System.out.println();
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		int arr[] = {5,3,4,7,2,8,6,9,1};
		insertionSort.sort(arr);
	}
}
