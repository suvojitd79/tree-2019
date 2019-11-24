/*

Count Bigger Ancestors

Given a tree with N nodes. Each node has some value assigned to it. Consider node 1 as the root of the tree and nodes are 1-indexed. For each node you have to find number of ancestors having higher value than the current node . Constraints:
1 <= N <= 70000
0 <= Value of Node <= 10^9
Input:
Argument 1 is an array of length N. Arr1[i] contains value assigned to node i + 1.
Argument 2 is an array of length N - 1.  
Argument 3 is an array of length N - 1.
There is an edge between node Arr2[i] and node Arr3[i].
Output
Return an array of length N denoting answer. Arr[i] should contain answer for node i + 1. 
Example:
Input:
N = 5
Val = [5 4 3 2 1]
Edge1 = [2 3 4 5]
Edge2 = [1 2 3 4]

Output:
[0 1 2 3 4]

Explanation:
Consider tree rooted at 1. It is 1 -> 2 -> 3 -> 4 -> 5. For each node(except node 1) all ancestors have higher value assigned. So, answer is [0 1 2 3 4].


*/