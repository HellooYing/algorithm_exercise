import java.util.*;

public class csp2018092 {
    static int big(int a,int b){
        if(a>b) return a;
        else return b;
    }
    static int small(int a,int b){
        if(a>b) return b;
        else return a;
    }
    public static void main(String[] args){
        csp2018092 a=new csp2018092();
        int[][] h1={{1,3},{4,8},{9,12}};
        int[][] w1={{2,5},{6,10},{11,13}};
        System.out.println(a.answer(h1, w1)==6);
        int[][] h2={{1,3},{4,6}};
        int[][] w2={{2,5},{7,8}};
        System.out.println(a.answer(h2, w2)==2);
        int[][] h3={{1,6},{7,8}};
        int[][] w3={{2,3},{4,5}};
        System.out.println(a.answer(h3, w3)==2);
        int[][] h4={{1,3},{5,6},{9,13},{14,15}};
        int[][] w4={{2,4},{5,7},{10,11},{13,14}};
        System.out.println(a.answer(h4, w4)==3);
        int[][] h5={{1,2},{3,4}};
        int[][] w5={{1,2},{3,4}};
        System.out.println(a.answer(h5, w5)==2);
        int[][] h6={{1,2},{3,4}};
        int[][] w6={{1,2},{3,5}};
        System.out.println(a.answer(h6, w6)==2);
        int[][] h7={{1,2},{5,7}};
        int[][] w7={{1,3},{4,6}};
        System.out.println(a.answer(h7, w7)==2);
    }
    static int answer(int[][] h,int[][] w){
        int n=h.length;
        int hn=0,wn=0,r=0,t;
        while(hn+wn<2*n-2){
            t=small(h[hn][1],w[wn][1])-big(h[hn][0],w[wn][0]);
            if(t>0) r+=t;
            if(h[hn][1]>w[wn][1]&&wn<n-1) wn++;
            else if(hn<n-1) hn++;
        }
        t=small(h[hn][1],w[wn][1])-big(h[hn][0],w[wn][0]);
        if(t>0) r+=t;
        return r;
    }
}