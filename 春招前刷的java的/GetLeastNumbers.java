import java.util.*;

public class GetLeastNumbers {
    public static void main(String[] args) throws Exception {
        int[] a={4,5,1,6,2,7,3,8};
        System.out.println(new GetLeastNumbers().answer(a,4).toString());
    }

    public ArrayList<Integer> answer(int[] input, int k){
        ArrayList<Integer> a=new ArrayList<Integer>();
        if(k>input.length) return a;
        Arrays.sort(input);
        for(int i=0;i<k;i++){
            a.add(input[i]);
        }
        return a;
    }
}