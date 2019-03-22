import java.util.*;
public class LinkTree {
    static TreeLinkNode root=null;
    class TreeLinkNode {
        int val = 0;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
    
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public void add(int x){
        TreeLinkNode newNode=new TreeLinkNode(x);
        if(root==null){
            root = newNode;
            return;
        }
        TreeLinkNode tmp=find(root);
        tmp.val=x;
    }

    public void prePrint(TreeLinkNode node){
        System.out.print(node.val);
        if(node.left!=null) prePrint(node.left);
        if(node.right!=null) prePrint(node.right);
    }

    public void midPrint(TreeLinkNode node){
        if(node.left!=null) midPrint(node.left);
        System.out.print(node.val);
        if(node.right!=null) midPrint(node.right);
    }

    public void backPrint(TreeLinkNode node){
        if(node.left!=null) backPrint(node.left);
        if(node.right!=null) backPrint(node.right);
        System.out.print(node.val);
    }

    public int height(TreeLinkNode node){
        int n=1;
        int l=0,r=0;
        if(node.left!=null) l=height(node.left,n);
        if(node.right!=null)  r=height(node.right,n);
        if(l>=r&&l>n) n=l;
        else if(r>l&&r>n) n=r;
        return n;
    }

    public int height(TreeLinkNode node, int n){
        n++;
        int l=0,r=0;
        if(node.left!=null) l=height(node.left,n);
        if(node.right!=null)  r=height(node.right,n);
        if(l>=r&&l>n) n=l;
        else if(r>l&&r>n) n=r;
        return n;
    }

    public TreeLinkNode find(TreeLinkNode node){
        TreeLinkNode r=null;
        if(node.left==null) {node.left=new TreeLinkNode(0);r=node.left;node.left.next=node;}
        else if(node.right==null) {node.right=new TreeLinkNode(0);r=node.right;node.right.next=node;}
        else {
            int h=1,h1=1;
            TreeLinkNode t=node;
            while(t.right!=null){
                t=t.right;
                h1++;
            }
            t=node;
            while(t.left!=null){
                t=t.left;
                h++;
            }
            if(h==h1){t.left=new TreeLinkNode(0);r=t.left;t.left.next=t;}
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
            else {node.left.right=new TreeLinkNode(0);r=node.left.right;node.left.right.next=node.left;}
        }
        return r;
    }

    public void fcPrint_dg(TreeLinkNode node,ArrayList<ArrayList<Integer>> r,int h){
        r.get(h).add(node.val);
        h++;
        if(node.left!=null) fcPrint_dg(node.left,r,h);
        if(node.right!=null) fcPrint_dg(node.right,r,h);
    }

    public ArrayList<Integer> fcPrint(TreeLinkNode root){
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        ArrayList<ArrayList<Integer>> r=new ArrayList<ArrayList<Integer>>();
        int height;
        height=height(root);
        for(int i=0;i<height;i++) r.add(new ArrayList<Integer>());
        fcPrint_dg(root,r,0);
        for(int i=0;i<height;i++) result.addAll(r.get(i));
        return result;
    }

    public static void main(String[] args) throws Exception {
        LinkTree tree=new LinkTree();
        tree.add(0);
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(6);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.prePrint(root);
        System.out.println();
        tree.midPrint(root);
    }

}