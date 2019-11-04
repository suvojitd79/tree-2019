// Maximum XOR of Two Numbers in an Array	


import java.util.*;

public class Trie_P3{

	class TrieNode{

		TrieNode[] children;
		TrieNode(){
			children = new TrieNode[2];
		}

	}



	public int solve(ArrayList<Integer> nums){

		if(nums == null || nums.size() == 0) return 0;

		TrieNode root = new TrieNode();

		int max = 0;


		for(Integer num: nums){


			TrieNode current = root, complement = root;

			int value = 0; 

			for(int i=31;i>=0;i--){

				int bit = (num >> i) & 1;

				if(current.children[bit] == null) current.children[bit] = new  TrieNode();
				current = current.children[bit];

				if(complement.children[1-bit] != null) { complement = complement.children[1-bit];value+= (1 << i);}
				else complement = complement.children[bit];

			}

			max = Math.max(max,value);

		}


		return max;


	}




	public static void main(String[] args){

		Trie_P3 t1 = new Trie_P3();
		ArrayList<Integer> data = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
		System.out.println(t1.solve(data));

	}


}
