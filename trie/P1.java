//Shortest Unique Prefix
public class Solution {
    
    TrieNode root;
    
    class TrieNode{
        Map<Character,TrieNode> children;
        int count;
        TrieNode(){
            this.children = new HashMap();
            this.count = 1;
        }
    }
    
    
    public void build(List<String> A){
        
        for(String str: A){
            
            TrieNode r = root;
            
            for(char x : str.toCharArray()){
                
                if(!r.children.containsKey(x))
                    r.children.put(x, new TrieNode());
                else
                    r.children.get(x).count++;
                    
                r = r.children.get(x);    
            }
            
        }
        
    }
    
    public ArrayList<String> search(List<String> A){
        
        ArrayList<String> ans = new ArrayList();
        
        for(String str: A){
            
            TrieNode r = root;
            StringBuilder temp = new StringBuilder();
            
            for(char x : str.toCharArray()){
                
                temp.append(x);
                
                if(r.children.get(x).count == 1) break;
                
                r = r.children.get(x);    
            }
            
            ans.add(temp.toString());
        }
        
        return ans;
    }
    
    
    
    
    
    public ArrayList<String> prefix(ArrayList<String> A) {
    
            root = new TrieNode();
            build(A);
            return search(A);
    
    }

}
