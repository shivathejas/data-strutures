package practice.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class SelectionSort {

	public void sort(int arr[]) {
		int n=arr.length;
		int minIndex,temp;
		System.out.println("before sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		for(int i=0;i<n;i++) {
			minIndex = i;
			for(int j=i;j<n;j++) {
				if(arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
		System.out.println("after sort");
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		int arr[] = {5,9,3,1,2,8,4,7,6};
		selectionSort.sort(arr);
	 } 
}
