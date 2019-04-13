import java.math.BigInteger;
import java.util.*;
public class ks201904132 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.close();
        System.out.println(answer(n));
    }
    static int answer(int n){
        BigInteger r=new BigInteger("1");
        for (int i = 2; i <=n ; i++) {
            r=r.multiply(new BigInteger(String.valueOf(i)));
        }
        String a=r.toString();
        int result=0;
        for (int i = a.length()-1; i >=0 ; i--) {
            if(a.charAt(i)!='0'){
                result=Integer.parseInt(a.substring(i,i+1));
                break;
            }
        }
        return result;
    }
}
