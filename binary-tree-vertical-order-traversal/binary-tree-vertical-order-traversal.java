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
class Solution{
    class Pair{
      TreeNode node;
      int column;
      Pair(TreeNode node, int column ){
          this.node = node;
          this.column = column;
      }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null)
          return new ArrayList();
        List<List<Integer>> result = new ArrayList();
        HashMap<Integer, List<Integer>> map = new HashMap();
        int min = 0;
        int max = 0;
        Queue<Pair> q = new LinkedList();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()){
            Pair p = q.poll();
            TreeNode currNode = p.node;
            int currColumn = p.column;
            if (!map.containsKey(currColumn)){
                map.put(currColumn, new ArrayList());
            }
            map.get(currColumn).add(currNode.val);
            if (currNode.left != null){
                q.add(new Pair(currNode.left, currColumn - 1 ));
                min = Math.min(min, currColumn - 1 );
            }
            if (currNode.right != null){
                q.add(new Pair(currNode.right, currColumn + 1 ));
                max = Math.max(max, currColumn + 1 );
            }
        }
        for (int i = min; i <= max; i++){
           // Collections.sort(map.get(i));
            result.add(map.get(i));
        }
        return result;
    }
}