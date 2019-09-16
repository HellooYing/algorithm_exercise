import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class sg2019091602 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cw = sc.nextInt();//槽位
        int n=sc.nextInt();
        int[] pswdcw=new int[cw];
        for (int i = 0; i <n ; i++) {
            int start=sc.nextInt();
            int end=sc.nextInt();
            change(pswdcw,start,end,i+1);
        }
        sc.close();
        System.out.println(answer(pswdcw));
    }
    public static int answer(int[] pswdcw){
        int r=0;
        for (int i = 0; i <pswdcw.length ; i++) {
            r+=i*pswdcw[i]%100000009;
        }
        return r%100000009;
    }
    public static void change(int[] pswdcw,int start,int end,int v){
        for (int i = start; i <=end ; i++) {
            pswdcw[i]=v;
        }
    }
}
