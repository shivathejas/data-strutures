package practice.tree;

import practice.tree.BinarySerchTree.Node;

public class BSTPratice {

	Node root;
	public void insert(int value) {
		root = insertRecursive(root,value);
	}
	public Node insertRecursive(Node root,int value) {
		if(root == null) {
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
		return containsRecursive(root,value);
	}
	public boolean containsRecursive(Node root,int value) {
		boolean result=false;
		if(root== null) {
			return false;
		}else if(value<root.data) {
			result = containsRecursive(root.left, value);
		}else if(value>root.data) {
			result = containsRecursive(root.right, value);
		}else {
			result=true;
		}
		return result;
	}
	public void delete(int value) {
		root = deleteRecursive(root,value);
	}
	public Node deleteRecursive(Node root,int value) {
		if(root == null) {
			return root;
		}else if(value<root.data) {
			root.left = deleteRecursive(root.left, value);
		}else if(value > root.data) {
			root.right  =deleteRecursive(root.right, value);
		}else {
			if(root.left==null) {
				return root.right;
			}
			if(root.right == null) {
				return root.left;
			}
			
			root.data = minValue(root.right);
			root.right = deleteRecursive(root.right, root.data);
		}
		return root;
	}
	public int minValue(Node root) {
		int minV = root.data;
		while(root.left!=null) {
			minV = root.data;
			root = root.left;
		}
		return minV;
	}
	public int max() {
		return maxRecursive(root);
	}
	public int maxRecursive(Node root) {
		if(root.right!=null) {
			return maxRecursive(root.right);
		}else {
			return root.data;
		}
	}
	public int size() {
		return sizeRecursive(root) ;
	}
	public int sizeRecursive(Node root) {
		if(root !=null) {
			return sizeRecursive(root.left)+1+sizeRecursive(root.right);
		}else {
			return 0;
		}
	}
	public int maxDepth() {
		return maxDepthRecursive(root);
	}
	public int maxDepthRecursive(Node root) {
		if(root == null) {
			return 0;
		}else {
			int lDepth = maxDepthRecursive(root.left);
			int rDepth = maxDepthRecursive(root.right);
			if(lDepth>rDepth) {
				return lDepth+1;
			}else {
				return rDepth+1;
			}
			
		}
	}
	public static void main(String[] args) {
		BSTPratice bstPratice = new BSTPratice();
		bstPratice.insert(10);
		bstPratice.insert(5);
		bstPratice.insert(2);
		bstPratice.insert(25);
		bstPratice.insert(7);
		bstPratice.insert(29995);

		bstPratice.inOrder();
		System.out.println();
		System.out.println("conatins? "+bstPratice.contains(25555));
		bstPratice.delete(10);
		bstPratice.inOrder();
		System.out.println("max value in tree is: "+bstPratice.max());
		System.out.println("size of a tree "+bstPratice.size());
		System.out.println("max depth or height of the tree is "+bstPratice.maxDepth());
	}
}
