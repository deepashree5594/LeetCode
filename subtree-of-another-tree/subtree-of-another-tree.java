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
// TC: O(min(s, t))
// SC: O(min(s, t))
//https://www.youtube.com/watch?v=HdMs2Fl_I-Q&ab_channel=KevinNaughtonJr.

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if ( s == null)
           return false;
        else if (isSame(s, t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSame(TreeNode s, TreeNode t)
    {
        //base
        if ( s == null || t == null)
        {
            return s == null && t == null;
        }
        //logic
         if (s.val == t.val)
        {
            return isSame(s.left, t.left) && isSame(s.right, t.right);
        }
        else
            return false;
    }
}