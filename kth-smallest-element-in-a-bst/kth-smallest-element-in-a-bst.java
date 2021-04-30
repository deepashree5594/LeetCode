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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int result = 0;
        int count = 0;
        while (!stack.isEmpty() || root != null){
            while ( root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            count++;
            if (count == k){
                result = root.val;
                break;
            }   
            root = root.right;
        }
        return result;
    }
}