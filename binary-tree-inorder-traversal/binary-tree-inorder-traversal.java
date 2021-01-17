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
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<Integer>();
//         Stack<TreeNode> stack = new Stack<TreeNode>();
//         TreeNode cur = root;
//         while ( cur != null || !stack.isEmpty())
//         {
//             while ( cur != null)
//             {
//                 stack.push(cur);
//                 cur = cur.left;
//             }
//             cur = stack.pop();
//             list.add(cur.val);
//             cur = cur.right;
//         }
//           return list;  
//     }
// }
​
class Solution {
     List<Integer> list;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList();
        list = new ArrayList();
        inorder(root);
        return list;
    }
    private void inorder(TreeNode root)
    {
        //base
        if ( root == null)
          return;
        //logic
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
}
​
