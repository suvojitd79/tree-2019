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
    
    public int solve(TreeNode A, TreeNode B) {
        
        int sum = 0;
        
        LinkedList<TreeNode> stack1= new LinkedList(), stack2 = new LinkedList();
        
        while(true) {
            
            while(A != null){
                stack1.add(A);
                A = A.left;
            }
            
            
            while(B != null){
                stack2.add(B);
                B = B.left;
            }
            
            if(!stack1.isEmpty()  && !stack2.isEmpty()){
                
                TreeNode n1 = stack1.peekLast();
                TreeNode n2 = stack2.peekLast();       
                
                if(n1.val == n2.val) {
                    
                    sum += n1.val;
                    stack1.pollLast();
                    stack2.pollLast();
                 
                    A = n1.right;
                    B = n2.right;
                }
                else if(n1.val < n2.val){
                    stack1.pollLast();
                    A = n1.right;
                }
                else{
                    stack2.pollLast();
                    B = n2.right;
                }
                
            }
            else break;
        }    
        
        return sum;
    }
    
}
