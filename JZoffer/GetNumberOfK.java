import java.util.*;

public class GetNumberOfK {
    public static void main(String[] args) throws Exception {
        int[] a={1,2,2,3,3,4,5};
        System.out.println(new GetNumberOfK().answer(a,2));
    }

    public int answer(int [] array , int k){
        if(array.length==0) return 0;
        int p=find(array,k);
        if(p==-1) return 0;
        int r=0;
        for(int i=p;i>=0;i--){
            if(array[i]==k) r++;
            else break;
        }
        for(int i=p+1;i<array.length;i++){
            if(array[i]==k) r++;
            else break;
        }
        return r;
    }
    private int find(int[] a,int k){
        int mid=(int)Math.floor(a.length/2);
        int t;
        int l=0;
        int r=a.length;
        while(a[mid]!=k){
            if(a[mid]>k){
                t=(int)Math.floor((l+mid)/2);
                r=mid;
                if(t==mid) return -1;
                else mid=t;
            }
            else{
                t=(int)Math.floor((r+mid)/2);
                l=mid;
                if(t==mid) return -1;
                else mid=t;
            }
        }
        return mid;
    }
}