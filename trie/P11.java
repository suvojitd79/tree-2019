class Solution {
    
    public int findMaximumXOR(int[] nums) {
        
        int mask = 0;
        int ans = 0;
        
        for(int i=31;i>=0;i--){
            
            mask |= (1 << i);    
            
            Set<Integer> set = new HashSet();
            
            for(int x: nums){
                
                set.add(x & mask);
                
            }
            
            int predict = ans | (1 << i);
            
            for(Integer x: set){
                
                if(set.contains(x ^ predict)){
                    
                    ans = predict;
                    break;
                }
                
            }
            
        }
        
        
        return ans;
    }
    
}