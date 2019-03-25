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
    }

    public int[][] answer(TreeNode root){
        //逻辑是，建立队列，从root开始，往队列里加左节点再加右节点，
        //然后出队列一个，加它的左节点和右节点，再出队列
        //为了按行打印，设立last。
        //last先在root，当出队列的节点就是last时，last等于它的右儿子，没有右儿子就左儿子
        //并且是先把子节点入队列，再执行出队列与比较last的工作。

        List<List<Integer>> r=new ArrayList<List<Integer>>();
        TreeNode last,nlast=root;
        Deque<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        List<Integer> rr=new ArrayList<Integer>();
        while(!q.isEmpty()){
            last=q.poll();
            rr.add(last.val);
            if(last.left!=null) q.offer(last.left);
            if(last.right!=null) q.offer(last.right);
            if(last==nlast){
                r.add(rr);
                rr=new ArrayList<Integer>();
                if(nlast.right!=null) nlast=nlast.right;
                else if(nlast.left!=null) nlast=nlast.left;
                else nlast=q.peekLast();
            }
        }
        if(rr.size()>0) r.add(rr);
        int[][] a=new int[r.size()][];
        int[] b;
        for(int i=0;i<r.size();i++){
            b=new int[r.get(i).size()];
            for(int j=0;j<r.get(i).size();j++){
                b[j]=r.get(i).get(j);
            }
            a[i]=b;
        }
        for(int[] d:a){
            for(int e:d){
                System.out.print(e+" ");
            }
            System.out.println();
        }
        return a;
    }
}