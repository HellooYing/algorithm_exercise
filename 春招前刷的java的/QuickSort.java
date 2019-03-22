import java.util.*;

public class QuickSort {
    public static void main(String[] args) throws Exception {
        int[] a={1,41,2,1,1,1,1,0,31,5,9,2,300,21,1,15,100};
        new QuickSort().answer(a);
        System.out.println(Arrays.toString(a));
    }

    public void answer(int[] a){
        //以最左为基准，先从最右找到比基准小的数，再从次左找到比基准大的数，直到两边相遇，交换基准和中间这个数。
        //为当前位置左边和右边递归调用自身，直到输入的最左最右相等。
        //为避免最左恰好为最坏数字的情况，先把最左与中间数进行交换
        qp(a,0,a.length-1);
    }
    void qp(int[] a,int l,int r){
        if(l>=r) return;
        swap(a,l,(r-l)/2+l);
        int i=l+1;
        int j=r;
        while(i!=j){
            while(a[j]>=a[l]&&j>i){//当a[j]比基准大且j比i大，j--。终止条件是i==j或者找到小于基准的数。
                j--;
            }
            while(a[i]<=a[l]&&j>i){//终止条件是i==j和找到比a[l]大的数
                i++;
            }
            swap(a,i,j);
        }
        swap(a,l,i);
        qp(a,l,i-1);
        qp(a,i+1,r);
    }
    void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}