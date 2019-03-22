import java.util.*;

public class GetLeastNumbers_Solution {
    //15.5min
    public static void main(String[] args) throws Exception {
        int[] input={1,2,3,1,42,-127,532,20,-12};
        int k=4;
        System.out.println(new GetLeastNumbers_Solution().answer(input, k));
    }

    public ArrayList<Integer> answer(int [] input, int k){
        if(k>input.length) return new ArrayList<Integer>();
        buildHeap(input);
        for(int i=input.length-1;i>=input.length-k;i--){
            swap(input,0,i);
            adjust(input,0,i);
        }
        ArrayList<Integer> r=new ArrayList<Integer>();
        for(int i=input.length-1;i>=input.length-k;i--){
            r.add(input[i]);
        }
        return r;
    }
    private void buildHeap(int[] a){
        int nleaf=(int)Math.floor(a.length/2-1);
        for(int i=nleaf;i>=0;i--){
            adjust(a,i,a.length);
        }
    }
    private void adjust(int[] a,int root,int end){
        if(adjustThree(a,root,end)){
            if(2*root+1<end) adjust(a,2*root+1,end);
            if(2*root+2<end) adjust(a,2*root+2,end);
        }
    }
    private boolean adjustThree(int[] a,int root,int end){
        if(root*2+2>=end){
            if(root*2+1<end){
                if(a[root]>a[root*2+1]) swap(a,root,2*root+1);
            }
            return false;
        }
        if(a[root]<a[root*2+1]&&a[root]<a[root*2+2]) return false;
        if(a[root]>a[root*2+1]) swap(a,root,root*2+1);
        if(a[root]>a[root*2+2]) swap(a,root,2*root+2);
        return false;
    }
    private void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}