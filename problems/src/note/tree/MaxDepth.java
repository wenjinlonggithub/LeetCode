package note.tree;

public class MaxDepth {

    /* Definition for a binary tree node. */
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x){
            val = x;
        }
    }

    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

    public static void main(String[] args) {

    }
}
