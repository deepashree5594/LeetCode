/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     class Pair{
//       TreeNode node;
//       int column;
//       Pair(TreeNode node, int column ){
//           this.node = node;
//           this.column = column;
//       }
//     }
//     public List<List<Integer>> verticalTraversal(TreeNode root) {
//         if (root == null)
//           return new ArrayList();
//         List<List<Integer>> result = new ArrayList();
//         HashMap<Integer, List<Integer>> map = new HashMap();
//         int min = 0;
//         int max = 0;
//         Queue<Pair> q = new LinkedList();
//         q.offer(new Pair(root, 0));
//         int level = 0;
//         while (!q.isEmpty()){
//          int size = q.size();
//          for ( int i = 0; i < size; i++){
//             Pair p = q.poll();
//             TreeNode currNode = p.node;
//             int currColumn = p.column;
//             if (!map.containsKey(currColumn)){
//                 map.put(currColumn, new ArrayList());
//             }
//             map.get(currColumn).add(currNode.val);
//             if (currNode.left != null){
//                 q.add(new Pair(currNode.left, currColumn - 1 ));
//                 min = Math.min(min, currColumn - 1 );
//             }
//             if (currNode.right != null){
//                 q.add(new Pair(currNode.right, currColumn + 1 ));
//                 max = Math.max(max, currColumn + 1 );
//             }
//           }
//           level++;
//         }
//         for (int i = min; i <= max; i++){
//             Collections.sort(map.get(i));
//             result.add(map.get(i));
//         }
//         return result;
//     }
    
// }
// 2:[3,2] //level 
 // 0:[2,3] //order


class Solution {
   int min;
   int max;
  HashMap<Integer, Queue<int[]>> map;
   public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null)
          return new ArrayList();
         map = new HashMap<>();
         min = 0;
         max = 0; 
        dfs(root, 0, 0);
        List<List<Integer>> result = new ArrayList();
        
        for (int i = min; i <= max; i++){
            result.add(new ArrayList());
            while (!map.get(i).isEmpty()){
                int[] entry = map.get(i).remove();
                result.get(result.size()-1).add(entry[1]);
            }
        }
       return result;
       
   }
   private void dfs(TreeNode root, int row, int col){
       //base
       if (root == null)
           return;
       //logic
       min = Math.min(min, col);
       max = Math.max(max, col);
       if (!map.containsKey(col)){
           map.put(col, new PriorityQueue<int[]>((e1, e2) -> {
               if (e1[0] != e2[0])
                   return e1[0] - e2[0];
              return e1[1] - e2[1];  
               }));
       }
       map.get(col).add(new int[] {row, root.val});
       dfs(root.left, row+1, col-1);
       dfs(root.right, row+1, col+1); 
   }
}
