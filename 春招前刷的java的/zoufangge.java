import java.math.BigInteger;
import java.util.*;

public class zoufangge {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        sc.close();
        new zoufangge().answer(x,y);
    }
    void answer(int x,int y){
        BigInteger r=new BigInteger("1");
        for(int i=0;i<x;i++){
            r=r.multiply(new BigInteger(Integer.toString(x+y-i)));
        }
        
        for(int i=1;i<=x;i++){
            r=r.divide(new BigInteger(Integer.toString(i)));
        }
        System.out.println(r);
    }
}