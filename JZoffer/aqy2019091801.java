import java.util.Arrays;
import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/18
 */
public class aqy2019091801 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        sc.close();
        Arrays.sort(a);
        int cp=0,wz=0;
        while(a[a.length-1]!=0) {
            if(wz==0){
                cp++;
                wz=n-1;
            }
            else {
                wz--;
                a[a.length-1]--;
                Arrays.sort(a);
            }
        }
        System.out.println(cp);
    }
}
