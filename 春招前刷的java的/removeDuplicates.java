import java.util.*;

public class removeDuplicates {
    public static void main(String[] args) throws Exception {
        int[] x = {1,1};
        int a = new removeDuplicates().answer(x);
        System.out.println(a);
    }

    public int answer(int[] nums) {
        int r=1;
        int i=0;
        while(i+r<nums.length){
            if(i+1<nums.length){
                if(nums[i]==nums[i+1])  r++;
                else i++;
            }
            if(i+r<nums.length&&i+1<nums.length)  nums[i+1]=nums[i+r];
        }
        for(int j=0;j<nums.length;j++){
            System.out.println(nums[j]);
        }
        return nums.length-r+1;
    }
}