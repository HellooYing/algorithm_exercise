import java.util.*;
public class Convert2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(2);
        TreeNode a3=new TreeNode(3);
        TreeNode a4=new TreeNode(4);
        TreeNode a5=new TreeNode(5);
        TreeNode a6=new TreeNode(6);
        TreeNode a7=new TreeNode(7);
        TreeNode a8=new TreeNode(8);
        a2.left=a1;
        a3.left=a2;
        a3.right=a4;
        a5.left=a3;
        a5.right=a7;
        a7.left=a6;
        a7.right=a8;
        new Convert2().answer(a5);
        TreeNode t=a1;
        while(t!=null){
            System.out.print(t.val+" ");
            t=t.right;
        }
        t=a8;
        while(t!=null){
            System.out.print(t.val+" ");
            t=t.left;
        }
    }

    public TreeNode answer(TreeNode pRootOfTree){
        if(pRootOfTree==null) return pRootOfTree;
        change(pRootOfTree);
        TreeNode head=pRootOfTree;
        while(head.left!=null) head=head.left;
        return head;
    }
    void change(TreeNode pRootOfTree){
        if(pRootOfTree.left==null&&pRootOfTree.right==null) return;
        TreeNode l,r;
        l=pRootOfTree.left;
        r=pRootOfTree.right;
        if(l!=null){
            while(l.right!=null) l=l.right;
            change(pRootOfTree.left);
            pRootOfTree.left=l;
            l.right=pRootOfTree;
        }
        if(r!=null){
            while(r.left!=null) r=r.left;
            change(pRootOfTree.right);
            pRootOfTree.right=r;
            r.left=pRootOfTree;
        }
    }
}