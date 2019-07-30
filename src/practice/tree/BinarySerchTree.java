package practice.tree;

public class BinarySerchTree {
	static class Node{
		int data;
		Node left,right;
		public Node() {
			
		}
		public Node(int data) {
			this.data=data;
		}
		/*
		 * public void insert(int value) { if(value<=data) { if(left==null) { left = new
		 * Node(value); }else { left.insert(value); } }else { if(right==null) {
		 * right=new Node(value); }else { right.insert(value); } } } public void
		 * inOrder() { if(left!=null) { left.inOrder(); } System.out.print(data+" ");
		 * if(right!=null) { right.inOrder(); } }
		 */
	}
	Node root;

	/*
	 * public void insert(int value) { root = insertRecursive(root, value); } public
	 * Node insertRecursive(Node root,int value) { if(root==null) { root=new
	 * Node(value); return root; } if(value<=root.data) {
	 * root.left=insertRecursive(root.left, value); } else if(value>root.data){
	 * root.right=insertRecursive(root.right, value); } return root; }
	 */
	public void insert(int value) {
		root = insertRecursive(root,value);
	}
	public Node insertRecursive(Node root, int value) {
		if(root==null) {
			root = new Node(value);
			return root;
		}
		if(value<=root.data) {
			root.left= insertRecursive(root.left, value);
		}else {
			root.right=insertRecursive(root.right, value);
		}
		return root;
	}
	public void inOrder() {
		inOrder(root);
	}
	public void inOrder(Node root) {
		if(root.left!=null) {
			inOrder(root.left);
		}
		System.out.print(root.data+" ");
		if(root.right!=null) {
			inOrder(root.right);
		}
	}
	public boolean contains(int value) {
		return containsRecursive(root, value);
	}
	public boolean containsRecursive(Node root,int value) {
		if(root.data==value) {
			return true;
		}else if(root.data<=value){
			return containsRecursive(root.left, value);
		}else {
			return containsRecursive(root.right, value);
		}	
	}
	public void delete(int value) {
		root = deleterecursive(root, value);
	}
	public Node deleterecursive(Node root,int value) {
		if(root==null) {
			return root;
		}else if(value<root.data){
			root.left = deleterecursive(root.left, value);
		}else if(value>root.data){
			root.right = deleterecursive(root.right, value);
		}else {
			
			if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
				return root.left;
			}
			
			root.data = minValue(root.right);
			root.right = deleterecursive(root.right, value);
		}
		return root;
	}
	public int minValue(Node root) {
		int minv = root.data;
		while(root.left!=null) {
			minv=root.left.data;
			root=root.left;
		}
		return minv;
	}
	public static void main(String[] args) {
		BinarySerchTree binarySerchTree = new BinarySerchTree();
		
		  Node node=new Node();
		  binarySerchTree.insert(10); 
		  binarySerchTree.insert(5); 
		  binarySerchTree.insert(15);
		  binarySerchTree.insert(25); 
		  binarySerchTree.insert(12); 
		  binarySerchTree.insert(8); 
		  binarySerchTree.insert(2);
		  binarySerchTree.insert(1);
		  System.out.println("inorder traversel"); 
		  binarySerchTree.inOrder();
		  binarySerchTree.delete(5);
		  System.out.println("inorder traversel after delete"); 
		  binarySerchTree.inOrder();
		  
		//  System.out.println(binarySerchTree.contains(25));
		 
		
	}
}
