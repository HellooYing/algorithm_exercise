import java.util.*;
class TreeLinkNode {
    int val = 0;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
class LinkTree {
    static TreeLinkNode root=null;
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
        System.out.print(node.val);System.out.print(" ");
        if(node.left!=null) prePrint(node.left);
        if(node.right!=null) prePrint(node.right);
    }

    public void midPrint(TreeLinkNode node){
        if(node.left!=null) midPrint(node.left);
        System.out.print(node.val);System.out.print(" ");
        if(node.right!=null) midPrint(node.right);
    }

    public void backPrint(TreeLinkNode node){
        if(node.left!=null) backPrint(node.left);
        if(node.right!=null) backPrint(node.right);
        System.out.print(node.val);System.out.print(" ");
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
}

public class GetNext {
    public static void main(String[] args) throws Exception {
        LinkTree tree=new LinkTree();
        tree.root=new TreeLinkNode(0);
        tree.root.left=new TreeLinkNode(1);
        tree.root.left.next=tree.root;
        tree.root.left.left=new TreeLinkNode(3);
        tree.root.left.left.next=tree.root.left;
        tree.root.left.right=new TreeLinkNode(4);
        tree.root.left.right.next=tree.root.left;
        tree.root.right=new TreeLinkNode(2);
        tree.root.right.next=tree.root;
        tree.root.right.left=new TreeLinkNode(5);
        tree.root.right.left.next=tree.root.right;
        tree.root.right.left.right=new TreeLinkNode(6);
        tree.root.right.left.right.next=tree.root.right.left;
        tree.root.right.left.left=new TreeLinkNode(7);
        tree.root.right.left.left.next=tree.root.right.left;
        tree.midPrint(tree.root);
        System.out.println();
        System.out.print(tree.root.val);
        System.out.print(new GetNext().answer(tree.root).val);
        System.out.println();
        System.out.print(tree.root.left.left.val);
        System.out.print(new GetNext().answer(tree.root.left.left).val);
        System.out.println();
        System.out.print(tree.root.left.right.val);
        System.out.print(new GetNext().answer(tree.root.left.right).val);
        System.out.println();
        System.out.print(tree.root.right.val);
        System.out.print(new GetNext().answer(tree.root.right));
        System.out.println();
        System.out.print(tree.root.right.left.val);
        System.out.print(new GetNext().answer(tree.root.right.left).val);
        System.out.println();
        System.out.print(tree.root.right.left.right.val);
        System.out.print(new GetNext().answer(tree.root.right.left.right).val);
        System.out.println();
        System.out.print(tree.root.right.left.left.val);
        System.out.print(new GetNext().answer(tree.root.right.left.left).val);
    }
    TreeLinkNode zdg(TreeLinkNode node){
        System.out.print(node.val);
        if(node.left==null) return node;
        else return zdg(node.left);
    }
    TreeLinkNode fdg(TreeLinkNode node){
        System.out.print(node.val);
        if(node.next==null) {return null;}
        else if(node.next.left==node) {return node.next;}
        else {return fdg(node.next);}
    }
    public TreeLinkNode answer(TreeLinkNode a){
        //找出中序遍历的下一个节点，左中右，
        //有右节点，则return zdg(node.right)
        //没有右节点且有父节点，return fdg(node.next)
        //zdg: 如果node没有子左节点了，就是node。如果node有子左节点，就zdg(node.left)
        //fdg: 如果node.next不存在或存在且node是node.next的左节点，就是node.next。如果node是node.next的右节点，就fdg(node.next)
        if(a.right!=null) return zdg(a.right);
        else if(a.next!=null) return fdg(a);
        else return null;
    }
}