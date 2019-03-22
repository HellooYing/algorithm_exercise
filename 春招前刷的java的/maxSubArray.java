public class maxSubArray {
    public static void main(String[] args) throws Exception {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new maxSubArray().answer(nums));
        System.out.println(new maxSubArray().answer2(nums));
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
    public int answer2(int[] nums){//体现动态规划思想
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>0) nums[i]=nums[i]+nums[i-1];
            if(nums[i]>max) max=nums[i];
        }
        return max;
    }
}