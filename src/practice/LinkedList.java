package practice;

public class LinkedList {
	
	static Node head;
	
	static class Node {
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
	}

	
	  public int nodeCount(){ 
		  Node n = head; 
		  int count=0; 
		  while(n != null) {
			  count++;
			  n=n.next;
	  } 
		  return count; 
	}
	 public int nodeCountRec(Node node) {
		 if(node == null) {
			 return 0;
		 }
		 return 1+nodeCountRec(node.next);
	 }
	public void printList() 
	{ 
		Node n = head; 
		while (n != null) 
		{ 
			System.out.print(n.data+" "); 
			n = n.next; 
		} 
		System.out.println();
	} 
//	this method will insert node at the beginning of linked list
	public void push(int newData) {
		Node newNode = new Node(newData);
		newNode.next = head;
		head = newNode;
	}
//	this method will insert node after the specified previous node
	public void insertNode(Node prevNode,int newData) {
		Node newNode = new Node(newData);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}
//	this method append node t the end of the linked list
	public void appendNode(int newData) {
		Node newNode = new Node(newData);
		  if(head == null) {
			  head = new Node(newData);
			  return; 
			  }		 
		Node last = head;
		while(last.next != null) 
		{
			last = last.next;
		}
			last.next = newNode;
			newNode.next = null;		
	}
//	method will delete the specified key
	public void deleteNode(int key) {
		Node temp = head;
		Node prev = new Node();
		while(temp != null && temp.data == key) {
			head = temp.next;
			return;
		}
		while(temp != null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;
		return;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lList = new LinkedList();
		/*
		 * lList.head = new Node(1); Node second = new Node(2); Node third = new
		 * Node(3); lList.head.next = second; second.next = third;
		 */
		lList.push(1);
		lList.push(2);
		lList.push(3);
		lList.push(4);
		System.out.println("data in linked list");
		lList.printList();
		System.out.println("length of list "+lList.nodeCount());
		lList.insertNode(lList.head.next,6);
		System.out.println("data in linked list");
		lList.printList();
		lList.appendNode(0);
		System.out.println("data in linked list");
		lList.printList();
		System.out.println("count of list nodes");
		System.out.println(lList.nodeCount());
		System.out.println(lList.nodeCountRec(head));
		System.out.println("after deleting key ");
		lList.deleteNode(6);
		System.out.println("data in linked list");
		lList.printList();

	}
	
}
