package practice.problem;

public class Arrays {
	
	/*This method will add 1 to the array,
	 * where array consists of only integer ranging from 0-9 at every index in array
	 *  example:
	 * arr[]={1,2,3,4,9}+1={1,2,3,5,0} <= this is the result output
	*/	
	public void addOne(int arr[]) {
		int len=arr.length;
		int startIndex=0;
		/*If there are zeros at left of array example:arr[] = {0,0,0,1,2,3}
		 * then intializing the start index from where the actual nubmber starts
		*/
		for(int i=0;i<len-1;i++) {
			if(arr[i]!=0) {
				startIndex=i;
				break;
			}
		}
		int carry=1;
		int[] result = new int[len+1];
		//building result array
		for(int j=len-1;j>=startIndex;j--) {
			if((arr[j]+carry)>9) {
				carry=1;
				result[j]=0;
			}else {
				result[j]=arr[j]+carry;
				carry=0;
			}
		}
		int resultStart=0;
		for(int i=0;i<len-1;i++) {
			if(arr[i]!=0) {
				resultStart=i;
				break;
			}
		}
		if(carry==1) {
		  System.out.print("1");
		}
		for(int z=resultStart;z<result.length-1;z++) {
			System.out.print(result[z]);
		}
	}
	public void maxSumSubArray(int arr[]) {
		int len = arr.length;
		int prevStartIndex=0,prevLastIndex=0,currentStartIndex,currentLastIndex;
		for(int i=0;i<len-1;i++) {
			if(arr[i]<0) {
				
			}else {
				
			}
		}
	}
	public static void main(String[] args) {
		Arrays arrays = new Arrays();
		int arr[]= {9};
		arrays.addOne(arr);
	}
}
