public class removeElement {
    public static void main(String[] args) throws Exception {
        int[] a = { 4,1,2,4};
        int v=1;
        System.out.println(new removeElement().answer(a,v));
    }

    public int answer(int[] nums, int val) {
        int q=0;
        int i=0;
        while(i+q<nums.length){
            if(nums[i]==val)  q++;
            else i++;
            if(i+q<nums.length)  nums[i]=nums[i+q];
        }
        return nums.length-q;
    }
}