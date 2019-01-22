import java.util.*;

public class HeapSort {
    public static void main(String[] args) throws Exception {
        int[] a={1,41,2,31,5,9,2,300,21,1,15,100};
        new HeapSort().answer(a);
        System.out.println(Arrays.toString(a));
    }

    public void answer(int[] a){
        int l=a.length;
        for(int i=l/2-1;i>=0;i--){//从第一个非叶子节点开始把数组变成大根堆
            adjust(a,i,l);
        }
        for(int i=l;i>0;i--){
            int t=a[i-1];
            a[i-1]=a[0];
            a[0]=t;
            adjust(a,0,i-1);
        }
    }
    void adjust(int[] a,int i,int j){
        //i的子节点是2*i+1和2*i+2
        if(2*i+2<j){//如果两个子节点都存在且在调整范围内
            if(a[i]>a[2*i+1]&&a[i]>a[2*i+2]) return;//子节点都小于根节点，不需要调整，直接返回
        }
        else if(2*i+1<j){//如果只有左子节点在调整范围内
            if(a[i]>a[2*i+1]) return;//不需要调整直接返回
        }
        else return;//如果都不在调整范围内，直接返回
        if(2*i+2==j||a[2*i+1]>a[2*i+2]){//如果左子节点比右子节点大，则交换根节点和左子节点并继续调整以左子节点为根节点的子树。
            int t=a[2*i+1];
            a[2*i+1]=a[i];
            a[i]=t;
            adjust(a,2*i+1,j);
        }
        else{
            int t=a[2*i+2];
            a[2*i+2]=a[i];
            a[i]=t;
            adjust(a,2*i+2,j);
        }
    }
}