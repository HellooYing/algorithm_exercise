import java.util.Arrays;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums=new int[]{1};
        new nextPermutation().next(nums);
        System.out.println(Arrays.toString(nums));
    }
    void next(int[] nums){
        int n1=n1(nums);
        if(n1==-1){
            Arrays.sort(nums);
            return;
        }
        int n2=n2(nums,n1);
        swap(nums,n1,n2);
        Arrays.sort(nums,n1+1,nums.length);
    }

    int n2(int[] nums,int n1){
        int n2=n1+1;
        while(n2+1<nums.length&&nums[n2+1]>nums[n1]) n2++;
        return n2;
    }

    int n1(int[] nums){
        for (int i = nums.length-2; i >=0; i--) {
            if(nums[i]<nums[i+1]) return i;
        }
        return -1;
    }

    void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
