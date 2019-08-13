package practice;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Queue<T> {

	static class Node<T>{
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
	
	Node<T> first;
	Node<T> last;
	public void add(T newData) {
		Node<T> newNode = new Node(newData);
		if(last!=null) {
			last.next = newNode;			
		}
		last = newNode;
		if(first == null) {
			first = last;
		}
	}
	public T remove() {
		if(first == null) throw new NoSuchElementException();
		T result = first.data;
		first = first.next;
		return result;
	}
	public boolean isEmpty() {
		return first == null;
	}
	public T peek() {
		return first.data;
	}
	public static void main(String[] args) {
		Queue<String> qu = new Queue<String>();
		qu.add("aa");
		qu.add("bb");
		qu.add("cc");
		qu.add("dd");
		
		System.out.println(qu.remove());
		System.out.println(qu.remove());
		System.out.println(qu.remove());
		
		
	}
}
