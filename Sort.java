import java.util.*;

public class Sort {
    public static void main(String[] args) throws Exception {
        int[] arr={10,43,-213,123,-9,12,657,-9,67,34,-1,0,10,-43,28,136,765,-345,-96,0};
        //new Sort().quickSort(arr,0,arr.length-1);
        //new Sort().mergeSort(arr, 0, arr.length-1);
        //new Sort().shellSort(arr, (int)Math.floor(arr.length/3));
        //new Sort().heapSort(arr);
        //new Sort().bucketSort(arr, 10, -200, 800);
        //new Sort().radixSort(arr, 3);
        new Sort().radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
        System.out.println("[-345, -213, -96, -43, -9, -9, -1, 0, 0, 10, 10, 12, 28, 34, 43, 67, 123, 136, 657, 765]");
    }
    public int[] radixSort(int[] A, int n) {
        //忘了清理二维list了……19min
            int m=A[0],t,t1;
            for(int i=1;i<n;i++){
                if(m<A[i]) m=A[i];
            }
            m=String.valueOf(m).length();
            List<List<Integer>> a=new ArrayList<List<Integer>>();
            for(int i=0;i<19;i++){
                a.add(new ArrayList<Integer>());
            }
            for(int i=1;i<=m;i++){
                for(int j=0;j<n;j++){
                    t=getn(A[j],i);
                    a.get(t+9).add(A[j]);
                }
                t1=0;
                for(int j=0;j<19;j++){
                    for(int k=0;k<a.get(j).size();k++){
                        System.out.println(a);

                        A[t1]=a.get(j).get(k);
                        t1++;
                    }
                    a.get(j).clear();
                }
            }
            return A;
        }
        private int getn(int i,int n){//获取数字i个位起第n位的数字
            int a=1;
            for(int j=0;j<n-1;j++) a*=10;
            i=(int)Math.floor(i/a);
            return i%10;
        }


//    static public void radixSort(int[] a,int nlength){
//        //7.5min good
//        List<List<Integer>> b=new ArrayList<List<Integer>>();
//        List<Integer> c;
//        for(int i=0;i<19;i++){
//            c=new ArrayList<Integer>();
//            b.add(c);
//        }
//        for(int i=0;i<nlength;i++){
//            for(int j=0;j<19;j++){
//                c=b.get(j);
//                c.clear();
//            }
//            for(int j=0;j<a.length;j++){
//                c=b.get(getn(a[j], i+1)+9);
//                c.add(a[j]);
//            }
//            int d=0;
//            for(int j=0;j<19;j++){
//                c=b.get(j);
//                for(int k=0;k<c.size();k++){
//                    a[d]=c.get(k);
//                    d++;
//                }
//            }
//        }
//    }
//    static private int getn(int num,int position){
//        int a=1;
//        for(int i=1;i<position;i++) a*=10;
//        num=(int)Math.floor(num/a);
//        num=num%10;
//        return num;
//    }









    
    // static public void radixSort(int[] a,int nlength){
    //     //43min disaster
    //     List<List<Integer>> b=new ArrayList<List<Integer>>();
    //     List<Integer> c;
    //     for(int i=0;i<19;i++){
    //         c=new ArrayList<Integer>();
    //         b.add(c);
    //     }
    //     for(int i=0;i<nlength;i++){
    //         for(int j=0;j<19;j++){
    //             b.get(j).clear();
    //         }
    //         for(int j=0;j<a.length;j++){
    //             c=b.get(getn(a[j],i+1)+10);
    //             c.add(a[j]);
    //         }
    //         int d=0;
    //         for(int j=0;j<b.size();j++){
    //             c=b.get(j);
    //             for(int k=0;k<c.size();k++){
    //                 a[d]=c.get(k);
    //                 //System.out.println(Arrays.toString(a));
    //                 d++;
    //             }
    //         }
    //         System.out.println(b);
    //     }        
    // }

    // static private int getn(int i,int position){
    //     int a=1;
    //     for(int j=0;j<position-1;j++){
    //         a*=10;
    //     }
    //     int r=(int)(i/a)%10;
    //     return r;
    // }





