import java.util.*;
public class nk201903142 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m=new int[n];
        int x,y,k;
        nk201903142 a=new nk201903142();
        for(int i = 0; i < n; i++){
            x= sc.nextInt();
            y= sc.nextInt();
            k= sc.nextInt();
            m[i]=a.f(x,y,k);
        } 
        for(int i:m) System.out.println(i);
        sc.close();
    }
    public int f(int x,int y,int k){
        if(Math.max(Math.abs(x),Math.abs(y))<=k){
            if((k-Math.max(Math.abs(x),Math.abs(y)))%2==1) return k-Math.abs(Math.abs(x)-Math.abs(y))-2;
            else return k-Math.abs(Math.abs(x)-Math.abs(y));
        }
        else return -1;
    }
}