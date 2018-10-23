public class maxSubArray {
    public static void main(String[] args) throws Exception {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new maxSubArray().answer(nums));
    }
public int answer(int[] nums){
    int r=0;
    int max=nums[0];
    for(int i=0;i<nums.length;i++){
        r=r+nums[i];
        if(max<r) max=r;
        if(r<0) r=0;
    }
    return max;
    }
}