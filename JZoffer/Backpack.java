/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class Backpack {
    public static void main(String[] args) {
        int[] w=new int[]{42,25,30,35,42,21,26,28};
        int[] v=new int[]{261,247,419,133,391,456,374,591};
        int n=w.length;
        int cap=297;
        System.out.println(new Backpack().maxValue(w,v,n,cap));
    }
    public int maxValue(int[] w, int[] v, int n, int cap) {
        int[][] dp=new int[cap+1][n];
        //背包负重0时什么也装不下
        for (int i = 0; i <n ; i++) {
            dp[0][i]=0;
        }
        for (int i = 0; i <cap+1 ; i++) {
            if(i<w[0]) continue;
            else dp[i][0]=v[0];
        }
        for (int i = 1; i < cap+1; i++) {
            for (int j = 1; j <n ; j++) {
                dp[i][j]=dp[i][j-1];
                if(i>=w[j]){
                    int value=dp[i-w[j]][j-1]+v[j];
                    if(dp[i][j]<value) dp[i][j]=value;
                }
            }
        }
        return dp[cap][n-1];
    }
}
