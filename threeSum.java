import java.util.*;

public class threeSum {
    public static void main(String[] args) throws Exception {
        int[] x = { -1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> a=new threeSum().answer(x);
        System.out.println(a);
    }
    public ArrayList<ArrayList<Integer>> answer(int[] nums) {
        ArrayList<ArrayList<Integer>> result= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list= new ArrayList<Integer>();
        Arrays.sort(nums);
        int i=1;
        int j=nums.length-1;
        int k=0;
        int m;
        System.out.println(Arrays.toString(nums));
        while(k<nums.length-1){
            System.out.println("i:"+i+",j:"+j+",k:"+k);
            if(j==0||i==nums.length-1){
                k++;
                i=k+1;
                j=nums.length-1;
                continue;
            }
            m=nums[k]+nums[i]+nums[j];
            if(m>0) j--;
            else if(m<0) i++;
            else if(m==0){
                list.clear();
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                k++;
                i=k+1;
                j=nums.length-1;
            }
        }
        return result;
    }
}

