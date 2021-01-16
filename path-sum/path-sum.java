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
    boolean result = false;
    int target;
    public boolean hasPathSum(TreeNode root, int sum) {
          if ( root == null)
              return false;
          target = sum;
          helper(root, 0);
          return result;       
    }
    private void helper(TreeNode root, int currSum)
    {
       // base case
        if ( root == null)
           return;
        // logic
        currSum = currSum + root.val;
        helper(root.left, currSum);
        // stack.pop() happens
        
        if ( root.left == null && root.right == null && currSum == target)
        {
            result = true;
               return;
        }
        helper(root.right, currSum); 
    }
}
