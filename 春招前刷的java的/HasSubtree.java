import java.util.*;

public class HasSubtree {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        TreeNode t1=new TreeNode(8);
        t1.right=new TreeNode(8);
        t1.right.right=new TreeNode(9);
        t1.right.right.right=new TreeNode(2);
        t1.right.right.right.right=new TreeNode(5);
        TreeNode t2=new TreeNode(8);
        t2.left=new TreeNode(9);
        t2.right=new TreeNode(2);
       
        System.out.println(new HasSubtree().HasSubtree(t1,t2));
    }
    boolean isSon(TreeNode root1,TreeNode root2){
        boolean b1=true,b2=true;
        if(root1.val!=root2.val) {System.out.println("there");return false;}
        if(root2.left!=null) {if(root1.left!=null)b1=isSon(root1.left,root2.left);else return false;}
        if(root2.right!=null) {if(root1.right!=null)b2=isSon(root1.right,root2.right);else return false;}
        if(b1==true&&b2==true) return true;
        else return false;
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        //遍历root1，对每个val=root2.val的点调用isSon(node1,node2),
        if(root1==null) return false;
        if(root2==null) return false;
        if(root1.val==root2.val){
            if(isSon(root1,root2)) return true;
        }
        
        if(root1.left!=null){
            if(HasSubtree(root1.left,root2)) return true;
        }
        if(root1.right!=null){
            if(HasSubtree(root1.right,root2)) return true;
        }
        return false;
    }
}