import java.util.*;

public class uniquePaths {
    public static void main(String[] args) throws Exception {
        int[][] a={{0},{0}};
        System.out.println(new uniquePaths().answer2(a));
    }

    public int answer(int m, int n){
        if(m<1&&n<1) return 0;
        int[][] p=new int[m][n];
        for(int i=0;i<m;i++) p[i][0]=1;
        for(int i=0;i<n;i++) p[0][i]=1;
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                p[i][j]=f(p,i,j);
            }
        }
        return p[m-1][n-1];
    }
    int f(int[][] p,int i,int j){
        return p[i-1][j]+p[i][j-1];
    }
    public int answer2(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m<1&&n<1) return 0;
        int[][] p=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==0) p[i][j]=1;//这样就是，通路为1，障碍物为0
            }
        }
        boolean flag=true;
        for(int i=0;i<m;i++){
            if(p[i][0]!=0&&flag==true) p[i][0]=1; //刚开始，没遇到障碍，不是0就置1.
            else{
                flag=false;
                p[i][0]=0;//障碍后面的全是0
            }
        }
        flag=true;
        for(int i=0;i<n;i++) {
            if(p[0][i]!=0&&flag==true) p[0][i]=1; //刚开始，没遇到障碍，不是0就置1.
            else{
                flag=false;
                p[0][i]=0;//障碍后面的全是0
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                p[i][j]=f2(p,i,j);
            }
        }
        return p[m-1][n-1];
    }
    int f2(int[][] p,int i,int j){
        if(p[i][j]==0) return 0;
        else return p[i-1][j]+p[i][j-1];
    }
}