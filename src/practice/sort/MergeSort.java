package practice.sort;

public class MergeSort {

	public void sort(int arr[],int l,int r) {
		int m;
		if(l<r) {
			m = (l+r)/2;
//			spliting the arr into 2 halves
			sort(arr,l,m);
			sort(arr,m+1,r);
//			sort the splited arr and merge
			merge(arr,l,m,r);
		}
	}
	public void merge(int arr[],int l,int m,int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			R[j] = arr[m+1+j];
		}
		
		int i=0,j=0;
		int k=l;
		
		while(i<n1 && j< n2) {
			if(L[i] < R[j]) {
				arr[k] = L[i];
				i++;
			}else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i <n1) {
			arr[k]=L[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
		
	}
	public static void main(String[] args) {
		MergeSort mergeSort = new MergeSort();
		int arr[] = {38,27,43,3,9,82,10,1};
		int n = arr.length;
		int r = arr.length-1;	//last index
		int l = 0;				//first  index
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		mergeSort.sort(arr, l, r);
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
