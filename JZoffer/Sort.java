import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhaole.myy
 * @date 2019/9/14
 */
public class Sort {
    public static void main(String[] args) {
        Sort sort=new Sort();
        int[] a=new int[]{7279,9784,9387,6620,1963,999,8505,8163,9496,3150,1607,2146,4783,7539,8751,6118,9793,2404,4871};
        sort.quickSort(a);
        int max=0;
        for (int i = 0; i <a.length-1 ; i++) {
            if(a[i+1]-a[i]>max) max=a[i+1]-a[i];
        }
        System.out.println(max);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int[] a){
        qs(a,0,a.length-1);
    }
    private void qs(int[] a,int left,int right){
        if(left>=right){
            return;
        }
        int base=a[left];
        int l=left,r=right;
        while (r>l){
            while(a[r]>base&&r>l) r--;
            while(a[l]<=base&&r>l) l++;
            swap(a,l,r);
        }
        swap(a,l,left);
        qs(a,left,l-1);
        qs(a,l+1,right);
    }

    public void mergeSort(int[] a){
        ms(a,0,a.length-1);
    }
    private void ms(int[] a,int l,int r){
        if(r<=l) return;
        int mid=(r+l)/2;
        ms(a,l,mid);
        ms(a,mid+1,r);
        merge(a,l,mid,r);
    }
    private void merge(int[] a,int l,int mid,int r){
        //l到mid是一个有序数组，mid到r是一个有序数组，将它们合并
        int[] b=new int[r-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=r){
            if(a[i]<a[j]){
                b[k++]=a[i++];
            }
            else{
                b[k++]=a[j++];
            }
        }
        while(i<=mid){
            b[k++]=a[i++];
        }
        while(j<=r){
            b[k++]=a[j++];
        }
        for (int m = 0; m <b.length ; m++) {
            a[l+m]=b[m];
        }
    }

    public void insertionSort(int[] a){
        List<Integer> list=new ArrayList<>();
        for (int i:a) {
            list.add(i);
        }
        int l=a.length;
        //对每个当前数字，找前面有序部分它应该在的位置插入进去
        for (int i = 0; i <a.length; i++) {
            //当前数字
            int n=list.get(i);
            //在当前数字前面找有没有比它大的,有就插入
            for (int j = 0; j < i; j++) {
                if(n<list.get(j)) {
                    list.remove(i);
                    list.add(j,n);
                    break;
                }
            }
        }
        for (int i = 0; i <l ; i++) {
            a[i]=list.get(i);
        }
    }

    public void heapSort(int[] a){
        //堆排序要做的事：先建堆，再每次把最上面的最大数字跟堆末位交换，堆末位就变成了有序，然后继续调整剩下的堆。
        buildHeap(a);
        for (int i = a.length-1; i >=0 ; i--) {
            swap(a,0,i);
            adjust(a,0,i);
        }
    }
    private void buildHeap(int[] a){
        //建堆要做的事：从最后面的非叶子节点开始调整堆
        int nleaf=(int)Math.floor(a.length/2)-1;
        for (int i = nleaf; i >=0 ; i--) {
            adjust(a,i,a.length);
        }
    }
    private void swap(int[] a,int i,int j){
        int n=a[i];
        a[i]=a[j];
        a[j]=n;
    }
    private void adjust(int[] a,int i,int length){
        //调整要做的事：先判断超没超范围，再跟两个孩子比较，然后再递归调整两个孩子
        //如果右孩子的位置已经超范围了
        if(i*2+2>=length){
            //左孩子位置没超范围
            if(i*2+1<length){
                if(a[i]<a[i*2+1]) swap(a,i,i*2+1);
            }
            return;
        }
        if(a[i]<a[i*2+1]) swap(a,i,i*2+1);
        if(a[i]<a[i*2+2]) swap(a,i,i*2+2);
        adjust(a,i*2+1,length);
        adjust(a,i*2+2,length);
    }
}
