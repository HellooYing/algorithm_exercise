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
public class TreeToSequence {
    //33min 后序遍历非递归有点难想
    public int[][] convert(TreeNode root) {
        List<Integer> q=new ArrayList<Integer>();
        List<Integer> z=new ArrayList<Integer>();
        List<Integer> h=new ArrayList<Integer>();
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode r;
        s.push(root);
        while(!s.isEmpty()){
            r=s.pop();
            q.add(r.val);
            if(r.right!=null) s.push(r.right);
            if(r.left!=null) s.push(r.left);
        }

        r=root;
        while(r!=null){
            s.push(r);
            r=r.left;
        }
        while(!s.isEmpty()){
            r=s.pop();
            z.add(r.val);
            if(r.right!=null){
                r=r.right;
                s.push(r);
                while(r.left!=null){
                    r=r.left;
                    s.push(r);
                }
            }
        }
        r=root;
        TreeNode last=root,t;
        while(r!=null){
            s.push(r);
            r=r.left;
        }
        while(!s.isEmpty()){
            r=s.pop();
            if(r.right!=null&&last!=r.right){
                s.push(r);
                t=r.right;
                s.push(t);
                while(t.left!=null){
                    t=t.left;
                    s.push(t);
                }
            }
            else{
                h.add(r.val);
                last=r;
            }
        }
        int[][] re=new int[3][];
        re[0]=zh(q);
        re[1]=zh(z);
        re[2]=zh(h);
        return re;
    }
    int[] zh(List<Integer> l){
        int[] r=new int[l.size()];
        for(int i=0;i<l.size();i++){
            r[i]=l.get(i);
        }
        return r;
    }
}