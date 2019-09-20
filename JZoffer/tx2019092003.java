import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/20
 */
public class tx2019092003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a=new int[n][];
        for (int i = 0; i <n ; i++) {
            int m=sc.nextInt();
            int[] b=new int[m];
            for (int j = 0; j <m ; j++) {
                b[j]=sc.nextInt();
            }
            a[i]=b;
        }
        sc.close();
        for (int i = 0; i <a.length ; i++) {
            answer(a[i]);
        }
    }
    private static void answer(int[] a){
        Arrays.sort(a);
        int l1=1,l2=0;
        int sum1=a[a.length-1];
        int sum2=0;
        int i= a.length-2;
        for (; i >=0; i--) {
            if(l1>=a.length/2||l2>=a.length/2){
                break;
            }
            if(sum1>sum2){
                l2++;
                sum2+=a[i];
            }
            else{
                l1++;
                sum1+=a[i];
            }
        }
        if(i!=-1){
            if(a.length%2==0){
                if(l1>=a.length/2){
                    for(;i>=0;i--) sum2+=a[i];
                }
                else{
                    for(;i>=0;i--) sum1+=a[i];
                }
            }
            else{
                if(l1>=a.length/2){
                    for(;i>0;i--) sum2+=a[i];
                }
                else{
                    for(;i>0;i--) sum1+=a[i];
                }
                if(sum1<sum2) sum1+=a[0];
                else sum2+=a[0];
            }
        }
        int[] r=new int[2];
        r[0]=sum1;
        r[1]=sum2;
        Arrays.sort(r);
        System.out.println(r[0]+" "+r[1]);
    }
}
