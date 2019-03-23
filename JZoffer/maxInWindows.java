import java.util.*;
public class maxInWindows {
    public static void main(String[] args) throws Exception {
        int[] a = {2,3,4,2,6,2,5,1};
        int[] r=new maxInWindows().answer(a,3);
        System.out.println(Arrays.toString(r));
    }
    static int[] answer(int[] a,int size){
        //12min ok
        int[] r=new int[a.length-size+1];
        Deque<Integer> index=new LinkedList<Integer>();
        for(int i=0;i<a.length;i++){
            while(!index.isEmpty()&&index.peekFirst()<i-size+1) index.pollFirst();
            while(!index.isEmpty()&&a[index.peekLast()]<a[i]) index.pollLast();
            index.offerLast(i);
            if(i-size+1>=0){
                r[i-size+1]=a[index.peekFirst()];
            }
        }
        return r;
    }
}
