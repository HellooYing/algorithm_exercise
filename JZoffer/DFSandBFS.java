import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSandBFS {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BFS(root);
        System.out.println();
        DFS(root);
    }
    static void DFS(TreeNode root){
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode a;
        s.push(root);
        while(!s.isEmpty()){
            a=s.pop();
            System.out.print(a.val);
            if(a.right!=null) s.push(a.right);
            if(a.left!=null) s.push(a.left);
        }
    }

    static void BFS(TreeNode root){
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        TreeNode a;
        q.offer(root);
        while(!q.isEmpty()){
            a=q.poll();
            System.out.print(a.val);
            if(a.left!=null) q.offer(a.left);
            if(a.right!=null) q.offer(a.right);
        }
    }
}
