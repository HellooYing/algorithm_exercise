import java.util.Arrays;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 */
public class sortColors {
    public static void main(String[] args) {
        int[] a=new int[]{2,0,2,1,1,0};
        new sortColors().answer(a);
        System.out.println(Arrays.toString(a));
    }
    public void answer(int[] nums) {
        //排序已经扫过的，有多少个0就给0分配多少位置，有多少个1就给1分配多少位置
        int n0=0,n1=0,n2=0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]){
                case 0:
                    get0(n0,n1,n2,nums);
                    n0++;
                    n1++;
                    n2++;
                    break;
                case 1:
                    get1(n0,n1,n2,nums);
                    n1++;
                    n2++;
                    break;
                case 2:
                    get2(n0,n1,n2,nums);
                    n2++;
                    break;
            }
        }
    }
    private void get0(int n0,int n1,int n2,int[] nums){
        //n0代表0有多少个 nums从0到n0-1是0，n0到n1-1是1，n1到n2-1是2，n2是0
        swap(n2,n0,nums);//0换到第一个1的位置，n2变成1
        if(n1!=n0) swap(n2,n1,nums);//1换到第一个2的位置，n2变成2
    }
    private void get1(int n0,int n1,int n2,int[] nums){
        swap(n2,n1,nums);
    }
    private void get2(int n0,int n1,int n2,int[] nums){

    }
    private void swap(int i,int j,int[] nums){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
