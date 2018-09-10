public class searchInsert {
    public static void main(String[] args) throws Exception {
        int[] x = {1,3,5,6};
        int a = new searchInsert().answer(x,0);
        System.out.println(a);
    }

    public int answer(int[] nums, int target) {
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<target){
                result++;
            }
            else{
                break;
            }
        }
        return result;
    }
}