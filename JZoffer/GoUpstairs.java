import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class GoUpstairs {
    public static void main(String[] args) {
        System.out.println(countWays(36196));
    }
    public static int countWays(int n) {
        List<BigInteger> list=new ArrayList<>();
        list.add(new BigInteger("1"));
        list.add(new BigInteger("2"));
        for(int i=2;i<n;i++){
            list.add(list.get(i-1).add(list.get(i-2)));
        }
        System.out.println(list.get(n-1));
        int r=list.get(n-1).mod(new BigInteger("1000000007")).intValue();
        return r;
    }
}