    static public void bucketSort(int[] a,int n,int low,int high){
        //12min
        int step=(int)Math.floor((high-low)/n);
        List<List<Integer>> buckets=new ArrayList<List<Integer>>();
        List<Integer> bucket;
        for(int i=0;i<n;i++){
            bucket=new ArrayList<Integer>();
            buckets.add(bucket);
        }
        for(int i=0;i<a.length;i++){
            for(int j=1;j<=n;j++){
                if(a[i]<low+j*step){
                    bucket=buckets.get(j-1);
                    Insert(bucket,a[i]);
                    break;
                }
            }
        }
        int k=0;
        for(int i=0;i<buckets.size();i++){
            bucket=buckets.get(i);
            for(int j=0;j<bucket.size();j++){
                a[k]=bucket.get(j);
                k++;
            }
        }
    }
    private static void Insert(List<Integer> bucket,int i){
        int l=bucket.size();
        if(l==0){
            bucket.add(i);
            return;
        }
        for(int j=0;j<l;j++){
            if(bucket.get(j)>i){
                bucket.add(j,i);
                break;
            }
        }
        if(l==bucket.size()){
            bucket.add(i);
        }
    }




    //bucketSort assume data range -200~800, bucket num 10

    // static private void bucketSort(int[] a,int n,int low,int high){
    //     //21.5min with bug(without 2 break)
    //     int step=(int)Math.floor((high-low)/n);
    //     List<List<Integer>> buckets=new ArrayList<List<Integer>>();
    //     List<Integer> bucket;
    //     for(int i=0;i<n;i++){
    //         bucket=new ArrayList<Integer>();
    //         buckets.add(bucket);
    //     }
    //     for(int i=0;i<a.length;i++){
    //         for(int j=1;j<=n;j++){
    //             if(a[i]<low+j*step){
    //                 insert(a[i],buckets.get(j-1));
    //                 break;
    //             }
    //         }
    //     }
    //     int k=0;
    //     for(int i=0;i<buckets.size();i++){
    //         bucket=buckets.get(i);
    //         for(int j=0;j<bucket.size();j++){
                
    //             a[k]=bucket.get(j);
    //             k++;
    //         }
    //     }
    // }

    // static private void insert(int i,List<Integer> b){
    //     if(b.size()==0){
    //         b.add(i);
    //         return;
    //     }
    //     int l=b.size();
    //     for(int j=0;j<l;j++){
    //         if(i<b.get(j)){
    //             b.add(j, i);
    //             break;
    //         }
    //     }
    //     if(l==b.size()) {
    //         b.add(i);
    //     }
    // }










    public void shellSort(int[] a,int step){
        //1.5min ok
        if(step==0) return;
        for(int i=step;i<a.length;i++){
            int j=i;
            while(j-step>=0){
                if(a[j]<a[j-step]) swap(a,j,j-step);
                j-=step;
            }
        }
        shellSort(a,step-1);
    }

    public void mergeSort(int[] a,int l,int r){
        //5min ok
        if(l>=r) return;
        int mid=(int)Math.floor((l+r)/2);
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }
    private void merge(int[] a,int l,int mid,int r){
        int[] b=new int[r-l+1];
        int k=0,i=l,j=mid+1;
        while(k<b.length&&i<=mid&&j<=r){
            if(a[i]<a[j]) b[k++]=a[i++];
            else b[k++]=a[j++];
        }
        while(i<=mid) b[k++]=a[i++];
        while(j<=r) b[k++]=a[j++];
        for(int c=0;c<b.length;c++){
            a[l+c]=b[c];
        }
    }

    public void quickSort(int[] a,int l,int r){
        //3.5min ok
        if(l>=r) return;
        int base=a[l],p=r,q=l;
        while(p>q){
            while(a[p]>base&&p>q) p--;
            while(a[q]<=base&&p>q) q++;
            swap(a,p,q);
        }
        swap(a,l,p);
        quickSort(a,l,p-1);
        quickSort(a,p+1,r);
    }

