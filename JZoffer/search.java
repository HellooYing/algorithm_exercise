import java.util.Arrays;

public class search {
    /***
     * 搜索旋转排序数组
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     *
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     *
     * 你可以假设数组中不存在重复的元素。
     *
     * 你的算法时间复杂度必须是 O(log n) 级别。
     *
     *
     * 搜索旋转排序数组II
     *
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     *
     * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
     *
     * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
     */
    public static void main(String[] args) {
        System.out.println(new search() .answer2(new int[]{2,2,2,3,1},3));
    }
    //搜索旋转排序数组:
    //首先肯定是二分，然后就每次取mid时要根据不同的情况取舍，情况比正常的二分多一点
    //如果mid>l,则说明旋转点在右边，l到mid是正常的。
    //  这种情况下 如果l<target<mid则进入正常的二分，舍弃右边。
    //  如果target<l,舍弃左边，继续这种二分
    //如果mid<l,这说明旋转点在左边，mid到r是正常的。
    //  如果mid<target<r,则进入正常的二分，舍弃左边
    //  如果target>r,舍弃右边，继续这种二分
    public int answer(int[] nums, int target) {
        if(nums.length==0) return -1;
        return myBinarySearch(0,nums.length-1,nums,target);
    }
    public int myBinarySearch(int l,int r,int[] nums, int target){
        if(l>=r){
            if(nums[l]!=target) return -1;
            else return l;
        }
        if(nums[l]<nums[r]) return binarySearch(l,r,nums,target);
        int mid=(l+r)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]>nums[l]){
            if(nums[l]<=target&&nums[mid-1]>=target){
                return binarySearch(l,mid-1,nums,target);
            }
            else{
                return myBinarySearch(mid+1,r,nums,target);
            }
        }
        else{
            if(target>=nums[mid+1]&&target<=nums[r]){
                return binarySearch(mid+1,r,nums,target);
            }
            else{
                return myBinarySearch(l,mid-1,nums,target);
            }
        }
    }
    public int binarySearch(int l,int r,int[] nums, int target){
        if(l>=r){
            if(nums[l]!=target) return -1;
            else return l;
        }
        if(target<nums[l]||target>nums[r]) return -1;
        int mid=(l+r)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]<target) return binarySearch(mid+1,r,nums,target);
        else return binarySearch(l,mid-1,nums,target);
    }

//搜索旋转排序数组II:
    //带重复数字的二分，要走mid的相同的最左和最右，来解决nums[l]==nums[r]==nums[mid]的情况。
    //如果midl==l，则舍弃左边。如果midr==r，舍弃右边。
public int answer2(int[] nums, int target) {
    if(nums.length==0) return -1;
    return myBinarySearch2(0,nums.length-1,nums,target);
}
    public int myBinarySearch2(int l,int r,int[] nums, int target){
        if(l>=r){
            if(nums[l]!=target) return -1;
            else return l;
        }
        if(nums[l]<nums[r]) return binarySearch2(l,r,nums,target);
        int mid=(l+r)/2;
        if(nums[mid]==target) return mid;
        if(nums[l]==target) return l;
        if(nums[r]==target) return r;
        if(nums[mid]==nums[l]&&nums[mid]==nums[r]){
            int midl=goLeft(mid,nums);
            int midr=goRight(mid,nums);
            if(midr<=l) return myBinarySearch2(midl+1,r,nums,target);
            else if(midl>=r) return myBinarySearch2(l,midr-1,nums,target);
            else return -1;
        }
        else if(nums[mid]>nums[l]){
            if(nums[l]<=target&&nums[mid-1]>=target){
                return binarySearch2(l,mid-1,nums,target);
            }
            else{
                return myBinarySearch2(mid+1,r,nums,target);
            }
        }
        else{
            if(target>=nums[mid+1]&&target<=nums[r]){
                return binarySearch2(mid+1,r,nums,target);
            }
            else{
                return myBinarySearch2(l,mid-1,nums,target);
            }
        }
    }

    public int binarySearch2(int l,int r,int[] nums, int target){
        if(l>=r){
            if(nums[l]!=target) return -1;
            else return l;
        }
        if(target<nums[l]||target>nums[r]) return -1;
        int mid=(l+r)/2;
        if(nums[mid]==target) return mid;
        if(nums[l]==target) return l;
        if(nums[r]==target) return r;
        if(nums[mid]==nums[l]&&nums[mid]==nums[r]){
            int midl=goLeft(mid,nums);
            int midr=goRight(mid,nums);
            if(midr<=l) return binarySearch2(midl+1,r,nums,target);
            else if(midl>=r) return binarySearch2(l,midr-1,nums,target);
            else return -1;
        }
        else if(nums[mid]<target) return binarySearch2(mid+1,r,nums,target);
        else return binarySearch2(l,mid-1,nums,target);
    }

    public int goLeft(int i,int[] nums){
        if(i<0||i>=nums.length) return i;
        while(i+1<nums.length&&nums[i]==nums[i+1]) i++;
        return i;
    }
    public int goRight(int i,int[] nums){
        if(i<0||i>=nums.length) return i;
        while(i-1>=0&&nums[i]==nums[i-1]) i--;
        return i;
    }
}
