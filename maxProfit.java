import java.util.*;

public class maxProfit {
    public static void main(String[] args) throws Exception {
        int[] prices={7,1,5,3,6,4};
        System.out.println(new maxProfit().answer(prices));
    }

    public int answer(int[] prices){
        if(prices.length<=1||jx(prices)) return 0;
        int[] q=new int[prices.length];
        int[] h=new int[prices.length];
        q[0]=prices[0];
        h[0]=prices[prices.length-1];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<q[i-1]) q[i]=prices[i];
            else q[i]=q[i-1];
            if(prices[prices.length-1-i]>h[i-1]) h[i]=prices[prices.length-1-i];
            else h[i]=h[i-1];
        }
        int max=h[prices.length-1]-q[0];
        for(int i=1;i<prices.length;i++){
            if(max<h[prices.length-1-i]-q[i]) max=h[prices.length-1-i]-q[i];
        }
        return max;
    }
    boolean jx(int[] a){
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]) return false;
        }
        return true;
    }
}