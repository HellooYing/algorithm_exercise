public class flatten {
//给定一个二叉树，原地将它展开为链表。
    public void answer(TreeNode root) {
        if(root==null) return;
        TreeNode[] left=dg(root.left);
        TreeNode[] right=dg(root.right);
        root.left=null;
        if(left==null&&right==null){
        }
        else if(left==null){
            root.right=right[0];
        }
        else if(right==null){
            root.right=left[0];
        }
        else{
            root.right=left[0];
            left[1].right=right[0];
        }
    }
    public TreeNode[] dg(TreeNode root){
        if(root==null) return null;
        TreeNode[] left=dg(root.left);
        TreeNode[] right=dg(root.right);
        root.left=null;
        TreeNode[] result=new TreeNode[2];
        result[0]=root;
        if(left==null&&right==null){
            result[1]=root;
        }
        else if(left==null){
            root.right=right[0];
            result[1]=right[1];
        }
        else if(right==null){
            root.right=left[0];
            result[1]=left[1];
        }
        else{
            root.right=left[0];
            left[1].right=right[0];
            result[1]=right[1];
        }
        return result;
    }
}
