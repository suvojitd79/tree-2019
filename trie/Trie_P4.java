/*
	
	Convert an arbitrary Binary Tree to a tree that holds Children Sum Property

		X
	Lc 		Rc
	
	=> X = Lc + Rc (recursively true)

*/

import java.util.*;

class Node  
		{ 
	    int data; 
	    Node left, right; 
	   
	    Node(int item)  
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 


public class Trie_P4{



	public void buildTree(Node root){

		int left = 0, right = 0 ,diff = 0;

		if(root == null || (root.left == null && root.right == null)) return;	
		
		else{

			buildTree(root.left);
			buildTree(root.right);

			if(root.left != null)
				left = root.left.data;
			if(root.right != null)
				right = root.right.data;
			
			diff = left + right - root.data;


			if(diff > 0) root.data += diff;

			if(diff < 0) increment(root, -diff);

		}

	}


	public void increment(Node root, int val){

		if(root.left != null){

			root.left.data += val;
			increment(root.left, val);
		}
		else if(root.right != null){
			root.right.data += val;	
			increment(root.right, val);
		}

	}


	public void solve(Node root){

		buildTree(root);

	}

	public void print(Node root){
		if(root == null) return;
		print(root.left);
		System.out.print(root.data+"  ");
		print(root.right);
	}

	private Node root; // <---- root


	public static void main(String[] args){


		Trie_P4 tree = new Trie_P4(); 
        tree.root = new Node(50); 
        tree.root.left = new Node(7); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.left = new Node(1); 
        tree.root.right.right = new Node(30); 



        tree.print(tree.root);
        tree.solve(tree.root);
        System.out.println();
		tree.print(tree.root);
	}


}
