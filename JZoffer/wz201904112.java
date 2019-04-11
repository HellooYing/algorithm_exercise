import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wz201904112 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int m=in.nextInt();
        in.close();
        answer(n,k,m);
    }
    static void answer(int n,int k,int m){
        if(n<m){
            System.out.println(k);
            return;
        }
        int r=n*k/m;
        if(n*k%m!=0) r++;
        System.out.println(r);
    }
}
