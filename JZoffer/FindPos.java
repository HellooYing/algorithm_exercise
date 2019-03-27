import java.util.*;

public class FindPos {
    public int findPos(int[] arr, int n) {
        if(arr==null||n==0) return -1;
        int l=0,r=n-1,mid,res=-1;
        mid=(l+r)/2;
        while(l+1<r){
            mid=(l+r)/2;
            if(arr[mid]<mid) l=mid;
            else if(arr[mid]>mid) r=mid;
            else{
                res=mid;
                r=mid;
            }
        }
        if(arr[l]==l) res=l;
        else if(arr[mid]==mid) res=mid;
        else if(arr[r]==r) res=r;
        return res;
    }
}