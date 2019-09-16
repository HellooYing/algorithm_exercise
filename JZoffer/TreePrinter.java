import java.util.*;

/**
 * @author zhaole.myy
 * @date 2019/9/14
 */
public class TreePrinter {
    public static int[][] printTree(TreeNode root){
        List<List<TreeNode>> tree=new ArrayList<>();
        List<TreeNode> level=new ArrayList<>();
        //node是当前节点，last是本排最后一个节点
        TreeNode node,last=root;
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        //整体思路是root左右孩子入栈，然后入到last
        //当二叉树没有结束的时候（栈非空）
        while(!deque.isEmpty()){
            node=deque.pollFirst();
            if(node.left!=null){
                deque.offer(node.left);
            }
            if(node.right!=null){
                deque.offer(node.right);
            }
            level.add(node);
            if(node==last){
                tree.add(level);
                if(!deque.isEmpty()){
                    last=deque.peekLast();
                    level=new ArrayList<>();
                }
            }
        }
        int[][] a=new int[tree.size()][];
        int[] b;
        for(int i=0;i<tree.size();i++){
            b=new int[tree.get(i).size()];
            for(int j=0;j<tree.get(i).size();j++){
                b[j]=tree.get(i).get(j).val;
            }
            a[i]=b;
        }
        return a;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(5);
        TreeNode n6=new TreeNode(6);
        root.left=n2;
        root.right=n3;
        n3.left=n4;
        n4.left=n5;
        n4.right=n6;
        int[][] r=printTree(root);
        System.out.println(Arrays.deepToString(r));
    }
}
