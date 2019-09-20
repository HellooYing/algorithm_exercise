import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/18
 */
public class sxf2019091801 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {
        new sxf2019091801().answer();
    }
    private void answer(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0) {
            System.out.println("#");
            return;
        }
        sc.nextLine();
        int rootN=Integer.valueOf(sc.nextLine());
        if(n==1){
            System.out.println(rootN);
            return;
        }
        TreeNode root=new TreeNode(rootN);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        for(int i = 0; i < n-1; i=i+2){
            TreeNode node=queue.poll();
            String s=sc.nextLine();
            if(!s.equals("#")){
                Integer num=Integer.valueOf(s);
                node.left=new TreeNode(num);
                queue.offer(node.left);
            }
            if(i==n-1) break;
            s=sc.nextLine();
            if(!s.equals("#")){
                Integer num=Integer.valueOf(s);
                node.right=new TreeNode(num);
                queue.offer(node.right);
            }
        }
        sc.close();
        prePrint(root);
    }
    private void prePrint(TreeNode treeNode){
        System.out.println(treeNode.val);
        if(treeNode.left!=null) prePrint(treeNode.left);
        else System.out.println("#");
        if(treeNode.right!=null) prePrint(treeNode.right);
        else System.out.println("#");
    }
}
