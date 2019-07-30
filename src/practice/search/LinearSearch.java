package practice.search;

public class LinearSearch {
	
	public void search(int arr[],int intial, int len, int x) {
		String result = null;
		for(int i=intial;i<len-1;i++) {
			if(arr[i] == x) {
				result = x+" is at "+i+"th position in array";
				break;
			}else {
				result = "not found";
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		int arr[] = {1,5,4,23,12,11};
		int len = arr.length;
		int x=1222;
		LinearSearch ls = new LinearSearch();
		ls.search(arr, 0, len, x);
	}
}
