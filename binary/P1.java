/*

	Check if given Preorder, Inorder and Postorder traversals are of same tree
	
	Given 3 array of integers A, B and C. A represents preorder traversal of a binary tree. B represents inorder traversal of a binary tree. C represents postorder traversal of a binary tree. Check whether these tree traversals are of the same tree or not. If they are of same tree return 1 else return 0. 
	
	Input Format
	The arguments given are integer arrays A, B, and C.
	Output Format
	Return 1 if they are of same tree else return 0.
	Constraints
	1 <= length of the array <= 1000
	all arrays are of same length
	1 <= A[i], B[i], C[i] <= 10^9 
	For Example
	Input 1:
	    A = [1, 2, 4, 5, 3]
	    B = [4, 2, 5, 1, 3]
	    C = [4, 5, 2, 3, 1]
	Output 1:
	    1

	Input 2:
	    A = [1, 5, 4, 2, 3]
	    B = [4, 2, 5, 1, 3]
	    C = [4, 1, 2, 3, 5]

	Output 2:
	    0


*/



public class P1 {
  
    public  int n = 0;

  
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
    
        n = A.size()-1;
        
        Map<Integer,Integer> map = new HashMap();
        
        for(int i=0;i<B.size();i++) map.put(B.get(i),i);


        Node root = helper(B,C,0,n,map);
        
        ArrayList<Integer> ans = new ArrayList();
        preorder(root, ans);
        
        int[] x1 = ans.stream().mapToInt(i -> i).toArray();
        int[] x2 = A.stream().mapToInt(i -> i).toArray();
    
        return Arrays.equals(x1,x2)?1:0;
    }
    
         class Node{

        Node left,right;
        int val;
        Node(int val){
            this.val = val;
            this.left = this.right = null;
        }

    }


    public  Node helper(List<Integer> in,List<Integer> post,int start, int end, Map<Integer,Integer> map){

        if(start > end || n==-1) return null;

        Node root = new Node(post.get(n--));    

        if(start == end ) return root;

        int index = map.get(root.val);


        root.right = helper(in,post,index+1,end,map);
        
        root.left = helper(in,post,start,index-1,map);

        return root;
    }

    public void preorder(Node root,ArrayList<Integer> ans){

        if(root==null) return;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }


    
}
