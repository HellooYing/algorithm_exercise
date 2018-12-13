import java.util.*;

public class csp2017092 {
    class key{
        boolean lend;
        int rt;
        key(boolean lend1,int rt1){
            this.lend=lend1;
            this.rt=rt1;
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int k= sc.nextInt();
        int[][] wsc=new int[k][3];
        int t=0;
        int i=0;
        while (i<k) {
            wsc[i][0]=sc.nextInt();
            wsc[i][1]=sc.nextInt();
            wsc[i][2]=sc.nextInt();
            if(wsc[i][1]+wsc[i][2]>t) t=wsc[i][1]+wsc[i][2];
            i++;
        }
        sc.close();
        int[] r=new csp2017092().answer(n,t,wsc);
        for(i=0;i<r.length;i++){
            System.out.print(r[i]);
            System.out.print(" ");
        }
    }
    int findX(int[] r){
        for(int i=0;i<r.length;i++){
            if(r[i]==-1) return i;
        }
        return -1;
    }
    int findN(int[] r,int n){
        for(int i=0;i<r.length;i++){
            if(r[i]==n) return i;
        }
        return -1;
    }
    public int[] answer(int n,int t,int[][] wsc){
        int[] r=new int[n];
        key[] k=new key[n];
        for(int i=0;i<n;i++) {
            k[i]=new key(false,-1);
            r[i]=i+1;
        }
        for(int i=1;i<=t;i++){
            for(int j=0;j<n;j++){
                if(k[j].lend){
                    if(k[j].rt==i){
                        r[findX(r)]=j+1;
                        k[j].lend=false;
                        k[j].rt=-1;
                    }
                }
            }
            for(int j=0;j<wsc.length;j++){
                if(i==wsc[j][1]){
                    k[wsc[j][0]-1].lend=true;
                    k[wsc[j][0]-1].rt=wsc[j][1]+wsc[j][2];
                    r[findN(r,wsc[j][0])]=-1;
                }
            }
        }
        return r;
    }
}