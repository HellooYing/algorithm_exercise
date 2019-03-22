import java.util.*;

public class minNumberInRotateArray {
    public static void main(String[] args) throws Exception {
        int[] a={3,4,5,1,2};
        System.out.println(new minNumberInRotateArray().answer(a));
    }

    public int answer(int[] array){
        if(array.length==0) return 0;
        for(int i=0;i<array.length-1;i++){
            if(array[i]>array[i+1]) return array[i+1];
        }
        return array[0];
    }

}