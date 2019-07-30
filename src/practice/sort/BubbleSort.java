package practice.sort;

public class BubbleSort {
	
	public void sort(int arr[]) {
		int n = arr.length;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.println("after sort ");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int arr[] = {5,9,3,1,2,8,4,7,6};
		bubbleSort.sort(arr);
	}
}
