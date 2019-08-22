package practice.problem;

import java.util.HashMap;
import java.util.Map;

public class FindMissing {

	public void findMissAndRepeat(int arr[]) {
		int len=arr.length;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=1;i<=len;i++) {
			map.put(i,0);
		}
		int result[] = new int[2];
		for(int j=0;j<len;j++) {
			if(map.containsKey(arr[j])) {
				int x = map.get(arr[j]);
				x+=1;
				map.put(arr[j],x);
				if(x==2) {
					result[0]=arr[j];
				}
			}
		}
		for(int i=1;i<=len;i++) {
			int y = map.get(i);
			if(y==0) {
				result[1]=i;
				break;
			}
		}
		System.out.println(result[0]+" "+result[1]);
	}
	public static void main(String[] args) {
		FindMissing findMissing = new FindMissing();
		int arr[]= {1,2,3,4,4,6};
		findMissing.findMissAndRepeat(arr);
	}
}
