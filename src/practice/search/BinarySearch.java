package practice.search;

public class BinarySearch {

	public int search(int arr[],int l, int r,int x) {
		if(l <= r) {
		int mid = (l+r)/2;
			if(arr[mid] == x) {
				return arr[mid];
			}
			if(arr[mid] > x) {
				return search(arr,l,mid-1,x);
			}else {
				return search(arr,mid+1,r,x);
			}
		}else {
		return -1;
		}
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int len = arr.length-1;
		int x = 9;
		int result = bs.search(arr, 0, len, x);
		if(result == -1) {
			System.out.println("not fount");
		}else {
			System.out.println("found");
		}
	}

}
