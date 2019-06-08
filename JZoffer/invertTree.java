public class invertTree {
    public TreeNode answer(TreeNode root) {
        if(root==null) return root;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        if(root.left!=null) answer(root.left);
        if(root.right!=null) answer(root.right);
        return root;
    }
}
