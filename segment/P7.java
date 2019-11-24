/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        TreeLinkNode nextLevel = null, pre = null;
        // nextLevel - pointer to the first node of next level
        // pre - pointer to the previously visited node
        while(root != null){
            
            if(pre != null) pre.next = root.left != null ? root.left : root.right;   
            else nextLevel = root.left != null ? root.left : root.right;
            
            if(root.left != null && root.right != null){
                
                root.left.next = root.right;
                pre = root.right;
                
            }else if(root.left != null || root.right != null){
                
                pre = root.left != null? root.left : root.right;
        
            }
            
            if(root.next != null) root = root.next;    
            else {
                root = nextLevel;
                pre = nextLevel = null;
            }
        }
        
    }
    
}
