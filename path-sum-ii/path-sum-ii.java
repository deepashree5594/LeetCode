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
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        helper(root, targetSum, new ArrayList(), 0);
        return result;
    }
    private void helper(TreeNode root, int targetSum, List<Integer> path, int currSum){
        //base
        if ( root == null)
            return;
        
        //logic
        path.add(root.val);
        currSum = currSum + root.val;
        if (root.left == null && root.right == null && currSum == targetSum)
            result.add(new ArrayList(path));
        helper(root.left, targetSum, path, currSum);
        helper(root.right, targetSum, path, currSum);
        path.remove(path.size()-1);
    }
}