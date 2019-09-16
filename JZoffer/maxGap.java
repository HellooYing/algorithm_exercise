import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaole.myy
 * @date 2019/9/14
 */
public class maxGap {
    public static void main(String[] args) {
        maxGap maxGap=new maxGap();
        int[] A=new int[]{7279,9784,9387,6620,1963,999,8505,8163,9496,3150,1607,2146,4783,7539,8751,6118,9793,2404,4871};
        System.out.println(maxGap.maxGap(A,1));
    }
    public int maxGap(int[] A, int n) {
        int max=A[0];
        int min=A[0];
        List<List<Integer>> buckets=new ArrayList<>();
        //找最大值
        for(int i=0;i<A.length;i++){
            if(A[i]>max) max=A[i];
            if(A[i]<min) min=A[i];
            buckets.add(new ArrayList<Integer>());
            buckets.add(new ArrayList<Integer>());
        }
        //装桶
        int bucketsLength=(max-min)/A.length;
        for(int i=0;i<A.length;i++){
            int num=(A[i]-min)/bucketsLength;
            buckets.get(num).add(A[i]);
        }
        //找空桶长度最大的那些
        int diff=0;//目前的最大diff
        int noneBucketLength=0;//最长的连续空桶数
        int nowNoneBucketLength=0;//当前空桶数
        for (int i = 1; i < buckets.size(); i++) {
            if(buckets.get(i).size()==0){
                nowNoneBucketLength++;
            }
            else{
                if(noneBucketLength<nowNoneBucketLength){
                    diff=getDiff(buckets,i-nowNoneBucketLength-1,i);
                    noneBucketLength=nowNoneBucketLength;
                }
                else if(noneBucketLength==nowNoneBucketLength){
                    int nowDiff=getDiff(buckets,i-nowNoneBucketLength-1,i);
                    if(diff<nowDiff) diff=nowDiff;
                }
                nowNoneBucketLength=0;
            }
        }
        return diff;
    }
    public int getDiff(List<List<Integer>> buckets,int i,int j){
        List<Integer> left=buckets.get(i);
        int max=left.get(0);
        for (int k = 0; k <left.size() ; k++) {
            if(max<left.get(k)) max=left.get(k);
        }
        List<Integer> right=buckets.get(j);
        int min=right.get(0);
        for (int k = 0; k <right.size() ; k++) {
            if(min>right.get(k)) min=right.get(k);
        }
        return min-max;
    }
}
