package practice.tree;

public class BSTPratice {

	class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
	}
	Node root;
	public void insert(int value) {
		root = insertRecursive(root, value);
	}
	public Node insertRecursive(Node root,int value) {
		if(root==null) {
			root = new Node(value);
			return root;
		}
		if(value<=root.data) {
			root.left = insertRecursive(root.left, value);
		}else {
			root.right = insertRecursive(root.right, value);
		}
		return root;
	}
	public void inorder() {
		inorderRecursive(root);
	}
	public void inorderRecursive(Node root) {
		if(root.left != null) {
			inorderRecursive(root.left);
		}
		System.out.print(root.data+" ");
		if(root.right!= null) {
			inorderRecursive(root.right);
		}
		
	}
	public boolean contains(int value) {
		boolean result = containsRecursive(root, value);
		return result;
	}
	public boolean containsRecursive(Node root,int value) {
		boolean result=false;
		if(root==null) {
			result=false;
		}else if(value<root.data) {
			result = containsRecursive(root.left, value);
		}else if(value>root.data) {
			result = containsRecursive(root.right, value);
		}else {
			result  =true;
		}
		return result;
	}
	public void delete(int value) {
		root  =deleteRecursive(root, value);
	}
	public Node deleteRecursive(Node root,int value) {
		if(root==null) {
			return root;
		}else if(value<root.data) {
			root.left  = deleteRecursive(root.left, value);
		}else if(value>root.data) {
			root.right = deleteRecursive(root.right, value);
		}else {
			if(root.left==null) {
				return root.right;
			}else if(root.right==null) {
				return root.left;
			}
			
			root.data = minValue(root.right);
			root.right=deleteRecursive(root.right, root.data);
		}
		return root;
	}
	public int minValue(Node root) {
		int minV = root.data;
		while(root.left!=null) {
			minV = root.left.data;
			root=root.left;
		}
		return minV;
	}
	public int max() {
		return maxRecursive(root);
	}
	public int maxRecursive(Node root) {
		int result=0;
		if(root.right!=null) {
			result = maxRecursive(root.right);
		}else {
			result = root.data;
		}
		return result;
	}
	public static void main(String[] args) {
		BSTPratice bstPratice = new BSTPratice();
		bstPratice.insert(10);
		bstPratice.insert(5);
		bstPratice.insert(2);
		bstPratice.insert(25);
		bstPratice.insert(7);
		bstPratice.inorder();
		System.out.println();
		System.out.println("conatins? "+bstPratice.contains(25));
		//bstPratice.delete(10);
		//bstPratice.inorder();
		System.out.println("max value in tree is: "+bstPratice.max());
	}
}
