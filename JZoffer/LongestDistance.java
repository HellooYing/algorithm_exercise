import java.util.*;


public class LongestDistance {
    public static void main(String[] args) throws Exception {
        //太傻x了 三目运算符忘了加括号，今天做二叉树的题卡死我了 怀疑人生
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(3);
        new Print().answer(root);
        System.out.println(new LongestDistance().findLongest(root));
    }
    int max;
    public int findLongest(TreeNode root) {
        max=0;
        f(root);
        return max;
    }
    int[] f(TreeNode root){
        int[] r=new int[2];
        int[] t;
        if(root.left==null&&root.right==null){
            return r;
        }
        else if(root.left==null){
            t=f(root.right);
            r[0]=0;
            r[1]=(t[0]>t[1]?t[0]:t[1])+1;
            if(max<r[0]+r[1]+1) max=r[0]+r[1]+1;
        }
        else if(root.right==null){
            t=f(root.left);
            r[1]=0;
            r[0]=(t[0]>t[1]?t[0]:t[1])+1;
            if(max<r[0]+r[1]+1) max=r[0]+r[1]+1;
        }
        else{
            t=f(root.left);
            r[0]=(t[0]>t[1]?t[0]:t[1])+1;
            t=f(root.right);
            r[1]=(t[0]>t[1]?t[0]:t[1])+1;
            if(max<r[0]+r[1]+1) max=r[0]+r[1]+1;
        }
        return r;
    }
}