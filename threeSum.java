import java.util.*;

public class threeSum {
    public static void main(String[] args) throws Exception {
        int[] x = {-2,0,1,1,2};
        List<List<Integer>> a=new threeSum().answer(x);
        System.out.println(a);
    }
    public List<List<Integer>> answer(int[] nums) {
        List<List<Integer>> result= new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int i=1;
        int j=nums.length-1;
        int k=0;
        int m;
        while(k<nums.length-1){
            if(j==0||i==nums.length-1||j==i){
                k++;
                i=k+1;
                j=nums.length-1;
                continue;
            }
            m=nums[k]+nums[i]+nums[j];
            if(m>0) j--;
            else if(m<0) i++;
            else if(m==0){
                ArrayList<Integer> list= new ArrayList<Integer>();
                list.add(nums[k]);
                list.add(nums[i]);
                list.add(nums[j]);
                int judge=0;
                for(int d=0;d<result.size();d++){
                    if(result.get(d).get(0)==list.get(0)&&result.get(d).get(1)==list.get(1)&&result.get(d).get(2)==list.get(2)) judge=1;
                }
                if(judge==0) result.add(list);
                i++;
            }
        }
        return result;
    }
}

