//             return;
//         }
//         prev = root;
//         getInorderSuccessor(root.right, prev);
//     }   
// }
​
//
class Pair{
    TreeNode root;
    TreeNode prev;
    Pair(TreeNode root, TreeNode prev)
    {
        this.root = root;
        this.prev = prev;
    }
    public TreeNode getRoot()
    {
        return this.root;
    }
    public TreeNode getPrev()
    {
        return this.prev;
    }
}
class Solution {
     public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         if (root == null)
             return null;
         Stack<TreeNode> stack = new Stack();
         TreeNode prev = null;
         while ( root!= null || !stack.isEmpty())
         {
             while ( root != null)
             {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             System.out.println("root " + root.val);
             // root = pair.getRoot();
             // prev = pair.getPrev();
             if (prev != null && prev.val == p.val)
                 return root;
             prev = root;
             root = root.right;
         }
         return root;
     }
}
