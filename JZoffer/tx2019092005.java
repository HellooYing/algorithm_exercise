import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/20
 */
public class tx2019092005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for (int i = 0; i <n ; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i <n ; i++) {
            b[i]=sc.nextInt();
        }
        sc.close();
        System.out.println(answer(a,b));
    }
    private static int answer(int[] a,int[] b){
        int r=a[0]+b[0];
        for (int i = 1; i <b.length ; i++) {
            r=r^(a[0]+b[i]);
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                r=r^(a[i]+b[j]);
            }
        }
        return r;
    }
}
