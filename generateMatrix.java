import com.sun.tools.javac.code.Attribute.Array;

public class generateMatrix {
    public static void main(String[] args) throws Exception {
        int x = 3;
        int a = new generateMatrix().answer(x);
        System.out.println(a);
    }

    public int answer(int n) {
        //arrayName = new type[n][n];
        int list[ ][ ] = new int[n][n];
        int i=n-1;//第一行以外的，第一次竖着往下的次数。如n=4，则最右边往下走三次
        int k=1;//标志位，取余后0是list[row][col]的col加，1是row加，2是col减，3是row减，第一行手动加了所以从row加开始
        int m=n+1;//第一行以外的第一个数字，也就是list[1][n-1]=n+1
        int row=0;
        int col=n-1;

        //k=1时从list[0][n-1]开始3下，k=2从list[n-1][n-1]开始3下，k=3从list[n-1][0]开始2下，k=4从list[1][0]开始2下
        //所以执行i下的i的变化条件是k增大2时i减小1
        //k=5从list[1][n-2]开始1下，k=6从list[2][n-2]开始一下

        //k=1,因为k%4==1，所以row进行i=n-1=3次+1，当前位置从list[0][n-1]变成list[i][n-1]也就是list[n-1][n-1]
        //给list[1][n-1]到list[n-1][n-1]这i-1=n-2个单元赋的值是m=n+1到m=m+i-1=n+1+n-2也就是5到7
        //然后k=k+1=2，因为k%4==2，所以col进行i=n-1=3次-1，当前位置从list[n-1][n-1]变成list[n-1][0]
        //给list[n-1][n-2]到list[n-1][0]这n-2个单元赋的值是m=n+n到m=m+i-1也就是8到10
        //在k+1之前检验如果k是偶数就让i=i-1
        //则i是k为偶数时-1变化的，k是while i>0时递增的，m是每改变一下当前位置（也就是row、col）就+1的，
        //row、col是根据k%4的值加减变化的

        for(j=0;j<n;j++){//手动加第一行
            list[0][j]=j+1;
        }
        while(i>0){
            switch(k%4){
                case 1:
                for(ii=0;ii<i;ii++){//i=3;ii=0,row=1,m=5;ii=1,row=2,m=6;ii=2,row=3,m=7;
                    row++;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 2:
                for(ii=0;ii<i;ii++){
                    col--;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 3:
                for(ii=0;ii<i;ii++){
                    row--;
                    list[row][col]=m;
                    m++;
                }
                break;
                case 0:
                for(ii=0;ii<i;ii++){
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