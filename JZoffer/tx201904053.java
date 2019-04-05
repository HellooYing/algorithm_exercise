import java.util.Arrays;
import java.util.Scanner;

public class tx201904053 {
    static int minjb=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] wl=new int[n];
        int[] jb=new int[n];
        for(int i=0;i<n;i++){
            wl[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            jb[i]=in.nextInt();
        }
        in.close();
        answer(wl,jb);
    }
    static void answer(int[] wl,int[] jb){
        //暴力，遇到每个怪都有给不给钱的策略，分别递归，被打死的提前递归结束
        int wlz=wl[0];
        int jbz=jb[0];
        int dq=1;
        dg(wlz,jbz,dq,wl,jb);
        System.out.println(minjb);
    }
    static void dg(int wlz,int jbz,int dq,int[] wl,int[] jb){
        if(dq==wl.length){
            if(minjb>jbz) minjb=jbz;
        }
        else if(wlz>=wl[dq]){//当前武力大于等于怪兽，还能活下去，否则就到此为止
            dg(wlz+wl[dq],jbz+jb[dq],dq+1,wl,jb);
            dg(wlz,jbz,dq+1,wl,jb);
        }
        else{
            dg(wlz+wl[dq],jbz+jb[dq],dq+1,wl,jb);
        }
    }
}
