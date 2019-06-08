import java.util.Arrays;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像原地顺时针旋转 90 度。
 */
public class rotate {
    public static void main(String[] args) {
       int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
       new rotate().answer(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public void answer(int[][] matrix) {
        //倒序一下，再按对角线交换一下
        reverse(matrix);
        exchange(matrix);
    }
    void exchange(int[][] matrix){
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = i+1; j <matrix.length ; j++) {
                int t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }
    }

    void reverse(int[][] matrix){
        int i=0,j=matrix.length-1;
        while(i<j){
            for (int k = 0; k <matrix[i].length ; k++) {
                int t=matrix[i][k];
                matrix[i][k]=matrix[j][k];
                matrix[j][k]=t;
            }
            i++;
            j--;
        }
    }
}
