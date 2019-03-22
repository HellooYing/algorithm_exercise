import java.util.*;

public class csp2017032 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int k= sc.nextInt();
        int[][] tz=new int[k][2];
        int i=0;
        while (i<k) {
            tz[i][0]=sc.nextInt();
            tz[i][1]=sc.nextInt();
            i++;
        }
        sc.close();
        int[] r=new csp2017032().answer(n,tz);
        for(i=0;i<r.length;i++){
            System.out.print(r[i]);
            System.out.print(" ");
        }
    }
    void move(int[] a,int i,int j){//a[i] move to a[j]
        if(i<j){
            int t= a[i];
        while(i<j){
            a[i]=a[i+1];
            i++;
        }
        a[j]=t;
        }
        else if(i>j){
            int t= a[i];
            while(j<i){
                a[i]=a[i-1];
                i--;
            }
            a[j]=t;
        }
    }
    int find(int[] r,int n){
        for(int i=0;i<r.length;i++){
            if(r[i]==n) return i;
        }
        return -1;
    }
    public int[] answer(int n,int[][] tz){
        int[] r=new int[n];
        int t;
        for(int i=0;i<n;i++){
            r[i]=i+1;
        }
        for(int i=0;i<tz.length;i++){
            t=find(r,tz[i][0]);
            move(r,t,t+tz[i][1]);
        }
        return r;
    }
}