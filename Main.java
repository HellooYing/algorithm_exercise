import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int s = in.nextInt();
        int q = in.nextInt();
        in.close();
        System.out.println(new Main().answer(t,s,q));
    }
    static int answer(int t,int s,int q){
        int lis=0;
        int c=1;
        double dl=(double)s;
        int time=0;
        double speed=(double)(q-1)/(double)q;
        while(lis<=t&&dl<=t){
            lis=lis+1;
            dl=dl+speed;
            if(dl+speed<lis+1){lis=0;c++;}
        }
        return c;
    }
}