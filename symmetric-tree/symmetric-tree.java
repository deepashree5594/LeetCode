/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
    // public boolean isSymmetric(TreeNode root) {
    //     return isMirror(root, root);
    //     }
    // public boolean isMirror(TreeNode t1, TreeNode t2)
    // {
    //     if ( t1 == null && t2 == null) return true;
    //     if ( t1 == null || t2 == null) return false;
    //     return ( t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right,t2.left);
    // }
class Solution {
     boolean isValid = true;
     public boolean isSymmetric(TreeNode root) {
         if ( root == null)
             return true;
         helper(root.left, root.right);
         return isValid;
     }        
     private void helper(TreeNode left, TreeNode right)
     {
         //base case
         if (left == null && right == null)
             return;
         if (left == null || right == null || left.val != right.val)
         {
             isValid = false;
             return;
         }
         //logic
        
          helper(left.left, right.right);
          helper(left.right, right.left);
     }
}
