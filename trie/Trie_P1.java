/*

	Find shortest unique prefix to represent each word in the list.

	Example:

	Input: [zebra, dog, duck, dove]
	Output: {z, dog, du, dov}
	where we can see that
	zebra = z
	dog = dog
	duck = du
	dove = dov

*/

import java.util.*;

public class Trie_P1{
    
    class Node{
        
        HashMap<Character, Node> children;
        int f; //frequency
        Node(){
            
            children = new HashMap<>();
            this.f = 1;
        }
        
    }
    
    
    public ArrayList<String> prefix(ArrayList<String> A) {
        
        ArrayList<String> ans = new ArrayList();
        if(A.size()==0) return ans;
        Node root = buildTrie(A);
        
        return find(root, A);
    }
    
    
    public ArrayList<String> find(Node root,ArrayList<String> data){
        
        ArrayList<String> ans = new ArrayList();
        for(String s : data){
            
            Node n = root;
            
            for(int j=0;j<s.length();j++){
                
                Character c  = s.charAt(j);
                
                if(n.children.get(c).f == 1) {ans.add(new String(s.substring(0,j+1)));break;}
                
                else n = n.children.get(c);
                
            }
            
            
            
        }
    
        return ans;
        
    }
    
    
    
    public Node buildTrie(ArrayList<String> data){
        
        Node root = new Node();   
        
        for(int i=0;i<data.size();i++){
            
            Node r = root;
            
            
            for(int j=0;j<data.get(i).length();j++){
                
                    Character c = data.get(i).charAt(j);   
                    
                    if(r.children.containsKey(c)){
                        
                        Node n = r.children.get(c);
                        n.f+= 1; 
                        r = n;
                    }else{
                        
                        Node n = new Node();
                        r.children.put(c, n);
                        r = n;
                    }
            }
            
        }
        
        return root;   
        
    } 
        
}

