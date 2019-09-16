import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class NumSquares {
    public static void main(String[] args) {
        System.out.println(new NumSquares().numSquares(13));
    }
    Map<Integer,Integer> map=new HashMap<>();
    public int numSquares(int n) {
        int i=getSqrt(n);
        if(n==i*i) return 1;
        if(map.get(n)!=null) return map.get(n);
        int[] nums=new int[i];
        for (int j = 1; j <i+1 ; j++) {
            nums[j-1]=numSquares(n-j*j);
        }
        int min=nums[0];
        for (int j = 0; j <nums.length ; j++) {
            if(min>nums[j]) min=nums[j];
        }
        map.put(n,min+1);
        return min+1;
    }
    /**
     * 获取n能包含的最大的完全平方数的原值，如17能包含16所以是4
     * @param n
     * @return
     */
    private int getSqrt(int n){
        int r=Double.valueOf(Math.sqrt((double)n)).intValue();
        return r;
    }
}
