package practice;

import java.awt.HeadlessException;
import java.util.HashSet;

public class LinkedListPractice {
	Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
	}
	public int nodeCount() {
		int count=0;
		Node n = head;
		while(n != null) {
			count++;
			n = n.next;
		}
		return count;
	}
	public int nodeCountRec(Node node) {
		if(node == null) {
			return 0;
		}
		return 1+nodeCountRec(node.next);
	}
	public void printNode() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}
//	inserts at the begining of the list
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
//	insert at the end of the list
	public void append(int newData) {
		Node newNode = new Node(newData);
		Node last = head;
		if(head == null) {
			return;
		}
		while(last.next != null) {
			last = last.next;
		}
		last.next = newNode;
		newNode.next= null;
	}
	public void insert(Node node,int newData) {
		Node newNode= new Node(newData);
		newNode.next= node.next;
		node.next = newNode;
	}
//	insert data after given position
	public void insertAfter(int position,int newData) {
		Node temp = head;
		Node newNode = new Node(newData);
		Node prev = new Node();
		int count=0;
		for(int i=0;i<position;i++) {
			temp = temp.next;
		}
		prev = temp;
		newNode.next = prev.next;
		prev.next = newNode;
	}
//	insert data before given position
	public void insertBefore(int position,int newData) {
		Node temp = head;
		Node newNode = new Node(newData);
		Node prev = new Node();
		int count=0;
		for(int i=0;i<position-1;i++) {
			temp = temp.next;
		}
		prev = temp;
		newNode.next = prev.next;
		prev.next = newNode;
	
	}
//	delete key
	public void delete(int key) {
		Node temp = head;
		Node prev = new Node();
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		if(temp == null) {
			return;
		}
		prev.next = temp.next;
	}
//	delete node at given position
	public void deleteNode(int position) {
		Node temp =head;
		Node prev =new Node();
		for(int i=0;i<position;i++) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
	}
//	delete list
	public void deleteList() {
		head=null;
	}
//	serach for key
	public boolean search(int key) {
		boolean result = true;
		Node temp = head;
		while(temp != null && temp.data != key) {
			temp = temp.next;
			result = false;
		}
		if(temp.data == key) {
			result=true;
		}
		return result;
	}
//	get nth node
	public int getNodeValue(int nodeNumber) {
		Node temp = head;
		/*
		 * for(int i=0;i<nodeNumber;i++){ temp = temp.next; } return temp.data;
		 */
		int count=0;
		int result = 0;
		while(temp != null) {
			if(count == nodeNumber) {
				result= temp.data;
				break;
			}
			temp = temp.next;
			count++;
		}
		return result;
	}
//	remove duplicates
	public void removeDuplicates() {
		Node temp1 = head;
		Node temp2 = head.next;
		Node prev = head;
		while(temp1 != null) {
			while(temp2 != null) {
				if(temp1.data == temp2.data) {
					prev.next = temp2.next;
					temp2 = temp2.next;
				}else {
					prev = temp2;
					temp2 = temp2.next;
				}
			}
			temp1 = temp1.next;
			if(temp1 == null) {
				break;
			}
			prev = temp1;
			temp2 = temp1.next;
			
			}
		}
	
//	deletes middle node
	public void deleteMidddle() {
		Node fast = head;
		Node slow = head;
		Node prev = new Node();
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}
		prev.next = slow.next;
		slow=null;
	}
//	method gets kth to last node
	public void getkthToLastNode(int k) {
		Node temp = head;
		for(int i=0;i<k;i++) {
			temp = temp.next;
		}
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}

	/*
	 * addition of 2 numbers which are stored in different linked lists where every
	 * node consists of only one digit number
	 */
	public void sum(LinkedListPractice var1,LinkedListPractice var2) {
		LinkedListPractice result = new LinkedListPractice();
		Node t1 = var1.head;
		Node t2 = var2.head;
		int carry =0;
		while(t1 != null && t2 != null) {
			if(t1.data+t2.data+carry >10) {
				result.push(t1.data+t2.data+carry-10);
				carry =1;
			}else {
				result.push(t1.data+t2.data+carry);
				carry =0;
			}
			t1 = t1.next;
			t2 = t2.next;
		}
		if(t1 == null) {
			while(t2 != null) {
				result.push(t2.data+carry);
				t2 = t2.next;
				carry =0;
			}
		}else {
			while(t1 != null) {
				result.push(t1.data+carry);
				t1 = t1.next;
				carry =0;
			}
		}
		result.printNode();		
	}
//	detect loop
	public boolean detectLoop() {
		Node temp = head;
		boolean result =false;
		HashSet<Node> s = new HashSet<>();
		while(temp != null) {
			if(s.contains(temp)) {
				result = true;
				break;
			}else {
				result = false;
				s.add(temp);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		LinkedListPractice lList = new LinkedListPractice();
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		lList.push(5);
		lList.push(6);
		lList.push(7);
		lList.push(8);
		lList.push(3);
		System.out.println("detect loop");
		if(lList.detectLoop()) {
			System.out.println("it is loop");
		}else {
			System.out.println("it is not loop");
		}
		System.out.println("total number of nodes in list:- "+lList.nodeCount());
		System.out.println("linked list after inserting by push method");
		lList.printNode();
		System.out.println("inseting newData at the end of the list");
		lList.append(110);
		lList.printNode();
		System.out.println();
		System.out.println("insert key at given position");
		lList.insertBefore(2, 10);
		lList.printNode();
		System.out.println("deleting a noe");
		lList.deleteNode(2);
		lList.printNode();
		System.out.println("search result "+ lList.search(2) );
		System.out.println("nth node value "+lList.getNodeValue(1));
		System.out.println("deleting a middle node");
		lList.deleteMidddle();
		lList.printNode();
		//lList.getkthToLastNode(2);
		lList.removeDuplicates();
		System.out.println("after removing duplicates");
		lList.printNode();
		System.out.println("addition of 2 linked lists");
		LinkedListPractice var1List = new LinkedListPractice();
		var1List.push(6);
		var1List.push(1);
		var1List.push(7);
		LinkedListPractice var2List = new LinkedListPractice();
		var2List.push(9);
		var2List.push(5);
		LinkedListPractice var = new LinkedListPractice();
		var.sum(var1List, var2List);
		
	}
}
