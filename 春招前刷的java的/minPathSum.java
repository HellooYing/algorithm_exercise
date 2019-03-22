import java.util.*;

public class minPathSum {
    public static void main(String[] args) throws Exception {
        int[][] a={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new minPathSum().answer(a));
    }

    public int answer(int[][] a){
        int m=a.length;
        if(m==0) return 0;
        int n=a[0].length;
        if(n==0) return 0;
        if(m==1&&n==1) return a[0][0];
        for(int i=1;i<m;i++) a[i][0]+=a[i-1][0];
        for(int i=1;i<n;i++) a[0][i]+=a[0][i-1];
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                a[i][j]=f(a,i,j);
            }
        }
        return a[m-1][n-1];
    }
    int f(int[][] a,int i,int j){
        if(a[i-1][j]>a[i][j-1]) return a[i][j-1]+a[i][j];
        else return a[i-1][j]+a[i][j];
    }
}