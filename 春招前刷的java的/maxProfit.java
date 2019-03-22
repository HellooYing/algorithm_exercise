import java.util.*;

public class maxProfit {
    public static void main(String[] args) throws Exception {
        int[] prices={1,4,6,2,8,3,10,14};
        System.out.println(new maxProfit().answer4(prices,3));
    }

    public int answer(int[] prices){
        if(prices.length<=1||jx(prices)) return 0;
        int[] q=new int[prices.length];
        int[] h=new int[prices.length];
        q[0]=prices[0];
        h[0]=prices[prices.length-1];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<q[i-1]) q[i]=prices[i];
            else q[i]=q[i-1];
            if(prices[prices.length-1-i]>h[i-1]) h[i]=prices[prices.length-1-i];
            else h[i]=h[i-1];
        }
        int max=h[prices.length-1]-q[0];
        for(int i=1;i<prices.length;i++){
            if(max<h[prices.length-1-i]-q[i]) max=h[prices.length-1-i]-q[i];
        }
        return max;
    }
    boolean jx(int[] a){
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]) return false;
        }
        return true;
    }
    public int answer2(int[] p){
        if(p.length<=1||jx(p)) return 0;
        int[] z=new int[p.length-1];
        int r=0;
        for(int i=0;i<z.length;i++){
            z[i]=p[i+1]-p[i];
            if(z[i]>0) r=r+z[i];
        }
        return r;
    }
    public int answer3(int[] p){
        if(p.length<=1||jx(p)) return 0;
        int[] have=new int[p.length];
        int[] nohave=new int[p.length];
        int[] cool=new int[p.length];
        have[0]=-p[0];
        nohave[0]=0;
        cool[0]=0;
        for(int i=1;i<p.length;i++){
            have[i]=have(i,p,have,cool);
            nohave[i]=nohave(i,p,nohave,have);
            cool[i]=cool(i,nohave);
        }
        if(cool[p.length-1]>nohave[p.length-1]) return cool[p.length-1];
        else return nohave[p.length-1];
    }
    public int answer4(int[] p,int fee){
        if(p.length<=1||jx(p)) return 0;
        int[] have=new int[p.length];
        int[] nohave=new int[p.length];
        have[0]=-p[0];
        nohave[0]=0;
        for(int i=1;i<p.length;i++){
            have[i]=have2(i,p,fee,have,nohave);
            nohave[i]=nohave2(i,p,fee,have,nohave);
        }
        System.out.println(Arrays.toString(have));
        System.out.println(Arrays.toString(nohave));
        return nohave[p.length-1];
    }
    int have(int i,int[] p,int[] have,int[] cool){
        if(have[i-1]>cool[i-1]-p[i]) return have[i-1];
        else return cool[i-1]-p[i];
    }
    int nohave(int i,int[] p,int[] nohave,int[] have){
        if(nohave[i-1]>have[i-1]+p[i]) return nohave[i-1];
        else return have[i-1]+p[i];
    }
    int cool(int i,int[] nohave){
        return nohave[i-1];
    }
    int have2(int i,int[] p,int fee,int[] have,int[] nohave){
        if(have[i-1]>nohave[i-1]-p[i]) return have[i-1];
        else return nohave[i-1]-p[i];
    }
    int nohave2(int i,int[] p,int fee,int[] have,int[] nohave){
        if(nohave[i-1]>have[i-1]+p[i]-fee) return nohave[i-1];
        else return have[i-1]+p[i]-fee;
    }
}