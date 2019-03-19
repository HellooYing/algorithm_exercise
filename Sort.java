import java.util.*;

public class Sort {
    public static void main(String[] args) throws Exception {
        int[] arr={10,2,103,-24,-6,1,-10,10,25,234,654,-158,107,6,5,-4,0};
        new Sort().qs(arr,0,arr.length-1);
        //new Sort().mergeSort(arr, 0, arr.length-1);
        //new Sort().shellSort(arr, (int)Math.floor(arr.length/3));
        //new Sort().heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] a){
        if(a.length<2) return;
        buildHeap(a);
        
        for(int i=a.length-1;i>=0;i--){
            swap(a, i, 0);
            adjustHeap(a, 0, i);
        }
    }

    private void adjustHeap(int[] a,int root,int end){
        if(adjustThree(a, root, end)){
            adjustHeap(a, 2*root+1, end);
            adjustHeap(a, 2*root+2, end);
        }
    }

    private void buildHeap(int[] a){
        int nleaf=(int)Math.floor(a.length/2)-1;
        for(int i=nleaf;i>=0;i--){
            if(adjustThree(a, i,a.length)){
                if(2*i+1<a.length) adjustHeap(a, 2*i+1, a.length);
                if(2*i+2<a.length) adjustHeap(a, 2*i+2, a.length);
            }
        }
    }

    private boolean adjustThree(int[] a,int root,int end){
        if(2*root+2>=end){
            if(2*root+1<end){
                if(a[root]<a[2*root+1]) swap(a,root,2*root+1);
            }
            return false;
        }
        if(a[root]>=a[2*root+1]&&a[root]>=a[2*root+2]) 
            return false;
        if(a[root]<a[2*root+1]) swap(a, root, 2*root+1);
        if(a[root]<a[2*root+2]) swap(a, root, 2*root+2);
        return true;//need to adjust
    }

    public void shellSort(int[] a,int step){
        //5min，ok
        if(step<1) return;
        for(int i=step;i<a.length;i++){
            int j=i;
            while(j-step>=0&&a[j]<a[j-step]){
                swap(a,j,j-step);
                j-=step;
            }
        }
        shellSort(a, step-1);
    }

    public void mergeSort(int[] a,int l,int r){
        //14min，with bug，need to do again
        if(l>=r) return;
        int mid=(int)Math.floor((l+r)/2);
        mergeSort(a, l, mid);
        mergeSort(a, mid+1, r);
        merge(a,l,mid,r);
    }
    
    private void merge(int[] a,int l,int mid,int r){
        int[] b=new int[r-l+1];
        int l1=l,r1=mid+1,i=0;
        for(;i<b.length&&l1<=mid&&r1<=r;i++){
            if(a[l1]<a[r1]){
                b[i]=a[l1];
                l1++;
            }
            else{
                b[i]=a[r1];
                r1++;
            }
        }
        while(l1<=mid){
            b[i]=a[l1];
            i++;
            l1++;
        }
        while(r1<=r){
            b[i]=a[r1];
            r1++;
            i++;
        }
        for(int j=l;j<=r;j++){
            a[j]=b[j-l];
        }
    }
    public void quickSort(int[] a,int start,int end){
        //8min,with bug,need to do again
        if(start>=end) return;
        int q=start,p=end;
        int base=a[start];
        while(q<p){
            while(a[p]>base&&q<p) p--;
            while(a[q]<=base&&q<p) q++;
            swap(a,p,q);
        }
        swap(a,start,p);
        quickSort(a, start, p-1);
        quickSort(a, p+1, end);
    }
    private void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}