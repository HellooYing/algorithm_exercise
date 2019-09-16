/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class LCS {
    public static void main(String[] args) {
        String s1="1A2C3D4B56";
        String s2="B1D23CA45B6A";
        System.out.println(new LCS().findLCS(s1,0,s2,0));
    }
    public int findLCS(String A, int n, String B, int m) {
        int[][] dp=new int[A.length()+1][B.length()+1];
        for (int i = 1; i <A.length()+1 ; i++) {
            for (int j = 1; j <B.length()+1 ; j++) {
                int a=dp[i-1][j];
                int b=dp[i][j-1];
                int r=Math.max(a,b);
                if(A.charAt(i-1)==B.charAt(j-1)){
                    r=Math.max(r,dp[i-1][j-1]+1);
                }
                dp[i][j]=r;
            }
        }
        return dp[A.length()][B.length()];
    }
}
