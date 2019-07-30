package practice;

import java.util.EmptyStackException;

public class Stack<T> {

	static class Node<T>{
		T data;
		Node<T> next;
		Node(T data){
			this.data = data;
		}
	}
		
		Node<T> top;
		public void push(T newData) {
			Node newNode = new Node(newData);
			newNode.next = top;
			top = newNode;
		}
		public T pop() {
			T result = top.data;
			top = top.next;
			return result;
		}
		public boolean isEmpty() {
			return top == null;
		}
		public T peek() {
			if(top == null) throw new EmptyStackException();
			return top.data;
		}
		public void display() {
		}
		public Queue<T> toQueue(){
			Queue<T> qu = new Queue<>();
			Stack<T> st1 = new Stack<>();
			Stack<T> st2 = new Stack<>();
			Node<T> n1 = top;
			
			return qu;
		}
		public static void main(String[] args) {
			Stack<String> st = new Stack<>();
			st.push("aaaaa");
			st.push("bb");
			st.push("cc");
			st.push("dd");
			System.out.println(st.top.data);
			st.pop();
			st.pop();
			System.out.println(st.top.data);
		}
	
}
