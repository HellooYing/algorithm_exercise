import java.util.*;
public class PrintFromTopToBottom {
    static TreeNode root=null;
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    
        TreeNode(int val) {
            this.val = val;
        }
    }

    public void add(int x){
        TreeNode newNode=new TreeNode(x);
        if(root==null){
            root = newNode;
            return;
        }
        TreeNode tmp=find(root);
        tmp.val=x;
        frontPrint(root);
        System.out.println();
    }

    public void frontPrint(TreeNode node){
        System.out.print(node.val);
        if(node.left!=null) frontPrint(node.left);
        if(node.right!=null) frontPrint(node.right);
    }
    
    public TreeNode find(TreeNode node){//find输入node，输出以node为根节点的完全二叉树的下一个节点（也就是第一个空节点）
        //逻辑是，
        //如果左节点为null，就返回左节点，否则如果右节点为null，返回右节点，否则：
        //沿着最左走下去，得到深度h
        //然后二分查找的找。根节点的左节点一直走右（存在右）走到头，
        //深度如果和h相等则说明下一个节点在根节点的右节点，则find(node.right)
        //深度如果是h-1，则find(node.left)
        TreeNode r=null;
        if(node.left==null) {node.left=new TreeNode(0);r=node.left;}
        else if(node.right==null) {node.right=new TreeNode(0);r=node.right;}
        else {
            int h=1,h1=1;
            TreeNode t=node;
            while(t.right!=null){
                t=t.right;
                h1++;
            }
            t=node;
            while(t.left!=null){
                t=t.left;
                h++;
            }
            if(h==h1){t.left=new TreeNode(0);r=t.left;}
            else if(node.left.right!=null){
                int h2=2;
                t=node.left;
                while(t.right!=null){
                    t=t.right;
                    h2++;
                }
                if(h2==h) r=find(node.right);
                else if(h2==h-1) r=find(node.left);
            }
            else {node.left.right=new TreeNode(0);r=node.left.right;}
        }
        return r;
    }

    public static void main(String[] args) throws Exception {
        PrintFromTopToBottom tree=new PrintFromTopToBottom();
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
    }
    
    public ArrayList<Integer> answer(TreeNode root){
        ArrayList<Integer> r=new ArrayList<Integer>();
        return r;
    }
}