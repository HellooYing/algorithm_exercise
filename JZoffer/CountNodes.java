import java.util.*;

/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}*/
public class CountNodes {
    public int count(TreeNode root) {
        //先找root的深度，再找root右子树的深度，+1=root的话，最后一个点就至少在右子树上，不然就在左子树上
        //递归的返回树的节点数，如果是左子树少的话同层右子树的点数是层数-1的，是右子树的话是层数对应的
        if(root==null) return 0;
        int dl=getDepth(root.left);
        int dr=getDepth(root.right);
        if(dl==0&&dr==0) return 1;
        int num=0;
        if(dl==dr){
            num+=count(root.right);
            num+=Math.pow(2,dl-1)-1;
            num+=1;
            return num;
        }
        else{
            num+=count(root.left);
            num+=Math.pow(2,dr-1)-1;
            num+=1;
            return num;
        }
    }
    int getDepth(TreeNode root){
        if(root==null) return 0;
        int i=1;
        while(root!=null){
            root=root.left;
            i++;
        }
        return i;
    }
}