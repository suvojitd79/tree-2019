//Count Bigger Ancestors	
import java.util.*;
public class P2{


	static class TreeNode{

		int val;
		TreeNode left,right;
		TreeNode(int val){
			this.val = val;
			this.left = this.right = null;
		}

	}

	/*

			 12
		 5       8	
      6    2   1   7   
					-1

	*/
    public static boolean found = false;

    // gives the ancestor
    public static void ances(TreeNode root,TreeNode node,ArrayList<Integer> ans){


    		//edge case
    		if(root == null || node == null) return;

    		if(root.val == node.val){
    			found = true;
    			return;
    		}
    		if(!found) ans.add(root.val);	
			ances(root.left, node,ans);

			if(!found)	ances(root.right, node,ans);

			if(!found) ans.remove(ans.size()-1);
    }  


    public static int count = 0;

    // gives the count of bigger ancestor
    public static void ances(TreeNode root,TreeNode node){


    		//edge case
    		if(root == null || node == null) return;

    		if(root.val == node.val){
    			found = true;
    			return;
    		}
    		if(!found && root.val > node.val) count++;	
			
			ances(root.left, node);

			if(!found)	ances(root.right, node);

			if(!found && root.val > node.val) count--;
    }


    public static void print(TreeNode root){
    	if(root == null) return;
    	System.out.print(root.val + " ");
    	print(root.left);
    	print(root.right);
    }




	public static void main(String[] args){


		found = false;
		TreeNode root = new TreeNode(12);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(-1);


		ArrayList<Integer> ans = new ArrayList();
		ances(root, root.right.right.right);
		System.out.println(count);

	}


} 