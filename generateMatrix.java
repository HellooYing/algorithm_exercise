import java.util.Arrays;

public class generateMatrix {
    public static void main(String[] args) throws Exception {
        int x = 3;
        int[][] a = new generateMatrix().answer(x); 
        for(int[] aa:a)
            for(int aaa:aa)
                System.out.println(aaa);
    }

    public int[][] answer(int n) {
        //arrayName = new type[n][n];
        int list[ ][ ] = new int[n][n];
        int i=n-1;
        int k=1;
        int m=n+1;
        int row=0;
        int col=n-1;
        int j;
        for(j=0;j<n;j++){
            list[0][j]=j+1;
        }
        while(i>0){
            switch(k%4){
                case 1:
                for(j=0;j<i;j++){//i=3;j=0,row=1,m=5;j=1,row=2,m=6;j=2,row=3,m=7;
                    row++;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 2:
                for(j=0;j<i;j++){
                    col--;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 3:
                for(j=0;j<i;j++){
                    row--;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 0:
                for(j=0;j<i;j++){
                    col++;
                    list[row][col]=m;
                    m++;
                }
                break;
            }
            if(k%2==0){
                i=i-1;
            }
            k++;
        }
        return list;
    }
}