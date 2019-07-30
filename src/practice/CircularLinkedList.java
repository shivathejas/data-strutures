package practice;

//Java program to implement 
//the above approach 
class CircularLinkedList { 
//node 
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
Node head;

/* Function to insert a node 
at the beginning of a Circular 
linked list */
public void push(int newData) { 
	Node newNode = new Node(newData); 
	Node last = new Node(); 
		/* If linked list is not null 
	then set the next of last node */
newNode.next = head;
head = newNode;
	if (last == null) 
	{ 
		last = newNode;
	} 
	last.next = head;	
	System.out.println(last.next.data);
} 

/* Function to print nodes in a 
given Circular linked list */
public void printList() 
{ 
	Node temp = head; 
	while (temp != null) 
	{ 
			System.out.print(temp.data + " "); 
			temp = temp.next; 		 
	} 
	System.out.println();
} 

//Driver Code 
public static void main(String args[]) 
{ 
	/* Initialize lists as empty */
CircularLinkedList cll = new CircularLinkedList();
	/* Created linked list will 
	be 11.2.56.12 */
	cll.push(12); 
	cll.push(56); 
	cll.push(2); 
	cll.push(11); 

	System.out.println("Contents of Circular " + 
								"Linked List:"); 
	cll.printList(); 
} 
} 