    public void heapSort(int[] a){
        //8.5min,ok
        buildHeap(a);
        for(int i=a.length-1;i>=0;i--){
            swap(a,0,i);
            adjust(a,0,i);
        }
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
        if(2*root+2>=end){
            if(2*root+1<end){
                if(a[root]<a[2*root+1]) swap(a,root,2*root+1);
            }
            return false;
        }
        if(a[root]>a[2*root+1]&&a[root]>a[2*root+2]) return false;
        if(a[root]<a[2*root+1]) swap(a,root,2*root+1);
        if(a[root]<a[2*root+2]) swap(a,root,2*root+2);
        return true;
    }
















//    public void heapSort(int[] a){
//        if(a.length<2) return;
//        buildHeap(a);
//
//        for(int i=a.length-1;i>=0;i--){
//            swap(a, i, 0);
//            adjustHeap(a, 0, i);
//        }
//    }
//
//    private void adjustHeap(int[] a,int root,int end){
//        if(adjustThree(a, root, end)){
//            adjustHeap(a, 2*root+1, end);
//            adjustHeap(a, 2*root+2, end);
//        }
//    }
//
//    private void buildHeap(int[] a){
//        int nleaf=(int)Math.floor(a.length/2)-1;
//        for(int i=nleaf;i>=0;i--){
//            if(adjustThree(a, i,a.length)){
//                if(2*i+1<a.length) adjustHeap(a, 2*i+1, a.length);
//                if(2*i+2<a.length) adjustHeap(a, 2*i+2, a.length);
//            }
//        }
//    }
//
//    private boolean adjustThree(int[] a,int root,int end){
//        if(2*root+2>=end){
//            if(2*root+1<end){
//                if(a[root]<a[2*root+1]) swap(a,root,2*root+1);
//            }
//            return false;
//        }
//        if(a[root]>=a[2*root+1]&&a[root]>=a[2*root+2])
//            return false;
//        if(a[root]<a[2*root+1]) swap(a, root, 2*root+1);
//        if(a[root]<a[2*root+2]) swap(a, root, 2*root+2);
//        return true;//need to adjust
//    }
//
//    public void shellSort(int[] a,int step){
//        //5min，ok
//        if(step<1) return;
//        for(int i=step;i<a.length;i++){
//            int j=i;
//            while(j-step>=0&&a[j]<a[j-step]){
//                swap(a,j,j-step);
//                j-=step;
//            }
//        }
//        shellSort(a, step-1);
//    }
//
//    public void mergeSort(int[] a,int l,int r){
//        //14min，with bug，need to do again
//        if(l>=r) return;
//        int mid=(int)Math.floor((l+r)/2);
//        mergeSort(a, l, mid);
//        mergeSort(a, mid+1, r);
//        merge(a,l,mid,r);
//    }
//
//    private void merge(int[] a,int l,int mid,int r){
//        int[] b=new int[r-l+1];
//        int l1=l,r1=mid+1,i=0;
//        for(;i<b.length&&l1<=mid&&r1<=r;i++){
//            if(a[l1]<a[r1]){
//                b[i]=a[l1];
//                l1++;
//            }
//            else{
//                b[i]=a[r1];
//                r1++;
//            }
//        }
//        while(l1<=mid){
//            b[i]=a[l1];
//            i++;
//            l1++;
//        }
//        while(r1<=r){
//            b[i]=a[r1];
//            r1++;
//            i++;
//        }
//        for(int j=l;j<=r;j++){
//            a[j]=b[j-l];
//        }
//    }
//    public void quickSort(int[] a,int start,int end){
//        //8min,with bug,need to do again
//        if(start>=end) return;
//        int q=start,p=end;
//        int base=a[start];
//        while(q<p){
//            while(a[p]>base&&q<p) p--;
//            while(a[q]<=base&&q<p) q++;
//            swap(a,p,q);
//        }
//        swap(a,start,p);
//        quickSort(a, start, p-1);
//        quickSort(a, p+1, end);
//    }
    private void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}