/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    
    TreeNode first,last,previous;
    
    public ArrayList<Integer> recoverTree(TreeNode A) {
        
        first = last = previous = null;
        inorder(A);
        return new ArrayList<>(Arrays.asList(last.val,first.val));
        
    }
    
    public void inorder(TreeNode root){
        
        if(root == null) return;
        
        inorder(root.left);
        
        if(previous != null){
            
            if(previous.val > root.val){
                
                if(first == null){
                    
                    first = previous;    
                    
                }
                last = root;
            }
        }
        
        previous = root;
        
        inorder(root.right);
    }
    
    
}
