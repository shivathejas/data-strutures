package practice;

public class Tree {

	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
		public Node() {
			// TODO Auto-generated constructor stub
		}
		public void insert(int value) {
			if(value <= data) {
				if(left == null) {
					left = new Node(value);
				}else {
					left.insert(value);
				}
			}else {
				if(right == null) {
					right = new Node(value);
				}else {
					right.insert(value);
				}
			}
		}
		public boolean contains(int value) {
			if(value == data) {
				return true;
			}else {
				if(value <= data) {
					if(left == null) {
						return false;
					}else {
						return left.contains(value);
					}
				}else {
					if(right == null) {
						return false;
					}else {
						return right.contains(value);
					}
				}
			}
		}
		public void printOrder() {
			if(left != null) {
				left.printOrder();
			}
			System.out.println(data);
			if(right != null) {
				right.printOrder();
			}
		}
	}
	public static void main(String[] args) {
		Tree tree = new Tree();
		Node node = new Node();
		node.insert(10);
		node.insert(5);
		node.insert(15);
		node.insert(8);
		System.out.println(node.contains(15));
		node.printOrder();
	}

}
