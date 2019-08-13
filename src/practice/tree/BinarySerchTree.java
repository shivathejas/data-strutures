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
	}
	Node root;

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
		boolean result=false;
		if(root==null) {
			result=false;
		}else if(value<root.data){
			result= containsRecursive(root.left, value);
		}else if(value>root.data) {
			result= containsRecursive(root.right, value);
		}else {
			result=true;
		}
		return result;
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
			root.right = deleterecursive(root.right, root.data);
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
	public int BSTMaxValue() {
		return BSTMaxvalueRecursive(root);
	}
	public int BSTMaxvalueRecursive(Node root) {
		//int result=0;
		if(root.right!=null) {
			return BSTMaxvalueRecursive(root.right);
		}else {
			return root.data;
		}
		//return result;
	}
//	returns size of tree
	/*size(tree)
		1. If tree is empty then return 0
		2. Else
		     (a) Get the size of left subtree recursively  i.e., call 
		          size( tree->left-subtree)
		     (a) Get the size of right subtree recursively  i.e., call 
		          size( tree->right-subtree)
		     (c) Calculate size of the tree as following:
		            tree_size  =  size(left-subtree) + size(right-
		                               subtree) + 1
		     (d) Return tree_size
	*/
	public int size() {
		return sizeRecursive(root);
	}
	public int sizeRecursive(Node root) {
		if(root==null) {
			return 0;
		}
		else {
			return (sizeRecursive(root.left)+1+sizeRecursive(root.right));
		}
	}
//	returns height of a node
	/*Height of a binary tree can be identified by checking the height of root node or depth of the deepest node
	*/	public int maxDepth(Node root) {
		if(root==null) {
			return 0;
		}else {
			int lDepth = maxDepth(root.left);
			int rDepth = maxDepth(root.right);
			
			if(lDepth>rDepth) {
				return lDepth+1;
			}else {
				return rDepth+1;
			}
		}
	}

	/*getLeafCount(node)
		1) If node is NULL then return 0.
		2) Else If left and right child nodes are NULL return 1.
		3) Else recursively calculate leaf count of the tree using below formula.
		    Leaf count of a tree = Leaf count of left subtree + 
		                                 Leaf count of right subtree
	*/
	public int getLeafNodes() {
		return getLeafNodesRecursive(root);
	}
	private int getLeafNodesRecursive(Node root) {
		int result=0;
		if(root == null) {
			result=0;
		}else if( root.left ==null && root.right==null) {
			result=1;
		}else {
			result=getLeafNodesRecursive(root.left)+getLeafNodesRecursive(root.right);
		}
		return result;
	}
	public void isBinarySearchTree(Node root) {
		if(root != null) {
			if(root.data <= root.left.data) {
				isBinarySearchTree(root.left);
			}
		}
		if(root != null) {
			if(root.data>root.right.data) {
				isBinarySearchTree(root.right);
			}
		}
				
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
		  System.out.println("size of a tree is: "+binarySerchTree.size());
		  System.out.println("max depth: "+binarySerchTree.maxDepth(binarySerchTree.root.left));
		  System.out.println("number of leaf nodes are: "+binarySerchTree.getLeafNodes());
		  System.out.println("inorder traversel"); 
		  binarySerchTree.inOrder();
		  binarySerchTree.delete(5);
		  System.out.println("inorder traversel after delete"); 
		  binarySerchTree.inOrder();		  
		  System.out.println(binarySerchTree.contains(225));
		  System.out.println("max value: "+binarySerchTree.BSTMaxValue());
		 
		
	}
}
