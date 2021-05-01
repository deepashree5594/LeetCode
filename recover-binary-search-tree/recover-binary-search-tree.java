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
    TreeNode first;
    TreeNode last;
    TreeNode prev;
    boolean breach = false;
    public void recoverTree(TreeNode root) {
        if (root == null)
            return;
        inorder(root);
        int temp = first.val;
        first.val = last.val;
        last.val = temp;
    }
    private void inorder(TreeNode root){
        //base
        if ( root == null)
            return;
        //logic
        inorder(root.left);
        if ( prev != null && prev.val >= root.val){
            if (!breach){
                first = prev;
                last = root;
                breach = true;
            } else {
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    } 
}