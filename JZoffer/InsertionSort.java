import java.util.*;

public class InsertionSort {
    public static void main(String[] args) throws Exception {
        int[] a={1,2,2,3,3,4,5};
        System.out.println(Arrays.toString(insertionSort(a,a.length)));
    }
    public static int[] insertionSort(int[] A, int n) {
        List<Integer> a=new ArrayList<Integer>();
        a.add(A[0]);
        //int l;
        int j;
        for(int i=1;i<n;i++){
            for(j=0;j<a.size();j++){
                if(A[i]<a.get(j)) break;
            }
            a.add(j,A[i]);
        }
        for(int i=0;i<n;i++){
            A[i]=a.get(i);
        }
        return A;
    }
}