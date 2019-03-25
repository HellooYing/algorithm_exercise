import java.util.*;

public class MaxSubtree {
    int n=0;
    TreeNode node;
    public static void main(String[] args) throws Exception {
//        TreeNode b=new TreeNode(19);
//        TreeNode a=new TreeNode(18);
//        b.left=a;
//        TreeNode root = new TreeNode(12);
//        a.left=root;
//        root.left=new TreeNode(7);
//        root.left.left=new TreeNode(17);
//        root.left.left.left=new TreeNode(2);
//        root.left.left.left.left=new TreeNode(1);
//        root.left.left.right=new TreeNode(5);
//        root.left.left.right.left=new TreeNode(4);
//        root.left.left.right.right=new TreeNode(6);
//        root.left.right=new TreeNode(11);
//        root.left.right.left=new TreeNode(9);
//        root.left.right.left.left=new TreeNode(8);
//        root.left.right.left.right=new TreeNode(10);
//        root.right=new TreeNode(3);
//        root.right.left=new TreeNode(16);
//        root.right.left.left=new TreeNode(14);
//        root.right.left.left.left=new TreeNode(13);
//        root.right.left.left.right=new TreeNode(15);
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(6);
        //root.right = new TreeNode(9);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);
        root.left.left.left.right = new TreeNode(3);
//        root.right.left.left = new TreeNode(6);
//        root.right.left.right = new TreeNode(8);
        root=new MaxSubtree().getMax(root);
        new DFSandBFS().DFS(root);
    }
    public TreeNode getMax(TreeNode root) {
        isSearchAndNodeNum(root);
        return node;
    }
    int[] isSearchAndNodeNum(TreeNode root){
        int[] r=new int[4];//isSearch/nodenum/min/max
        int min,max;
        if(root.left==null&&root.right==null){
            r[0]=1;
            r[1]=1;
            r[2]=root.val;
            r[3]=root.val;
            update(r[1],root);
            return r;
        }
        else if(root.right==null){
            r=isSearchAndNodeNum(root.left);
            if(r[0]==0) return r;
            else{
                max=r[3];//左子树的最大节点如果比root大是不行的
                if(root.val<max){
                    r[0]=0;
                    return r;
                }
                else{
                    r[1]+=1;
                    update(r[1],root);
                    return r;
                }
            }
        }
        else if(root.left==null){
            r=isSearchAndNodeNum(root.right);
            if(r[0]==0) return r;
            else{
                min=r[2];
                if(root.val>min){//右子树的最小节点比root小是不行的
                    r[0]=0;
                    return r;
                }
                else{
                    r[1]+=1;
                    update(r[1],root);
                    return r;
                }
            }
        }
        else{
            int[] rl=new int[4];
            int[] rr=new int[4];
            rl=isSearchAndNodeNum(root.left);
            rr=isSearchAndNodeNum(root.right);
            if(rl[0]==0||rr[0]==0){
                r[0]=0;
                return r;
            }
            else{
                if(root.val<rl[3]||root.val>rr[2]){
                    r[0]=0;
                    return r;
                }
                else{
                    r[0]=1;
                    r[1]=rl[1]+rr[1]+1;
                    r[2]=rl[2];
                    r[3]=rr[3];
                    update(r[1],root);
                    return r;
                }
            }
        }
    }
    void update(int num,TreeNode root){
        if(num>=n){
            n=num;
            node=root;
        }
    }
}