/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class MaxProduct {
    public static void main(String[] args) {
        int[] a=new int[]{2,3,-2,-4};
        System.out.println(new MaxProduct().maxProduct(a));
    }
    public int maxProduct(int[] nums) {
        int[] dpMax=new int[nums.length];
        int[] dpMin=new int[nums.length];
        dpMax[0]=nums[0];
        dpMin[0]=nums[0];
        for (int i = 1; i <nums.length ; i++) {
            if(nums[i]>0){
                if(dpMax[i-1]>0) dpMax[i]=dpMax[i-1]*nums[i];
                else dpMax[i]=nums[i];
                if(dpMin[i-1]>0) dpMin[i]=nums[i];
                else dpMin[i]=dpMin[i-1]*nums[i];
            }
            else if(nums[i]==0){
                dpMax[i]=0;
                dpMin[i]=0;
            }
            else{
                if(dpMax[i-1]>0) dpMin[i]=dpMax[i-1]*nums[i];
                else dpMin[i]=nums[i];
                if(dpMin[i-1]>0) dpMax[i]=nums[i];
                else dpMax[i]=dpMin[i-1]*nums[i];
            }
        }
        int max=dpMax[0];
        for (int i = 0; i <nums.length ; i++) {
            if(max<dpMax[i]) max=dpMax[i];
        }
        return max;
    }
}
