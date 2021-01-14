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
​
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length == 0 || preorder.length == 0) 
            return null;
         int rootVal = preorder[0];
         TreeNode root = new TreeNode(rootVal);
         int index = -1;
         for ( int i = 0; i < inorder.length; i++)
         {
            if (inorder[i] == rootVal)
                index = i;
         }
         int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
         int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
         int[] preLeft = Arrays.copyOfRange(preorder, 1, index+1); 
         int[] preRight = Arrays.copyOfRange(preorder, index+1,  preorder.length);
         root.left = buildTree( preLeft, inLeft);
         root.right = buildTree( preRight, inRight);
        return root;     
    }
}
​
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
​
// class Solution {
//   public TreeNode buildTree(int[] preorder, int[] inorder) {
//     Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
​
//     for(int i = 0; i < inorder.length; i++) {
//         inMap.put(inorder[i], i);
//     }
//      return helper(0,0,inorder.length-1, preorder, inorder, inMap);
//   }
//   public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder, Map<Integer, Integer> inMap)
//   {
//       if (preStart > preorder.length-1 || inStart > inEnd) return null;
