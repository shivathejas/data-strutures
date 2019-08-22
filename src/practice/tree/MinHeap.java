package practice.tree;

import practice.problem.Arrays;

public class MinHeap {

	int capacity = 10;
	int size=0;
	int items[] = new int[capacity];
	
	public int getLeftChildIndex(int parentIndex) {
		return (2*parentIndex)+1;
	}
	public int getRightChildIndex(int parentIndex) {
		return (2*parentIndex)+2;
	}
	public int getParentIndex(int childIndex) {
		return (childIndex-1)/2;
	}
	
	public boolean hasLeaftChild(int index) {
		return getLeftChildIndex(index) < size;
	}
	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}
	public boolean hasParent(int index) {
		return getParentIndex(index)>=0;
	}
	
	public int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}
	public int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}
	public int parent(int index) {
		return items[getParentIndex(index)];
	}
	
	public void swap(int indexOne,int indexTwo) {
		int temp = items[indexOne];
		items[indexOne] = items[indexTwo];
		items[indexTwo] = temp;
	}
	
	public void ensureArraySize() {
		if(size == capacity) {
			items = java.util.Arrays.copyOf(items, capacity*2);
			capacity*=2;
		}
	}
	
	public int peek() {
		if(size==0) throw new IllegalStateException();
		return items[0];
	}
	public int poll() {
		if(size==0) throw new IllegalStateException();
		int item = items[0];
		items[0] = items[size-1];
		size--;
		heapifyDown();
		System.out.println("heapifyDown");
		return item;
	}
	
	public void add(int item) {
		ensureArraySize();
		items[size]=item;
		size++;
		heapifyUp();
	}
	
	public void heapifyUp() {
		int index = size-1;
		while(hasParent(index) && parent(index)>items[index]) {
				swap(getParentIndex(index),index);
				index = getParentIndex(index);
		}
	}
	
	public void heapifyDown() {
		int index=0;
		while(hasLeaftChild(index)) {
			int smallerChildIndex = getParentIndex(index);
			if(hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}
			
			if(items[index] < items[smallerChildIndex]) {
				break;
			}else {
				swap(index,smallerChildIndex);
			}
			index = smallerChildIndex;
		}
	}
	public static void main(String[] args) {
		MinHeap minHeap = new  MinHeap();
		minHeap.add(100);
		minHeap.add(15);
		minHeap.add(20);
		minHeap.add(17);
		minHeap.add(25);
		//System.out.println(minHeap.peek());
		minHeap.poll();
		System.out.println(minHeap.peek());
	}
}
