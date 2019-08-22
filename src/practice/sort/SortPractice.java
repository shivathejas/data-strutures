package practice.sort;

public class SortPractice {
//			Quick sort
//	public void sort(int arr[],int left,int right) {
//		if(left>=right) {
//			return;
//		}
//			int pivot = arr[(left+right)/2];
//			int index = partition(arr, left, right, pivot);
//			sort(arr,left,index-1);
//			sort(arr,index,right);
//		
//	}
//	public int partition(int arr[],int left,int right,int pivot) {
//		while(left<=right) {
//			while(arr[left]<pivot) {
//				left++;
//			}
//			while(arr[right]>pivot) {
//				right--;
//			}
//			if(left<=right) {
//				int temp = arr[left];
//				arr[left] =arr[right];
//				arr[right]=temp;
//				left++;
//				right--;
//			}
//		}
//		return left;
//	}
	
//		Merge Sort
	public void sort(int arr[],int left,int right) {
		if(left>=right) {
			return;
		}
		int mid = (left+right)/2;
		sort(arr,left,mid);
		sort(arr,mid+1,right);
		merge(arr,left,right,mid);
	}
	public void merge(int arr[],int l,int r,int m) {
		int n1 = m+1-l;
		int n2 = r-m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			R[j] = arr[m+1+j];
		}
		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(L[i]<R[j]) {
				arr[k]=L[i];
				i++;
			}else {
				arr[k]=R[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k]=R[j];
			j++;
			k++;
		}
	}
	
	
	public static void main(String[] args) {
		SortPractice sortPractice = new SortPractice();
		int arr[] = {6,3,9,8,5,2,7,1};
		int n = arr.length;
		int right = arr.length-1;
		int left =0;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		sortPractice.sort(arr, left, right);
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
