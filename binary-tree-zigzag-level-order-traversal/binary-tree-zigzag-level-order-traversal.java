/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if( root == null)
            return result;
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level = 0;
        boolean reverseLevel = false;
        while (!q.isEmpty())
        {
            int size = q.size();
            List<Integer> list = new ArrayList();
            for (int i = 0; i < size; i++)
            {
                TreeNode cur = q.poll();
                list.add(cur.val);
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
         }
             if (reverseLevel)
             {
                 Collections.reverse(list);
             }
            result.add(list);
            level++;
            reverseLevel = !reverseLevel;
        }
        return result;
    }
}