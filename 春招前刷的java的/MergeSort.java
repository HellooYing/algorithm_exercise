import java.util.*;

public class MergeSort {
    public static void main(String[] args) throws Exception {
        int[] a={1,41,2,1,1,1,1,0,31,5,9,2,300,21,1,15,100};
        new MergeSort().answer(a);
        System.out.println(Arrays.toString(a));
    }

    public void answer(int[] a){
        int[] b=new int[a.length];
        mergesort(a,0,a.length-1,b);
    }
    void mergesort(int[] a,int l,int r,int[] b){
        if(l>=r) return;
        int m=(l+r)/2;
        mergesort(a,l,m,b);
        mergesort(a,m+1,r,b);
        merge(a,l,m,r,b);
    }
    void merge(int[] a,int l,int m,int r,int[] c){
        if(l>=r) return;
        int i=l,j=m+1,k=0;
        while(k<r&&i<=m&&j<=r){
            if(a[i]<a[j]) c[k++]=a[i++];
            else c[k++]=a[j++];
        }
        while(i<=m) c[k++]=a[i++];
        while(j<=r) c[k++]=a[j++];
        k=0;
        while(l<=r) a[l++]=c[k++];
    }
}