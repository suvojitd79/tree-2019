// O(n^2) solution

public class Solution {
    
    class Box{
        
        int s,e,h;
        Box(int s,int e,int h){
            this.s = s;
            this.e = e;
            this.h = h;
        }
        
    }
    
    List<Box> list;
        
    public ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {
         
        int max = 0; 
        list = new ArrayList();     
        ArrayList<Integer> ans = new ArrayList();
        for(ArrayList<Integer> box : A){
            
            Box b = new Box(box.get(0),box.get(0)+box.get(1)-1,box.get(1));
            int h = max(b);
            max = Math.max(max, h);
            ans.add(max);
        } 
         
        return ans; 
            
    }
        
    
    public int max(Box b){
        
        int h = 0;
        for(Box box: list){
            
            if(box.s > b.e || box.e < b.s) continue;
            
            h = Math.max(h, box.h);
        }
        
        b.h += h;
        
        list.add(b);
        
        return b.h;
    }
    
}
