import java.util.*;

public class duplicate {
    public static void main(String[] args) throws Exception {
        int[] a={10,1,10,2,3,4,10,10,12,14,11,2,4,2,5,6,7,12,12,8,4,9,0};
        int[] d=new int[1];
        System.out.println(new duplicate().answer(a,14,d));
    }

    public boolean answer(int numbers[],int length,int [] duplication){
        int[] n=new int[length];
        for(int i=0;i<numbers.length;i++){
            n[numbers[i]]++;
            if(n[numbers[i]]>1){
                duplication[0]=numbers[i];
                return true;
            }
        }
        return false;
    }
}