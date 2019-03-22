import java.util.*;

public class threeSum {
    public static void main(String[] args) throws Exception {
        int[] x = {-1,0,1,2,-1,-4};
        List<List<Integer>> a = new threeSum().answer(x);
        System.out.println(a);
    }

    public List<List<Integer>> answer(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i = 1;
        int j = nums.length - 1;
        int k = 0;
        int m;
        while (k < nums.length - 1) {
            while(k+1<nums.length&&nums[k]==nums[k+1]){
                k++;
            }
            if (j == 0 || i == nums.length - 1 || j == i) {
                k++;
                i = k + 1;
                j = nums.length - 1;
                continue;
            }
            m = nums[k] + nums[i] + nums[j];
            if (m > 0){
                j--;
                while(nums[j+1]==nums[j]&&j>i){
                    j--;
                }
            }
            else if (m < 0) {
                i++;
                while(nums[i-1]==nums[i]&&i<j){
                    i++;
                }
            }
            else if (m == 0) {
                System.out.println(""+i+","+j+","+k);
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                i++;
                while(nums[i-1]==nums[i]&&i<j){
                    i++;
                }
                while(nums[j]==nums[j-1]&&i<j){
                j--;
                }
            }
        }
        
        return result;
    }
}