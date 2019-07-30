package practice.sort;

public class Merge {

	public void sort(int arr[],int temp[],int leftStart,int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		int mid = (leftStart + rightEnd)/2;
		sort(arr,temp,leftStart,mid);
		sort(arr,temp,mid+1,rightEnd);
		
		merging(arr,temp,leftStart,rightEnd);
	}
	public void merging(int arr[],int temp[],int leftStart,int rightEnd) {
		int leftEnd = (leftStart+rightEnd)/2;
		int rightStart = leftEnd+1;
		int size = rightEnd - leftStart +1;
		int left = leftStart;
		int right = rightStart;
		int k=leftStart;
		while(left < leftEnd && right < rightEnd) {
			if(arr[left] < arr[right]) {
				temp[k]=arr[left];
				left++;
			}else {
				temp[k] = arr[right];
				right++;
			}
			k++;
		}
		
		
		  while(left < leftEnd) { temp[k] = arr[left]; left++; k++; } while(right <
		  rightEnd) { temp[k] = arr[right]; right++; k++; }
		 
		
		/*
		 * System.arraycopy(arr,left,temp,k,leftEnd-left+1); System.arraycopy(arr,
		 * right, temp, k, rightEnd-right+1);
		 * System.arraycopy(temp,leftStart,arr,leftStart,size);
		 */
	}
	public static void main(String[] args) {
		Merge merge = new Merge();
		int arr[] = {38,27,43,3,9,82,10,1};
		int leftStart = 0;
		int n = arr.length;
		int temp[] = new int[n];
		int rightEnd = arr.length-1;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		merge.sort(arr,temp, leftStart, rightEnd);
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(temp[i]+" ");
		}
	}

}
