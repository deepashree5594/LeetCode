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
    public boolean isValidBST(TreeNode root) {
//      Stack<TreeNode> stack = new Stack<TreeNode>();
//      double left_child_val = - Double.MAX_VALUE;
//      while ( !stack.isEmpty() || root != null )
//      {
//          while ( root != null)
//          {
//              stack.add(root);
//              root = root.left;
//          }
//           root =  stack.pop();
//           if ( root.val <= left_child_val)
//               return false;
//           left_child_val = root.val;
//           root = root.right;
//      }
//         return true;
// }
        return validate(root, null, null);
    }
     private boolean validate(TreeNode root, Integer low, Integer high)
     {
         if ( root == null)
           return true;
         if ( (low != null && root.val <= low) || (high != null && root.val >= high))
             return false;
          return validate(root.left, low, root.val) && validate(root.right, root.val, high)  ;
     }
       
}
