/**
 * @author zhaole.myy
 * @date 2019/9/15
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a=new int[]{1,4,2,5,3};
        System.out.println(new LongestIncreasingSubsequence().getLIS(a,a.length));
    }
    public int getLIS(int[] A, int n) {
        int[] val=new int[A.length];
        val[0]=1;
        for (int i = 1; i <A.length ; i++) {
            //维护一个max，代表前面比A[i]小的数字的下面的数字的最大值，最终val[i]=max+1
            int max=0;
            for (int j = 0; j <i ; j++) {
                if(A[i]>A[j]){
                    if(val[j]>max) max=val[j];
                }
            }
            val[i]=max+1;
        }
        int max=val[0];
        for (int i = 1; i <val.length ; i++) {
            if(val[i]>max) max=val[i];
        }
        return max;
    }
}
