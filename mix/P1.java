public class Solution {
    
    class TrieNode{
        
        HashMap<Character,TrieNode> children;
        boolean isend;
        TrieNode(){
            this.children = new HashMap();
            this.isend = false;
        }
    }
    
    class Point{
        
        int index,rank;
        Point(int index,int rank){
            this.index = index;
            this.rank = rank;
        }
        
        public void setRank(int rank){
            
            this.rank = rank;
            
        }
        
        
    }
    
    private TrieNode root; // pointer to the root
    
    public void buildTrie(ArrayList<String> data){
        
        
        for(String s:data){
            
            TrieNode r = root;
            
            for(int j=0;j<s.length();j++){
                
                Character c = s.charAt(j);
                
                if(r.children.containsKey(c)){
                    
                    r = r.children.get(c);
                    
                }else{
                    
                    TrieNode n = new TrieNode();   
                    r.children.put(c, n);
                    r = n;
                    
                }
                
            }
            
            r.isend = true; // end of the word
        }
        
    }
    
    
    public boolean findWord(String word){
        
        TrieNode r = root;
        
        for(int i=0;i<word.length();i++){
            
            Character c = word.charAt(i);
            
            if(!r.children.containsKey(c)) return false;
            
            r = r.children.get(c);
            
        }
        
        return r.isend;
        
    }
    
    
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        
        root = new TrieNode();  
        ArrayList<Point> cache = new ArrayList();
        for(int i=0;i<B.size();i++) cache.add(new Point(i, 0));
        
        buildTrie(new ArrayList<>(Arrays.asList(A.split("_",-1))));
        
        for(int i=0;i<B.size();i++){
            
            
            int rank = 0;
            
            for(String word: B.get(i).split("_",-1)){
                
                
                rank += findWord(word) ? 1 : 0;
                
                
            }
            
            cache.get(i).setRank(rank);
            
        }
        
        Collections.sort(cache, new Comparator<Point>(){
            
            @Override    
            public int compare(Point x,Point y){
                
                return y.rank - x.rank;
                
            }
            
        });
        
        
        ArrayList<Integer> ans = new ArrayList();
        
        for(Point p:cache) ans.add(p.index);
        
        
        return ans;
    }
    
}
