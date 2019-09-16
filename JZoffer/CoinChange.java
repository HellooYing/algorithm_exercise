import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,5};
        int amount = 100;
        System.out.println(new CoinChange().coinChange(a,amount));
    }
    Map<Integer,Integer> map;
    public int coinChange(int[] coins, int amount) {
        map=new HashMap<>();
        return dg(coins,amount);
    }
    private int dg(int[] coins,int amount){
        if(map.containsKey(amount)) {
            return map.get(amount);
        }
        if(amount==0) return 0;
        int[] r=new int[coins.length];
        for (int i = 0; i <coins.length ; i++) {
            if(amount-coins[i]>=0) r[i]=dg(coins,amount-coins[i]);
            else r[i]=-1;
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < r.length; i++) {
            if(r[i]!=-1&&r[i]<min) min=r[i];
        }
        if(min==Integer.MAX_VALUE){
            map.put(amount,-1);
            return -1;
        }
        else{
            map.put(amount,min+1);
            return min+1;
        }
    }
}
