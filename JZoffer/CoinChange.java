import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] a=new int[]{2};
        int amount = 3;
        System.out.println(new CoinChange().coinChange(a,amount));
    }
    public int coinChange(int[] coins, int amount) {
        int[] nums=new int[amount+1];//用多少枚硬币可达该amount的最小数目
        nums[0]=0;
        for (int i = 1; i <amount+1 ; i++) {
            nums[i]=-1;
        }
        //对每个coins，更新开始能用它抵达的aim
        for (int i = 0; i <coins.length ; i++) {//i代表前i个硬币可用
            int money=coins[i];//这次新可用的货币
            for (int j = 1; j <amount+1 ; j++) {//j代表目标金额
                //如果目标金额大于当前币值
                if(j>=coins[i]){
                    if(nums[j-coins[i]]!=-1) {
                        int newValue=nums[j-coins[i]]+1;//可能的硬币数变成金额-币值的最少硬币+1个硬币
                        if(nums[j]==-1) nums[j]=newValue;
                        else{
                            nums[j]=Math.min(newValue,nums[j]);
                        }
                    }
                }
            }
        }
        return nums[amount];
    }
}
