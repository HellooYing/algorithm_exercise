public class threeSumClosest {
    public static void main(String[] args) throws Exception {
        int[] nums={10,1,2,3,4,5,6,7,8,9,100};
        int target=109;
        System.out.println(new threeSumClosest().answer(nums,target));
    }
    public int answer(int[] nums, int target) {
        int result;
        int l=nums.length;
        sort(nums,0,l-1);
        for(int i=0;i<l;i++){
            
        }
        return 0;
    }
    public void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            while(end>start&&a[end]>=key)
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while(end>start&&a[start]<=key)
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if(start>low) sort(a,low,start-1);
        if(end<high) sort(a,end+1,high);
    }
}