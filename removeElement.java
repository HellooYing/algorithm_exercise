public class removeElement {
    public static void main(String[] args) throws Exception {
        int[] a = { 1,1,1,1,1,1};
        v=1;
        System.out.println(new removeElement().answer(a,v));
    }

    public int answer(int[] nums, int val) {
        int q=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==val){
                q++;
                nums=remove(nums,i);
            }
           // nums[i]=nums[i+q];
        }
        return nums.length-q;
    }
}