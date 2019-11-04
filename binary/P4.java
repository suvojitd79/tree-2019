/*

Given a binary tree. Return all root to leaf paths.

You can return the paths in any order.

Note: A leaf is a node with no children.

For Example

Input 1:
                57
               /  \
              77  76
             / \ 
            21  16
Output 1:
    [   [57, 76]
        [57, 77, 16]
        [57, 77, 21]    ] 

Input 2:
                1
               / \
              2   3
             / \  / \
            4   5 6  7
Output 2:
     [  [1, 2, 4]
        [1, 2, 5]
        [1, 3, 6]
        [1, 3, 7]    ] 
Seen this question in a real interview before

*/


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
    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList();
        if(A == null) return ans;
        ArrayList<Integer> cache = new ArrayList();
        cache.add(A.val);
        helper(A, cache, ans);
        return ans;
        
    }
    
    public void helper(TreeNode root,ArrayList<Integer> cache,ArrayList<ArrayList<Integer>> ans){
        
        
        if(root.left == null && root.right == null){
            ans.add(new ArrayList<>(cache));
            return;
        }
        
        if(root.left != null){
            cache.add(root.left.val);
            helper(root.left,cache,ans);
            cache.remove(cache.size()-1);
        }
        
        if(root.right != null){
            cache.add(root.right.val);
            helper(root.right,cache,ans);
            cache.remove(cache.size()-1);
        }
        
    }
    
    
    
}
