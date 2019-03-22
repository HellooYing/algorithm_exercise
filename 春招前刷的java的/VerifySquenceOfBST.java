import java.util.*;

public class VerifySquenceOfBST {
    public static void main(String[] args) throws Exception {
        int[] sequence={7,4,3,8,5,2};
        System.out.println(new VerifySquenceOfBST().answer(sequence));
    }
//思路就是对每个子树看它是否有两个跳变点。所以步骤就是1.找到子树 2.找跳变点 3.是否有多的跳变点
    boolean answer(int[] tree){
        if(tree.length==0) return false;
        else return dg(tree);
    }
    int divide(int[] son){
        int root=son[son.length-1];
        int i;
        if(son[0]>root){//如果第一个都比跟节点大，那全是右子树
            if(rightok(Arrays.copyOfRange(son,0,son.length-1),root)) return 0;
            else return -1;
        }
        for(i=0;i<son.length-1;i++){//先找到左右子树跳变那个点
            if(i==son.length-2) return son.length-1;//如果没有跳变点则说明全是左子树
            if(son[i]<root&&son[i+1]>root) break;
        }
        if(i+1>son.length-1||rightok(Arrays.copyOfRange(son,i+1,son.length-1),root)) return i+1;
        else return -1;
    }
    boolean rightok(int[] a,int root){
        if(a.length==0) return true;
        for(int aa:a){
            if(aa<root) return false;
        }
        return true;
    }
    boolean dg(int[] tree){
        if(tree.length==0||tree.length==1) return true;
        int i=divide(tree);
        if(i==-1) return false;
        if(dg(Arrays.copyOfRange(tree,0,i))==false)
            return false;
        if(dg(Arrays.copyOfRange(tree,i,tree.length-1))==false) 
            return false;
        return true;
    }
}