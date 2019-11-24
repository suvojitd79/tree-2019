public class Solution {
    

    // O(N^2)

    class Data{
        int bigger,smaller;
        Data(int b,int s){
            this.bigger = b;
            this.smaller = s;
        }
    }
    
    public Data getData(List<Integer> A, int x){
        
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(Integer x1: A){
            
            if(x1 > x) {
                max = x;
                break;
            }
        }
        
        
        for(Integer x1: A){
            
            if(x > x1) {
                min = x1;
                break;
            }
        }
        
        return new Data(max,min);
    }
    
    public String solve(ArrayList<Integer> A) {
        
        for(int i=0;i<A.size()-2;i++){
            
            Data data = getData(A.subList(i+1,A.size()), A.get(i));    
            if(data.bigger != Integer.MIN_VALUE && data.smaller != Integer.MAX_VALUE)
                return "NO";
        }
        
        return "YES";
    }
    



    // O(N)
    public String solve(ArrayList<Integer> A) {
        
        if(A.size() <= 2) return "YES";
        
        int bigger,smaller;
        
        int n = A.size();
        
        if(A.get(n-1) > A.get(n-2)) {
            bigger = A.get(n-1);
            smaller = A.get(n-2);
        }else{
            bigger = A.get(n-2);
            smaller = A.get(n-1);
        }
        
        for(int i=n-3;i>=0;i--){
            if(A.get(i) > bigger) bigger = A.get(i);
            else if(A.get(i) < smaller) smaller = A.get(i);
            else return "NO";
        }
        return "YES";
    }

    
    
}
