import java.util.*;
public class HasSubtree {
    //15min ok
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(8);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        TreeNode root2= new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(new HasSubtree().answer(root,root2));
    }

    public boolean answer(TreeNode root1,TreeNode root2) {
        StringBuilder r1=new StringBuilder();
        xlh(root1,r1);
        System.out.println(r1);
        StringBuilder r2=new StringBuilder();
        xlh(root2,r2);
        while(r2.lastIndexOf("#!")==r2.length()-2){
            r2.delete(r2.lastIndexOf("#!"),r2.length());
        }
        int r=r1.indexOf(r2.toString());
        if(r==-1) return false;
        else return true;
    }
    private void xlh(TreeNode root,StringBuilder s){
        s.append(root.val+"!");
        if(root.left!=null){
            xlh(root.left,s);
        }
        else{
            s.append("#!");
        }
        if(root.right!=null){
            xlh(root.right,s);
        }
        else{
            s.append("#!");
        }
    }
}