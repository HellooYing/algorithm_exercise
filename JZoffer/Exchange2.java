public class Exchange2 {
    public static void main(String[] args) throws Exception {
        System.out.println(new Exchange2().countWays(new int[]{1,2,4},3,3));
    }
    public int countWays(int[] penny, int n, int aim) {
        int[][] dp=new int[n][aim+1];
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=penny[0];i<=aim;i=i+penny[0]){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<=aim;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=penny[i]){
                    dp[i][j]+=dp[i][j-penny[i]];
                }
            }
        }
        return dp[n-1][aim];
    }
}