import java.util.*;

public class threeSum {
    public static void main(String[] args) throws Exception {
        int[] x = { 1,3,5,4,2 };
        ArrayList<ArrayList<Integer>> a=new threeSum().answer(x);
        System.out.println(a);
    }
    public ArrayList<ArrayList<Integer>> answer(int[] nums) {
        ArrayList<ArrayList<Integer>> list= new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1= new ArrayList<Integer>(Arrays.asList(nums));
        list.add(list1);
        return list;
    }
}

