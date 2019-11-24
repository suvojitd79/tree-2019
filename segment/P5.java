public class Solution {
    
     int[] arr;
     int[] tree;
    
    
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        
        int x = (int) (Math.ceil(Math.log(A) / Math.log(2))); 
        int n = 2 * (int) Math.pow(2, x) - 1; 
        

        arr = new int[A];
        tree = new int[n];
        Arrays.fill(arr, 0);
        Arrays.fill(tree, 0);
       
       ArrayList<Integer> ans = new ArrayList();
       
       for(ArrayList<Integer> q: B){
            
            if(q.get(0) == 1){
                
                int index = q.get(1)-1;
                
                arr[index] += 1;
                
                update1(0, 0, A-1,  index, index);
                
                
            }else if(q.get(0) == 2){
                
                int index = q.get(1)-1;
                
                arr[index] = arr[index]/2;
                
                update2(0, 0, A-1,  index, index);
                
            }else{
                
                ans.add(find(0, 0, A-1, q.get(1)-1, q.get(2)-1));
            
                
            }  
           
           
       }
       
       return ans;
    }
    
    
    
    public int find(int pos,int start,int end, int left, int right){
        
        if(right < start || left > end) 
            return 0;
            
        else if( start >= left && end <= right)
            return tree[pos];
        else {
        int mid = start + (end - start)/2;
        return  find(pos*2 + 1, start, mid, left, right) + find(pos*2 + 2, mid+1, end, left, right);
        }
    }
    
    
    public void update1(int pos,int start,int end, int left, int right){
        
        if(right < start || left > end) 
            return;
            
        if(start >= left &&  end <= right){
            tree[pos] += 1;
            return;
        }
        
        int mid = start + (end - start)/2;
        update1(pos*2+1, start, mid, left, right);
        update1(pos*2+2, mid+1, end, left, right);    
        tree[pos] = tree[pos * 2 + 1] + tree[pos * 2 + 2];
        
        
    }
    
   
    public void update2(int pos,int start,int end, int left, int right){
        
        if(right < start || left > end) 
            return;
        
        if(start >= left &&  end <= right){
            int max = Math.max(0, tree[pos]-1);
            tree[pos] = max;
            return;
        }
        
        int mid = start + (end - start)/2;
        update2(pos*2+1, start, mid, left, right);
        update2(pos*2+2, mid+1, end, left, right);    
        tree[pos] = tree[pos * 2 + 1] + tree[pos * 2 + 2];
    }
}
