package practice.tree;

import java.util.Arrays;

public class MaxHeap {

	int capacity =10;
	int size=0;
	int items[] = new int[capacity];
	
	public int getLeftChildIndex(int index) {
		return (2*index)+1;
	}
	public int getRightChildIndex(int index) {
		return (2*index)+2;
	}
	public int getParentIndex(int index) {
		return (index-1)/2;
	}
	
	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}
	
	public int getLeftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	public int getRightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	public int getParent(int index) {
		return items[getParentIndex(index)];
	}
	
	public void ensureCapacity() {
		if(size==capacity) {
			items = Arrays.copyOf(items, capacity*2);
			capacity*=2;
		}
	}
	public void add(int value) {
		ensureCapacity();
		items[size] = value;
		size++;
		heapifyUp();
	}
	public int peek() {
		if(size==0) throw new IllegalStateException();
		return items[0];
	}
	public int poll() {
		if(size==0) throw new IllegalStateException();
		int index = size-1;
		int result = items[0];
		items[0] = items[index];
		size--;
		heapifyDown();
		return result;
	}
	public void swap(int index1,int index2) {
		int temp = items[index1];
		items[index1]=items[index2];
		items[index2] = temp;
	}
	public void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && getParent(index)<items[index]) {
			swap(getParentIndex(index),index);
			index = getParentIndex(index);
		}
	}
	public void heapifyDown() {
		int index=0;
		while(hasLeftChild(index)) {
			int biggerChildIndex = getLeftChildIndex(index);
			if(hasRightChild(index) && getRightChild(index)>getLeftChild(index)) {
				biggerChildIndex = getRightChild(index);
			}
			
			if(items[index]<items[biggerChildIndex]) {
				swap(index,biggerChildIndex);
			}else {
				return;
			}
			index = biggerChildIndex;
		}
	}
	public static void main(String[] args) {
		MaxHeap maxHeap = new MaxHeap();
		maxHeap.add(10);
		maxHeap.add(15);
		maxHeap.add(5);
		maxHeap.add(1000);
		System.out.println(maxHeap.peek());
		maxHeap.poll();
		System.out.println("afetr poll");
		System.out.println(maxHeap.peek());
	}
}
