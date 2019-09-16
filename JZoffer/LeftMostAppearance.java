/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class LeftMostAppearance {
    public static void main(String[] args) {
        int[] a=new int[]{1,2,3,3,4};
        System.out.println(findPos(a,a.length,3));
    }
    public static int findPos(int[] arr, int n, int num) {
        // 有序数组，如果当前数字>num，则保留left-mid。如果<num，则保留mid-right。
        // 如果等于num，则先判断是否为最左，不是则保留left-mid。
        //如果left>=right，则返回没有
        return find(arr,0,arr.length,num);
    }
    public static int find(int[] a,int left,int right,int num){
        if(left==right&&a[left]==num) return left;
        if(left>=right) return -1;
        int mid=(right+left)/2;
        if(a[mid]>num) return find(a,left,mid-1,num);
        else if(a[mid]<num) return find(a,mid+1,right,num);
        else{
            if(mid==0||a[mid-1]!=num) return mid;
            else return find(a,left,mid-1,num);
        }
    }
}
