import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new twoSum().answer(new int[]{43,2,3,4,5,9,6},5)));
    }
    public int[] answer(int[] nums, int target) {
        int[] r=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(map.containsKey(target-nums[i])){
                int r1=i,r2=map.get(target-nums[i]);
                if(r1>r2){
                    r[0]=r2;
                    r[1]=r1;
                }
                else{
                    r[0]=r1;
                    r[1]=r2;
                }
                return r;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
