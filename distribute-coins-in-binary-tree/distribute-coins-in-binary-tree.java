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
//DFS
//TC: O(N)
//SC: O(height)
//Did it run successfully on Leetcode? : Yes
class Solution {
    int moves;
    public int distributeCoins(TreeNode root) {
        if ( root == null)
            return 0;
        dfs(root);
        return moves;
    }
    public int dfs(TreeNode root){
        //base
        if (root == null)
            return 0;
        //logic
        int extra = root.val - 1;
        extra += dfs(root.left);
        extra += dfs(root.right);
        moves = moves + Math.abs(extra);
        return extra;
    }
}