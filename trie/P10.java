public class Solution {
    
    class TrieNode{
        TrieNode left,right;
        int count;
        TrieNode(){
            this.left = this.right = null;
            this.count = 0;
        }
    }
    
    public void insert(TrieNode root, int num, int bits){
        
        if(bits < 0) return;
        
        int b = num& (1 << bits);
        
        if(b == 0){
            
            if(root.left == null) {
                root.left = new TrieNode();
            }
            insert(root.left, num, bits-1);    
            root.left.count++;
            
        }else{
            
            if(root.right == null) {
                root.right = new TrieNode();
            }
            insert(root.right, num, bits-1);    
            root.right.count++;
        }
        
    }
    

    
    
    
    public long search(TrieNode root, int num,int bits, int k){
        
        if(bits < 0) return 0;
        
        int n1 = num & (1 << bits);
        int k1 = k & (1 << bits);
        
        long ans = 0;
        
        if(k1!=0){
            
            if(n1!=0){
                
                if(root.right != null) ans += root.right.count;
                if(root.left != null) ans += search(root.left, num, bits-1, k);
                
            }else{
                
                if(root.left != null) ans += root.left.count;
                if(root.right != null) ans += search(root.right, num, bits-1, k);
                
            }
            
        }else{
            
            if(n1!=0){
                
                if(root.right != null) ans += search(root.right, num, bits-1, k);
                
            }else{
                
                if(root.left != null) ans += search(root.left, num, bits-1, k);
                
            }
            
        }
        
        return ans;
    }
    
    
    
    
    
    public int solve(ArrayList<Integer> A, int B) {
        
        TrieNode root = new TrieNode();
        int mod = 1000000007;    
        long ans = 0;
        
        int k = 0;
        
        insert(root, 0, 31);
        
        for(Integer x: A){
            k ^= x;
            ans += search(root, k, 31, B);
            ans %= mod;
            insert(root, k, 31);
            
        }
        
        return (int)(ans % mod);
        
    }
    
    
}
