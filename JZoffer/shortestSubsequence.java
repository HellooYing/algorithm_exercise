public class shortestSubsequence {
    public static void main(String[] args) throws Exception {
        int[] a={1,2,3,3,8,9};
        System.out.println(answer(a));
    }
    static int answer(int[] a){
        int max=a[0];
        int r=0;
        for(int i=1;i<a.length;i++){
            if(a[i]>=max) max=a[i];
            else r=i;
        }
        int min=a[a.length-1];
        int l=a.length-1;
        for(int i=a.length-1;i>=0;i--){
            if(a[i]<=min) min=a[i];
            else l=i;
        }
        System.out.println(l+" "+r);
        int result=r-l+1;
        if(result<0) result=0;
        return result;
    }
}
