import java.util.*;

public class FindPath {
    ArrayList<ArrayList<Integer>> r=new ArrayList<ArrayList<Integer>>();
    
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {
        TreeNode a1= new TreeNode(1);
        System.out.println(new FindPath().answer(a1,1));
    }

    public ArrayList<ArrayList<Integer>> answer(TreeNode root,int target){
        ArrayList<Integer> inr=new ArrayList<Integer>();
        inr.add(root.val);
        if(root.left==null&&root.right==null){
            int j=0;
            for(int jj:inr) j=j+jj;
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.addAll(inr);
            if(j==target){
                if(r.size()==0||r.get(r.size()-1).size()<t.size()) r.add(t);
                else{
                    for(int q=0;q<r.size();q++){
                        if(r.get(q).size()>t.size()){
                            r.add(q,t);
                            break;
                        }
                    }
                }
            }
        }
        if(root.left!=null){
            dg(inr,0,root.left,target);
        }
        removei(inr,0);
        if(root.right!=null){
            dg(inr,0,root.right,target);
        }
        Collections.reverse(r);
        return r;
    }
    void dg(ArrayList<Integer> inr,int i,TreeNode root,int target){
        i++;
        inr.add(root.val);
        if(root.left==null&&root.right==null){
            int j=0;
            for(int jj:inr) j=j+jj;
            ArrayList<Integer> t=new ArrayList<Integer>();
            t.addAll(inr);
            if(j==target){
                if(r.size()==0||r.get(r.size()-1).size()<t.size()) r.add(t);
                else{
                    for(int q=0;q<r.size();q++){
                        if(r.get(q).size()>t.size()){
                            r.add(q,t);
                            break;
                        }
                    }
                }
            }
        }
        if(root.left!=null){
            dg(inr,0,root.left,target);
        }
        removei(inr,i);
        if(root.right!=null){
            dg(inr,0,root.right,target);
        }
    }
    void removei(ArrayList<Integer> inr,int i){
        while(inr.size()-1>i){
            inr.remove(inr.size()-1);
        }
    }
}