import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class wz201904113 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=in.nextInt();
        }
        in.close();
        for (int i = 0; i < n ; i++) {
            System.out.println(answer(a[i]));
        }
    }
    static int answer(int n){
        Set<Integer> set=new HashSet<>();
        int num=0;
        int p=n;
        while(p!=1){
            if(set.contains(p)) return -1;
            set.add(p);
            num++;
            if(p%2==0) p=p/2;
            else p=p*3+1;
        }
        return num;
    }
}
