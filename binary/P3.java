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

// Node distance C in binary tree

 

public class Solution {
    
    HashMap<TreeNode, ArrayList<TreeNode>> map;
    
    
    public ArrayList<Integer> solve(TreeNode A, int B, int C) {
        
        ArrayList<Integer> ans = new ArrayList();
        if(A==null || C<0) return ans;
        
        TreeNode node = find(A,B); 
        if(node == null) return ans;
    
        map = new HashMap<>();
        buildgraph(A, null);
    
        HashSet<TreeNode> set = new HashSet<>();
        LinkedList<TreeNode> q = new LinkedList();
        q.add(node);
        set.add(node);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            if(C == 0){
                
                for(int i=0;i<size;i++){
                    
                    ans.add(q.pollFirst().val);
                    
                }
                
                return ans;
            }
                
             for(int i=0;i<size;i++){
                 
                 TreeNode n = q.pollFirst();
                 
                 for(TreeNode tn : map.get(n)){
                     
                     if(set.contains(tn)) continue;
                     set.add(tn);
                     q.add(tn);
                     
                 }
                 
             }   
                
            
            C--;
            
        }
        
        
        
        
        return ans;
    }
    
    
    public void buildgraph(TreeNode node, TreeNode parent){
        
        if(node == null) return;       
        
        if(!map.containsKey(node)){
            
             map.put(node, new ArrayList<TreeNode>());
             if(parent != null) { map.get(node).add(parent);map.get(parent).add(node); }
             buildgraph(node.left, node);
             buildgraph(node.right, node);
        }
            
    }
    
    
    public TreeNode find(TreeNode root,int val){
        
        if(root == null) return root;
        
        if(root.val == val){
            return root;
        }
        
        TreeNode l = find(root.left, val);
        if(l != null) return l;
        TreeNode r  = find(root.right, val);
        if(r != null) return r;
        return null;
    }
    
    
    
    
    
    
    
    
}
