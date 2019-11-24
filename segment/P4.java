public class Solution {
    
    int[] arr;
    int[] tree;
    public int[] solve(String A, int[][] B) {
    
        int n1 = (int) Math.ceil(Math.log(A.length())/Math.log(2)); 
        int n = 2 * (int) Math.pow(2, n1) - 1;
        
        tree = new int[n];
        arr = new int[A.length()];   
        build(A, 0, 0, arr.length-1);
        
        
        List<Integer> ans = new ArrayList();
        for(int[] x: B){
            
            if(x[0] == 1){
                
                update(0, 0, A.length()-1, x[1]-1,x[1]-1);
                ans.add(-1);
                
            }else{
                
                ans.add(find(0, 0, A.length()-1, x[1]-1, x[2]-1));
                
            }
            
        }
        
        int[] a = new int[ans.size()];
        int i = 0;
        for(Integer x: ans)
            a[i++] = x;
        return a;
    }
    
    
    public void build(String A, int pos, int start, int end){
    
        if(start == end){
            arr[start] = A.charAt(start) - '0';
            tree[pos] = arr[start];
            return;
        }
        
        int mid = start + (end - start)/2;
        
        build(A, pos * 2 + 1, start, mid);
        build(A, pos * 2 + 2, mid+1, end);
        if((end-mid)%2 == 0){
            tree[pos] = (tree[pos*2+1] + tree[pos*2+2]) % 3;
        }else{
            tree[pos] = (2 * tree[pos*2+1] + tree[pos*2+2]) % 3;
        }
        
    }
    
    
    public void update(int pos,int start,int end, int left, int right){
        
        if(start == end) {
            tree[pos] = 1;
            return;
        }
        
        int mid = start + (end - start)/2;
        
        if(left <= mid)
            update(pos * 2 + 1, start, mid, left, right);
        else update(pos * 2 + 2, mid+1, end, left, right);
        
        if((end-mid)%2 == 0 ){
            tree[pos] = (tree[pos*2+1] + tree[pos*2+2]) % 3;
        }else{
            tree[pos] = (2 * tree[pos*2+1] + tree[pos*2+2]) % 3;
        }
        
    }
    
    
    public int find(int pos,int start,int end, int left, int right){
        
        if(start == end) return tree[pos];
        
        if(start == left && end == right) return tree[pos];
    
        int mid = start + (end - start)/2;
        
        if(left <= mid && right <= mid)
            return find(pos * 2 + 1, start, mid, left, right);
        else if(left <= mid && right > mid){
            
            int l =  find(pos * 2 + 1, start, mid, left, mid);
            int r = find(pos * 2 + 2, mid+1,end, mid+1, right);
            
            if((right-mid)%2 == 0 ){
                return  (l + r) % 3;
            }else{
                return (2 * l + r) % 3;
            }
        
        }else
            return find(pos * 2 + 2, mid+1, end, left, right);
        
    }
    

    
    
    
}
