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
    public int t2Sum(TreeNode A, int B) {
        
        LinkedList<TreeNode> stack1 = new LinkedList();
        LinkedList<TreeNode> stack2 = new LinkedList();
        
        
        TreeNode r1 = A;
        TreeNode r2 = A;
        
        int s1 = 0, s2 = 0;
        
        boolean l1 = true , l2 = true;
        
        while(true){
            
            while(l1){
                
                if(r1 != null){
                    stack1.addLast(r1);
                    r1 = r1.left;
                }else{
                    
                    if(stack1.isEmpty()) l1 = false;
                    else{
                        
                        r1 = stack1.pollLast();
                        s1 = r1.val;
                        r1 = r1.right;
                        l1 = false;
                    }
                    
                }
            }    
              
            
              
            while(l2){
                
                if(r2 != null){
                    stack2.addLast(r2);
                    r2 = r2.right;
                }else{
                    
                    if(stack2.isEmpty()) l2 = false;
                    else{
                        
                        r2 = stack2.pollLast();
                        s2 = r2.val;
                        r2 = r2.left;
                        l2 = false;
                    }
                    
                }
            }   
             

            
            if( s1 != s2 && (s1+s2) == B) return 1;
            
            else if(s1 != s2 && (s1+s2) < B) l1 = true;
            
            else if(s1 != s2 && (s1+s2) > B) l2 = true;
                    
            else if(s1 >= s2) return 0;

        }
        
        
    }
    
}
