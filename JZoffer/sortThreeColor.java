import java.util.Arrays;

public class sortThreeColor {
    public static void main(String[] args) throws Exception {
        int[] a={2,2,0,2,0};
        System.out.println(Arrays.toString(answer(a)));
    }
    static int[] answer(int[] a){
        int b=0,c=a.length-1;
        for(int i=0;i<=c;i++){
            if(a[i]==0&&i!=b){
                swap(a,b,i);
                b++;
                i--;
            }
            else if(a[i]==2&&i!=c){
                swap(a,c,i);
                c--;
                i--;
            }
        }
        return a;
    }
    private static void swap(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
}
