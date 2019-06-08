import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 */
public class permute {
    public static void main(String[] args) {
        int[] nums=new int[]{1};
        System.out.println(new permute().answer(nums));
    }

    public List<List<Integer>> answer(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> r=new ArrayList<>();
        if(nums.length==0) return r;
        if(nums.length==1){
            r.add(intArrayToListInteger(nums));
            return r;
        }
        int[] rr=nums;
        while(rr!=null){
            r.add(intArrayToListInteger(rr));
            rr=next(rr);
        }
        return r;
    }

    List<Integer> intArrayToListInteger(int[] ints) {
        List<Integer> intList = new ArrayList<>(ints.length);
        for (int anInt : ints) {
            intList.add(anInt);
        }
        return intList;
    }

    int[] next(int[] nums){
        // 123-132
        // 从尾开始找到降序的n1(2)，
        // 再从n1+1开始向后找比nums[n1]大的最小的数n2（3），
        // 交换n2和n1，再将n1后的所有数变成最小
        int n1=n1(nums);
        if(n1==-1) return null;
        int n2=n2(nums,n1);
        swap(nums,n1,n2);
        Arrays.sort(nums,n1+1,nums.length);
        return nums;
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
