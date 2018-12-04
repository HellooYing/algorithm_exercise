import java.util.*;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        System.out.println(new Fibonacci().answer(10));
    }

    public int answer(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        ArrayList<Integer> a=new ArrayList<Integer>();
        a.add(0);
        a.add(1);
        for(int i=2;i<=n;i++){
            a.add(a.get(i-1)+a.get(i-2));
        }
        return a.get(a.size()-1);
    }

}