public class FindGreatestSumOfSubArray1 {
    public static void main(String[] args) throws Exception {
        int[] a={6,-3,-2,7,-15,1,2,2};
        System.out.println(new FindGreatestSumOfSubArray1().answer(a));
    }

    public int answer(int[] array){
        if(array.length==0) return 0;
        int j,s=0,m=array[0];
        for(j=0;j<array.length;j++){
            s+=array[j];
            if(m<s) m=s;
            if(s<0) s=0;
        }
        return m;
    }
}