package practice;

import java.util.LinkedList;
import java.util.List;

public class DoubleLinkedList {

	static class Node{
		int data;
		Node next;
		Node prev;
		Node(){
			
		}
		Node(int data){
			this.data = data;
		}
	}
	
	Node head;
	
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		newNode.prev = null;
		if(head != null) {
			head.prev = newNode;
		}
		head = newNode;
		
	}
	public int length() {
		Node temp = head;
		int count=0;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public boolean isPalindrome() {
		boolean result=false;
		Node last = head;
		Node first = head;
		while(last != null && last.next != null) {
			last = last.next;
		}
		while(first != null && last != null) {
			if(first.data == last.data) {
				first = first.next;
				last =last.prev;
				result = true;
			}else {
				result =false;
				break;
			}
		}
		return result;
	}
//	insert afternode which is having value equals k
	public void insertAfter(int k,int newData) {
		Node newNode = new Node(newData);
		Node kNode = head;
		while(kNode.data != k) {
			kNode = kNode.next;
		}
		newNode.next = kNode.next;
		kNode.next = newNode;
		newNode.prev = kNode;
		if(newNode.next != null) {
			newNode.next.prev = newNode;
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.push(1);
		dll.push(2);
		dll.push(3);
		dll.push(4);
		dll.push(5);
		System.out.println("dll");
		dll.display();
		System.out.println("double linked list length: "+dll.length());
		System.out.println("dll is palindrome or not:- "+ dll.isPalindrome());
		System.out.println("after inserting node after k value node");
		dll.insertAfter(3, 100);
		dll.display();
	}

}
