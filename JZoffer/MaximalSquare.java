/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix1) {
        if(matrix1.length==0) return 0;
        int[][] matrix=new int[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j]=matrix1[i][j]-48;
            }
        }
        int[][] dp=new int[matrix.length][matrix[0].length];
        for (int i = 0; i <matrix.length ; i++) {
            dp[i][0]=matrix[i][0];
        }
        for (int i = 0; i <matrix[0].length ; i++) {
            dp[0][i]=matrix[0][i];
        }
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j <matrix[0].length ; j++) {
                if(matrix[i][j]==1){
                    int a=dp[i-1][j];
                    int b=dp[i][j-1];
                    int c=dp[i-1][j-1];
                    int r=Math.min(Math.min(a,b),c);
                    dp[i][j]=r+1;
                }
            }
        }
        int max=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(max<dp[i][j]) max=dp[i][j];
            }
        }
        return max*max;
    }
}
