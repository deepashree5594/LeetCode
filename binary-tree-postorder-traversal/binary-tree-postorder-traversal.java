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
class Solution {
    List<Integer> result;
    public List<Integer> postorderTraversal(TreeNode root) {
        if ( root == null)
            return new ArrayList();
        result = new ArrayList();
        helper(root);
        return result;
    }
    private void helper(TreeNode root)
    {
        //base
        if ( root == null)
            return;
        //logic
        helper(root.left);
        helper(root.right);
        result.add(root.val);
    }
}

// postorder(print root)
// postorder(root.left)
// postorder(root.left)