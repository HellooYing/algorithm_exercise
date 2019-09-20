import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/20
 */
public class tx2019092004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        int k=sc.nextInt();
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }

        sc.close();
        answer(a,k);
    }
    //找出最小的k个元素，然后依次输出value-sum
    private static void answer(int[] a,int k){
        buildHeap(a);
        //System.out.println(Arrays.toString(a));
        int sum=0;
        int i=a.length-1;
        int sout=0;
        while(sout<k&&i>=0){
            swap(a,0,i);
            adjust(a,0,i);
            int newValue=a[i];
            if(newValue-sum>0){
                sout++;
                System.out.println(newValue-sum);
                sum+=newValue-sum;
            }
            i--;
        }
        while (sout<k){
            System.out.println(0);
            sout++;
        }
    }
    public static void heapSort(int[] a,int k){
        //堆排序要做的事：先建堆，再每次把最上面的最大数字跟堆末位交换，堆末位就变成了有序，然后继续调整剩下的堆。

    }
    private static void buildHeap(int[] a){
        //建堆要做的事：从最后面的非叶子节点开始调整堆
        int nleaf=a.length/2-1;
        for (int i = nleaf; i >=0 ; i--) {
            adjust(a,i,a.length);
        }
    }
    private static void swap(int[] a,int i,int j){
        int n=a[i];
        a[i]=a[j];
        a[j]=n;
    }
    private static void adjust(int[] a,int i,int length){
        //调整要做的事：先判断超没超范围，再跟两个孩子比较，然后再递归调整两个孩子
        //如果右孩子的位置已经超范围了
        if(i*2+2>=length){
            //左孩子位置没超范围
            if(i*2+1<length){
                if(a[i]>a[i*2+1]) swap(a,i,i*2+1);
            }
            return;
        }
        if(a[i]>a[i*2+1]) swap(a,i,i*2+1);
        if(a[i]>a[i*2+2]) swap(a,i,i*2+2);
        adjust(a,i*2+1,length);
        adjust(a,i*2+2,length);
    }
}
