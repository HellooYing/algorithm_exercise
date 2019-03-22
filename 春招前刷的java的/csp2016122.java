import java.util.*;

public class csp2016122 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        sc.close();
        System.out.print(new csp2016122().answer(n));
    }

    public double answer(int n){
        double r=0;
        if(n>=1455) r+=1500;
        else return r+n/0.97;
        if(n>=4155) r+=3000;
        else return r+(n-1455)/0.9;
        if(n>=7755) r+=4500;
        else return r+(n-4155)/0.8;
        if(n>=27255) r+=26000;
        else return r+(n-7755)/0.75;
        if(n>=41255) r+=20000;
        else return r+(n-27255)/0.7;
        if(n>=57505) r+=25000;
        else return r+(n-41255)/0.65;
        return r+(n-57505)/0.55;
    }
}