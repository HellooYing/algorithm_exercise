public class searchRange {
    public static void main(String[] args) {
        int[] r=new searchRange() .answer(new int[]{2,2,2,3,3,3,3,3,3,9,11},6);
        System.out.println(r[0]+" "+r[1]);
    }
    public int[] answer(int[] nums, int target){
        if(nums.length==0||nums[0]>target||nums[nums.length-1]<target) return new int[]{-1,-1};
        int l = myBinarySearch1(0,nums.length-1,nums,target);
        int r = myBinarySearch2(0,nums.length-1,nums,target);
        int[] result=new int[2];
        result[0]=l;
        result[1]=r;
        return result;
    }
    public int myBinarySearch1(int l,int r, int[] nums, int target){
        if(l>r) return -1;
        else if(l==r){
            if(nums[l]==target&&(l==0||nums[l-1]<target)) return l;
            else return -1;
        }
        int mid=(l+r)/2;
        if(nums[mid]==target&&(mid==0||nums[mid-1]<target)) return mid;
        else if(nums[mid]<target) return myBinarySearch1(mid+1,r,nums,target);
        else return myBinarySearch1(l,mid-1,nums,target);
    }
    public int myBinarySearch2(int l,int r, int[] nums, int target){
        if(l>r) return -1;
        else if(l==r){
            if(nums[l]==target&&(l==nums.length-1||nums[l+1]>target)) return l;
            else return -1;
        }
        int mid=(l+r)/2;
        if(nums[mid]==target&&(mid==nums.length-1||nums[mid+1]>target)) return mid;
        else if(nums[mid]>target) return myBinarySearch2(l,mid-1,nums,target);
        else return myBinarySearch2(mid+1,r,nums,target);
    }
}
