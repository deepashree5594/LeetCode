/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
//BFS
//TC: O(N)
//SC: O(N)
//Did it run successfully on Leetcode? :Yes
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0)
             return 0; 
        Queue<NestedInteger> queue = new LinkedList();
        Queue<Integer> depthQueue = new LinkedList();
        int sum = 0;
        for (NestedInteger element : nestedList){
            queue.add(element);
            depthQueue.add(1);
        }
        while (!queue.isEmpty()){
            NestedInteger curr = queue.poll();
            int currDepth = depthQueue.poll();
            if (curr.isInteger()){
                int n = curr.getInteger();
                sum = sum + (n * currDepth);
            }
            else {
                List<NestedInteger> list = curr.getList();
                for (NestedInteger n : list){
                    queue.offer(n);
                    depthQueue.offer(currDepth+1);
                }
            }
        }
      return sum;
    }
}




//DFS
//TC: O(N)
//SC: O(depth)
//Did it run successfully on Leetcode? :Yes
// class Solution {
//     int sum;
//     public int depthSum(List<NestedInteger> nestedList) {
//         if (nestedList == null || nestedList.size() == 0)
//             return 0;
//         sum = 0;
//         dfs(nestedList, 1);
//         return sum;
//     }
//     private void dfs(List<NestedInteger> nestedList, int depth){
//         //base  (not needed)
    
//         //logic
//         for (NestedInteger nested : nestedList){
//             if (nested.isInteger()){
//                 sum = sum + nested.getInteger() * depth;
//             }
//             else {
//                 dfs(nested.getList(), depth+1);
//             }
//         }
//     }
// }