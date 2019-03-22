import java.util.*;
public class fairCandySwap {
    public static void main(String[] args) throws Exception {
        int[] A={1,1},B={2,2};
        int[] a = new fairCandySwap().answer(A,B);
        System.out.println(a);
    }

    public int[] answer(int[] A, int[] B) {
        int[] result=new int[2];
        int c;
        int ha=0,hb=0;
        int i,j;
        for(i=0;i<A.length;i++){
            ha+=A[i];
        }
        for(i=0;i<B.length;i++){
            hb+=B[i];
        }
        c=ha-hb;
        Arrays.sort(A);
        Arrays.sort(B);
        i=0;
        j=0;
        while(A[i]-B[j]!=c/2){
            if(A[i]-B[j]>c/2) j++;
            else i++;
        }
        result[0]=A[i];
        result[1]=B[j];
        return result;
    }
}