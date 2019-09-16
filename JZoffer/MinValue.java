/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class MinValue {
    public static void main(String[] args) {
        int[] a=new int[]{4,1,2,3,3};
        System.out.println(getMin(a,a.length));
    }
    public static int getMin(int[] arr, int n) {
        // 返回最小值
        // 最小值是左边的数比它大的那个数。
        // 如果当前数大于a[a.length-1]，则保留mid+1到right
        // 如果当前数小于等于a[a.length-1]，则保留left到mid-1
        return get(arr,0,arr.length);
    }
    private static int get(int[] a,int left,int right){
        if(left>=right) return a[left];
        int mid=(right+left)/2;
        if(mid==0){
            return Math.min(a[left],a[right]);
        }
        else if(a[mid-1]>a[mid]) return a[mid];
        else if(a[mid]>a[a.length-1]) return get(a,mid+1,right);
        else return get(a,left,mid-1);
    }
}
