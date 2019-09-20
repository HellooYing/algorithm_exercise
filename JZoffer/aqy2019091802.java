import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/18
 */
public class aqy2019091802 {
    int r;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=(int)Math.pow(2,n);
        int n1=sc.nextInt();
        int[] a=new int[m];
        for (int i = 0; i <m ; i++) {
            a[i]=sc.nextInt();
        }
        int[][] a2=new int[n1][2];
        for (int i = 0; i <n1 ; i++) {
            a2[i][0]=sc.nextInt();
            a2[i][1]=sc.nextInt();
        }
        sc.close();
        aqy2019091802 main=new aqy2019091802();
        for (int i = 0; i <n1 ; i++) {
            a[a2[i][0]]=a2[i][1];
            main.cal(a);
            System.out.println(main.r);
        }
    }
    void cal(int[] a){
        int[] b=new int[a.length/2];
        for (int i = 0; i <a.length ; i=i+2) {
            b[i/2]=a[i]|a[i+1];
        }
        int[] c=new int[b.length/2];
        for (int i = 0; i < b.length; i=i+2) {
            c[i/2]=b[i]^b[i+1];
        }
        if(c.length==1){
            r=c[0];
        }
        else{
            cal(c);
        }
    }
}
