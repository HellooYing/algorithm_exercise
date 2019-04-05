import java.util.Arrays;
import java.util.Scanner;

public class tx201904051 {
    static int[] need;
    static int[][] money;
    static int[] moneynum;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=in.nextInt();
        int n=in.nextInt();//n种钱
        int[] a=new int[n];
        need=new int[m+1];
        money=new int[m+1][n];//m个值，分别用了哪些钱几张
        moneynum=new int[n];//n种钱每个钱要几张
        for(int i=0;i<m+1;i++) need[i]=-1;
        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        in.close();
        answer(m,a);
    }
    static void answer(int m,int[] a){
        for(int i=1;i<m+1;i++){
            f(i,a);
        }
        int r=0;
        for(int i=0;i<moneynum.length;i++) r+=moneynum[i];
        System.out.println(r);
        System.out.println(Arrays.toString(need));
        System.out.println(Arrays.toString(moneynum));
        System.out.println(Arrays.deepToString(money));
    }
    static void f(int target,int[] a){
        int[] b=new int[a.length];//必用某张钱+前面的面值组合
        int[][] c=new int[a.length][a.length];
        for(int i=0;i<a.length;i++){
            if(target==a[i]) {
                b[i]=1;
                c[i][i]=1;
            }
            else if(target>a[i]&&need[target-a[i]]!=-1){
                b[i]=need[target-a[i]]+1;
                for(int j=0;j<a.length;j++){
                    c[i][j]=money[target-a[i]][j];
                }
                c[i][i]=c[i][i]+1;
            }
        }
        int min=-1;
        int i;
        int j=0;
        for(i=0;i<b.length;i++){
            if(b[i]!=-1){
                min=b[i];
                j=i;
                break;
            }
        }
        if(min==-1) return;
        for(;i<b.length;i++){
            if(b[i]!=0&&min>b[i]){
                min=b[i];
                j=i;
            }
        }
        need[target]=min;
        for(int k=0;k<a.length;k++){
            money[target][k]=c[j][k];
        }
        for(int k=0;k<a.length;k++){
            if(moneynum[k]<money[target][k]) moneynum[k]=money[target][k];
        }
    }
}
