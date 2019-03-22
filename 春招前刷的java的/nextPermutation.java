import java.util.Arrays;
public class nextPermutation {
    public static void main(String[] args) throws Exception {
        int[] a = { 1,5,1 };
        new nextPermutation().answer(a);
        for(int aa:a)
            System.out.println(aa);
    }

    public void answer(int[] list) {
        int n=list.length;
        int i;
        int tmp;
        for(i=n-1;i>=0;i--){
            if(i==0) break;
            else if(list[i]>list[i-1]) break;
        }
        //System.out.println(i);
        if(i==0){
            for(int j=0;j<n/2;j++){
                tmp=list[j];
                list[j]=list[n-1-j];
                list[n-1-j]=tmp;
            }
        }
        else{
            int minlarge=Integer.MAX_VALUE;
            int minlarge_i=i-1;
            for(int j=i;j<n;j++){
                if(list[j]<=list[i-1]) continue;
                else if(list[j]<minlarge){
                    minlarge=list[j];
                    minlarge_i=j;
                }
            }
            tmp=list[i-1];
            list[i-1]=list[minlarge_i];
            list[minlarge_i]=tmp;
            Arrays.sort(list, i, n);
        }
    }
}
