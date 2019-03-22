import java.util.*;

public class FindGreatestSumOfSubArray {
    public static void main(String[] args) throws Exception {
        int[] a={6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray().answer(a));
    }

    public int answer(int[] a){
        //3min ok
        int sum=0,max=a[0];
        for(int i=0;i<a.length;i++){
            sum+=a[i];
            if(max<sum) max=sum;
            if(sum<0) sum=0;
        }
        return max;
    }
}