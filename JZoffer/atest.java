import java.util.Arrays;
import java.util.Scanner;

public class atest {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long[] a=new long[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }
        in.close();
        long[] b=new long[3];
        b[0]=a[0];
        b[1]=a[1];
        b[2]=a[2];
        long[] c=new long[3];
        c[0]=a[0];
        c[1]=a[1];
        c[2]=a[2];
        Arrays.sort(b);
        Arrays.sort(c);
        for (int i = 3; i <a.length ; i++) {
            if(a[i]>b[0]){
                b[0]=a[i];
                Arrays.sort(b);
            }
            if(a[i]<c[2]){
                c[2]=a[i];
                Arrays.sort(c);
            }
        }
        long r1=b[0]*b[1]*b[2];
        r1=Math.max(r1,c[0]*c[1]*b[2]);
        System.out.println(r1);
    }
}