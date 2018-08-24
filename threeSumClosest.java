public class threeSumClosest {
    public static void main(String[] args) throws Exception {
        int[] nums={1,2,3,4,5,6,7,8,9,100};
        int target=109;
        System.out.println(new threeSumClosest().answer(nums,target));
    }
    public int answer(int[] nums, int target) {
        int result;
        //最接近的三数之和,
        //我的想法是:求出所有两数之和直接二分插入,然后根据target-nums[i]二分找出第i个数所需的另外两个数(的和),不断替换
        //时间复杂度大概是一个求所有数的二数之和n²/2,n个数有序插入的O(nlogn)=n²log(n/2),对n个数字二分查找的nlogn=n²log(n/2)log(n²log(n/2))
        //<n³
        //空间复杂度应该是n²/2
        //别人的想法是:先对nums进行排序,然后对每个nums[i]求其最接近target的二数之和
        //而nums已经是有序数组,所以可以像快排那样设置一个头一个尾俩坐标,如果求得的和比target大,就让大的数后移,小就小数前移.
        //时间复杂度大概是一个排序的nlogn,然后对n个数求最接近的target的logn,即n(logn)²
        //<n²
        //空间复杂度是常数
        //不知道算的对不对,但是很显然"左右推进式"比我想的方法
        return 0;
    }
}