import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class Exchange {
    public static void main(String[] args) {
        Exchange exchange=new Exchange();
        int[] penny=new int[]{3,4,7};
        int aim=33;
        System.out.println(exchange.countWays(penny,penny.length,aim));
    }
    public int countWays(int[] penny, int n, int aim) {
        /**
         * 题目
         * 有数组penny，penny中所有的值都为正数且不重复。每个值代表一种面值的货币，
         * 每种面值的货币可以使用任意张，再给定一个整数aim(小于等于1000)代表要找的钱数，求换钱有多少种方法。
         * 给定数组penny及它的大小(小于等于50)，同时给定一个整数aim，请返回有多少种方法可以凑成aim。
         *
         * 解法
         *
         */
        int[][] dp=new int[aim+1][penny.length];
        for (int i = 0; i <aim+1 ; i+=penny[0]) {
            dp[i][0]=1;
        }
        for (int i = 0; i <penny.length ; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <aim+1 ; i++) {
            for (int j = 1; j <penny.length; j++) {
                dp[i][j]=dp[i][j-1];
                //如果aim大于当前货币值
                if(i>=penny[j]){
                    dp[i][j]+=dp[i-penny[j]][j];
                }
            }
        }
        return dp[aim][penny.length-1];
    }
}
