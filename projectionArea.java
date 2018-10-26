import java.util.*;
public class projectionArea {
    public static void main(String[] args) throws Exception {
        int[][] grid={{1,0},{0,2}};
        int a = new projectionArea().answer(grid);
        System.out.println(a);
    }

    public int answer(int[][] grid) {
        int result;
        int n=grid.length;
        int xy=(int)Math.pow(n,2),yz=0,xz=0;
        int[] ym=new int[n];
        int xm=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) xy--;
                if(ym[j]<grid[i][j]) ym[j]=grid[i][j];
                if(xm<grid[i][j]) xm=grid[i][j];
            }
            xz+=xm;
            xm=0;
        }
        for(int k=0;k<n;k++) yz+=ym[k];
        result=xy+yz+xz;
        return result;
    }
}