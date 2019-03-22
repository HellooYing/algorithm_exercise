import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] m=new int[n];
        int x=0,y=0,k=0;
        Main a=new Main();
        for(int i = 0; i < n; i++){
            x= sc.nextInt();
            y= sc.nextInt();
            k= sc.nextInt();
            m[i]=a.f(x,y,k);
        } 
        sc.close();
        for(int i:m) System.out.println(i);
    }
    public int f(int x,int y,int k){
        if(Math.max(Math.abs(x),Math.abs(y))<k){
            if(k-Math.max(Math.abs(x),Math.abs(y))%2==1) return k-Math.abs(Math.abs(x)-Math.abs(y))-2;
            else return k-Math.abs(Math.abs(x)-Math.abs(y));
        }
        else return -1;
    }
}