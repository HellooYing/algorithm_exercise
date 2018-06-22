import java.util.*;

public class threeSum {
    public static void main(String[] args) throws Exception {
        int[] x = {};
        List<List<Integer>> a = new threeSum().answer(x);
        System.out.println(a);
    }

    public List<List<Integer>> answer(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || (nums != null && nums.length == 0))
            return new ArrayList<List<Integer>>();
        if (nums.length < 3)
            return new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int n1 = nums[0];
        int n2 = nums[nums.length - 1];
        if (n1 == n2) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            if (nums[0] == 0) {
                list.add(nums[0]);
                list.add(nums[0]);
                list.add(nums[0]);
                result.add(list);
                return result;
            }
            else return new ArrayList<List<Integer>>();
        }
        int i = 1;
        int j = nums.length - 1;
        int k = 0;
        int m;
        while (k < nums.length - 1) {
            if (j == 0 || i == nums.length - 1 || j == i) {
                k++;
                i = k + 1;
                j = nums.length - 1;
                continue;
            }
            m = nums[k] + nums[i] + nums[j];
            if (m > 0)
                j--;
            else if (m < 0)
                i++;
            else if (m == 0) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(nums[j]);
                int judge = 0;
                for (int d = 0; d < result.size(); d++) {
                    if (result.get(d).get(0).equals(list.get(0)) && result.get(d).get(1).equals(list.get(1))
                            && result.get(d).get(2).equals(list.get(2)))
                        judge = 1;
                }
                if (judge == 0)
                    result.add(list);
                i++;
            }
        }
        return result;
    }
}
