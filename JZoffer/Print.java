import java.util.*;

public class Print {
    static TreeNode root=new TreeNode(0);
    public static void main(String[] args) throws Exception {
        root.left=new TreeNode(1);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(5);
        root.right.right=new TreeNode(6);
        root.right.left.left=new TreeNode(7);
        root.right.right.left=new TreeNode(8);
        new Print().answer(root);
    }

    public void answer(TreeNode root){
        //逻辑是，建立队列，从root开始，往队列里加左节点再加右节点，
        //然后出队列一个，加它的左节点和右节点，再出队列
        //为了按行打印，设立last。
        //last先在root，当出队列的节点就是last时，last等于它的右儿子，没有右儿子就左儿子
        //并且是先把子节点入队列，再执行出队列与比较last的工作。
        
        TreeNode last=root,i;
        LinkedList<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            i=q.poll();
            if(i.left!=null) q.offer(i.left);
            if(i.right!=null) q.offer(i.right);
            System.out.print(i.val+" ");
            if(i==last){
                System.out.println();
                if(last.right!=null) last=last.right;
            }
        }







        //8min with little bug
        // TreeNode last=root,nlast=root;
        // LinkedList<TreeNode> q=new LinkedList<TreeNode>();
        // q.offer(root);
        // while(!q.isEmpty()){
        //     last=q.poll();
        //     System.out.print(last.val+" ");
        //     if(last.left!=null) q.offer(last.left);
        //     if(last.right!=null) q.offer(last.right);
        //     if(last==nlast){
        //         System.out.println();
        //         if(nlast.right!=null) nlast=nlast.right;
        //         else if(nlast.left!=null) nlast=nlast.left;
        //     }
        // }





//        TreeNode last=root,nlast=root;
//        if(last==null) return;
//        LinkedList<TreeNode> q=new LinkedList<TreeNode>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            nlast=q.poll();
//            if(nlast.left!=null) q.offer(nlast.left);
//            if(nlast.right!=null) q.offer(nlast.right);
//            System.out.print(nlast.val);
//            System.out.print(" ");
//            if(nlast==last){
//                System.out.println();
//                if(last.right!=null) last=last.right;
//                else if(last.left!=null) last=last.left;
//                else return;
//            }
//        }
    }
    void printq(LinkedList<TreeNode> q){
        for(TreeNode a:q) System.out.print(a.val);
    }
}