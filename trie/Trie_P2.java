/*

Hotel Reviews

Given a set of reviews provided by the customers for different hotels and a string containing “Good Words”, you need to sort the reviews in descending order according to their “Goodness Value” (Higher goodness value first). We define the “Goodness Value” of a string as the number of “Good Words” in that string.

Note: Sorting should be stable. If review i and review j have the same “Goodness Value” then their original order would be preserved.


Constraints:

1.   1 <= No.of reviews <= 200
2.   1 <= No. of words in a review <= 1000
3.   1 <= Length of an individual review <= 10,000
4.   1 <= Number of Good Words <= 10,000
5.   1 <= Length of an individual Good Word <= 4
6.   All the alphabets are lower case (a - z)



Input:


S : A string S containing "Good Words" separated by  "_" character. (See example below)
R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.
Output:

A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews. 

V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)
Example:

Input: 
S = "cool_ice_wifi"
R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

Output:
ans = [2, 0, 1]
Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
Seen this q


*/


public class Trie_P2{
    
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



