// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         while ( !stack.isEmpty() || root != null)
//         {
//             while ( root != null)
//             {
//                 stack.push(root);
//                 root = root.left;
//             }
//             root = stack.pop();
//             if ( --k == 0) return root.val;
//             root = root.right;
//         }
//         return -1;
//     }
// }


class Solution {
    int count;
    int result;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        result = 0;
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k)
    {
        //base
        if (root == null)
          return;
        //logic
        inorder(root.left, k);
        count++;
        if ( count == k)    
        { 
            result = root.val;
        }
        inorder(root.right, k);
    }
}