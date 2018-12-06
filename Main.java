import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in); 
        int n= sc.nextInt();
        int L= sc.nextInt();
        int t= sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        sc.close();
        answer(n, L, t, a);
        for(int i:a){
            System.out.print(i);
            System.out.print(" ");
        }
    }
    static void after1(int n,int L,int[] a,int[] v){
        for(int i=0;i<n;i++){
            if(v[i]==0&&a[i]==0) v[i]=1;
            else if(v[i]==0&&a[i]==L) v[i]=-1; 
            if(i<n-1){
                if(a[i]==a[i+1]){
                    v[i]=-v[i];
                    v[i+1]=-v[i+1];
                }
            }
            a[i]=a[i]+v[i];
            if(a[i]<0) {a[i]=-a[i];v[i]=-v[i];}
            else if(a[i]>L) {a[i]=2*L-a[i];v[i]=-v[i];}
            else if(a[i]==0||a[i]==L) v[i]=0;
        }
    }
    static void answer(int n,int L,int t,int[] a){
        int[] first=new int[n];
        for(int i=0;i<n;i++) first[i]=a[i];
        int[] v=new int[n];
        for(int i=0;i<n;i++) v[i]=1;
        for(int i=0;i<n;i++){
            if(a[i]==0||a[i]==L) v[i]=0;
        }
        int[] vfirst=new int[n];
        for(int i=0;i<n;i++) vfirst[i]=v[i];
        int cycle=-1;
        for(int i=0;i<t;i++){
            after1(n,L,a,v);
            if(i!=0&&Arrays.equals(a, first)&&Arrays.equals(v, vfirst)){
                cycle=i+1;
                break;
            }
        }
        if(cycle!=-1){
            t=t%cycle;
            for(int i=0;i<t;i++){
                after1(n,L,a,v);
            }
        }
        
    }
}