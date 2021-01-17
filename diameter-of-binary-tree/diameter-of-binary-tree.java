/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
//  */
// class Solution {
//     public int diameterOfBinaryTree(TreeNode root) {
//         if ( root == null) return 0;
//         int leftHeight = height(root.left);   
//         int rightHeight = height(root.right);
//         int leftDiameter = diameterOfBinaryTree(root.left);  
//         int rightDiameter = diameterOfBinaryTree(root.right);
//         return Math.max(leftHeight + rightHeight, Math.max(leftDiameter,rightDiameter));
//     } 
//         public int height(TreeNode root)
//         {
//             if (root == null) return 0;
//             return 1 + Math.max(height(root.left),height(root.right));
//         }
    
// }
​
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if ( root == null)
            return 0;
        getDiameter(root);
        return ans == 0? 0 : ans - 1;
  }
    private int getDiameter(TreeNode root)
    {   
        //base case
        if ( root == null)
            return 0;
        
        // logic
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        ans = Math.max(ans, left+right+1);
        return Math.max(left, right) + 1;
    }
}
​
