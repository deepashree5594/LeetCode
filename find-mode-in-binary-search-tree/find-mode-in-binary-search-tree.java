/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    int maxCount = -1;
    TreeNode prev;
    
    public int[] findMode(TreeNode root) {
        if ( root == null)
            return new int[]{};
        prev = root;    
        List<Integer> modesList = new ArrayList();
        inorder(root, modesList);
        int[] result = new int[modesList.size()];
        for ( int i = 0; i < result.length; i++)
        {
            result[i] = modesList.get(i);
        }
        return result;
    }
    private void inorder(TreeNode root, List<Integer> modesList)
    {
        //base
        if ( root == null)
           return;
        //logic
        inorder(root.left, modesList);
        if (root != prev && root.val == prev.val)
            count = count + 1;
        else
            count = 1;
        
        if (count == maxCount)
            modesList.add(root.val);
        else if (count > maxCount)
        {
             modesList.clear();
             modesList.add(root.val);
             maxCount = count;
        }
        prev = root;
        inorder(root.right, modesList);
    }
}
