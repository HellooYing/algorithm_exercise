import java.util.*;

public class hw201905252 {
    //寻找01矩阵中最大的正方形（全1或全0），限时五秒，直接暴力
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        int[][] m=new int[n][];
        for (int i = 0; i < n; i++) {
            String s=in.nextLine();
            int[] si=new int[s.length()];
            for (int j = 0; j <si.length ; j++) {
                si[j]=Integer.parseInt(s.substring(j,j+1));
            }
            m[i]=si;
        }
        new hw201905252().answer(m);
    }
    public void answer(int[][] m){
        if(m.length==0||m[0].length==0){
            System.out.println(0);
            return;
        }
        int r=1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j <m[0].length ; j++) {
                int rt=findMax(m,i,j);
                if(rt>r) r=rt;
            }
        }
        System.out.println(r*r);
    }
    int findMax(int[][] m,int i,int j){
        int r=1;
        //i行j列，i是纵坐标
        while(i+r-1<m.length&&j+r-1<m[0].length){
            for (int k = i; k < i+r; k++) {
                for (int l = j; l <j+r ; l++) {
                    if(m[k][l]!=m[i][j]) {
                        r--;
                        return r;
                    }
                }
            }
            r++;
        }
        r--;
        return r;
    }
}
