import java.util.*;

public class Mirror {
    public static void main(String[] args) throws Exception {
        TreeNode a=new TreeNode(1);
        a.left=new TreeNode(2);
        a.left.left=new TreeNode(3);
        a.right=new TreeNode(4);
        a.right.right=new TreeNode(5);
        new Mirror().answer(a);
        System.out.println(a.left.left.val);
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public void answer(TreeNode root){
        if(root==null) return;
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        if(root.right!=null) answer(root.right);
        if(root.left!=null) answer(root.left);
    }
}