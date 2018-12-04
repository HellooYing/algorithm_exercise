import java.util.*;

public class reOrderArray {
    public static void main(String[] args) throws Exception {
        int[] a={9,8,7,6,5,4,3};
        new reOrderArray().answer(a);
        for(int e:a) System.out.print(e);
    }
    void move(int[] a,int i,int j){//a[i] move to a[j]
        if(i<j){
            int t= a[i];
        while(i<j){
            a[i]=a[i+1];
            i++;
        }
        a[j]=t;
        }
        else if(i>j){
            int t= a[i];
            while(j<i){
                a[i]=a[i-1];
                i--;
            }
            a[j]=t;
        }
    }

    public void answer(int[] array){
        int o=array.length-1;
        int j=0;
        for(int i=0;i<array.length;i++){
            for(int e:array) System.out.print(e);
            System.out.println();
            if(array[i]/2*2!=array[i]) {move(array,i,j);j++;}
        }
    }
}