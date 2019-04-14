import java.util.*;

public class zjtd201904144 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] a=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                a[i][j]=in.nextInt();
            }
        }
        in.close();
        answer(a);
    }
    static void answer(int[][] a){
        List<Integer> gone=new ArrayList<>();
        gone.add(0);
        int r=Integer.MAX_VALUE;
        for (int i = 1; i <a.length ; i++) {
            int t=dg(a,gone,i);
            t+=a[0][i];
            if(t<r) r=t;
        }
        System.out.println(r);
    }
    static int dg(int[][] a,List<Integer> gone,int go){
        List<Integer> gone2=new ArrayList<>();
        gone2.addAll(gone);
        gone2.add(go);
        int r=Integer.MAX_VALUE;
        if(gone2.size()==a.length-1){
            for (int i = 0; i <a.length ; i++) {
                if(!gone2.contains(i)){
                    r=a[go][i];
                    r+=a[i][0];
                    return r;
                }
            }
        }
        for (int i = 1; i < a.length; i++) {
            if(!gone2.contains(i)){
                int t=dg(a,gone2,i);
                t+=a[go][i];
                if(r>t) r=t;
            }
        }
        return r;
    }
}
