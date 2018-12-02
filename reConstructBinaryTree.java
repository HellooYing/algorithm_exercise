import java.util.*;
public class reConstructBinaryTree extends BinaryTree {
    public static int index(int[] array,int val){
        int flag=0;
        int i;
        for(i=0;i<array.length;i++){
            if(array[i]==val) {flag=1;break;}
        }
        if(flag==0) return -1;
        else return i;
    }
    public static void main(String[] args) throws Exception {
        reConstructBinaryTree tree=new reConstructBinaryTree();
        int[] pre={0, 1, 3, 7, 8, 4, 9, 2, 5, 6};
        int[] in={7, 3, 8, 1, 9, 4, 0, 5, 2, 6};
        TreeNode root=tree.answer(pre,in);
        tree.prePrint(root);
    }
    public TreeNode answer(int [] pre,int [] in){
        //pre[0]肯定是根，index(in, pre[0])左边是左子树，右边是右子树，应该递归左右子树然后返回根节点
        int rot=index(in, pre[0]);
        TreeNode node=new TreeNode(pre[0]);
        if(rot!=0){
            int[] lin= Arrays.copyOfRange(in, 0,rot );
            int[] lpre=Arrays.copyOfRange(pre, 1,rot+1);
            node.left=answer(lpre,lin);
        }
        if(rot!=in.length-1){
            int[] rin= Arrays.copyOfRange(in, rot+1,in.length);
            int[] rpre=Arrays.copyOfRange(pre, rot+1,pre.length);
            node.right=answer(rpre,rin);
        }
        return node;
    }
}