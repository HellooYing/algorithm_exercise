import java.util.Arrays;

public class moveZeroes {
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        new moveZeroes().answer2(nums);
        System.out.println(Arrays.toString(nums));
    }
    public void answer2(int[] nums) {
        //i:插入位置下标 ; j:查找位置下标
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        //将后面的位置补0
        for(int p = i; p < nums.length; p++){
            nums[p] = 0;
        }
    }

    void answer(int[] nums){
        int zero=0;
        int lastZero=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]==0){
                zero++;
                continue;
            }
            if(lastZero<i) lastZero=i;
            int j=findZero(nums,lastZero);
            if(j==-1) {
                System.out.println(lastZero);
                System.out.println(i);
                return;
            }
            lastZero=j;
            for (int k = i; k >=j ; k--) {
                swap(nums,i,k);
            }
        }
    }

    int findZero(int[] nums,int zeroIndex){
        while(zeroIndex>=0&&nums[zeroIndex]!=0) zeroIndex--;
        return zeroIndex;
    }

    void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
