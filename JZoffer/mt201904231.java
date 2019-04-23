import java.util.*;
public class mt201904231 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        int[][] a=new int[n][m];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                a[i][j]=in.nextInt();
            }
        }
        in.close();
        System.out.println(answer(a));
    }
    static int answer(int[][] a){
        if(a.length==0||a[0].length==0) return 0;
        int r=0;
        List<Integer> black=new ArrayList<>(),white=new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int row=j%2;
                int col=i%2;
                if((row==0&&col==0)||row==1&&col==1) white.add(a[i][j]);
                else black.add(a[i][j]);
            }
        }
        Collections.sort(black);
        Collections.sort(white);
        int bl=black.size();
        int wl=white.size();
        int[] bn=max_num(black);
        int[] wn=max_num(white);
        int change=bn[0]+wn[0];
        if(bn[1]==wn[1]) {
            del(white,wn[1]);
            int[] wn2=max_num(white);
            del(black,bn[1]);
            int[] bn2=max_num(black);
            change=Math.max(bn[0]+wn2[0],bn2[0]+wn[0]);
        }
        r=bl+wl-change;
        return r;
    }
    static void del(List<Integer> l,int n){
        for (int i = 0; i < l.size(); i++) {
            if(l.get(i)==n){
                l.remove(i);
                i--;
            }
        }
    }
    static int[] max_num(List<Integer> l){
        if(l.size()==0) return new int[2];
        int max=0,max_num=0,num=l.get(0),n=1;

        for (int i = 1; i <l.size() ; i++) {
            if(l.get(i)==num) n++;
            else{
                if(max<n){
                    max=n;
                    max_num=num;
                }
                num=l.get(i);
                n=1;
            }
        }
        if(max<n){
            max=n;
            max_num=num;
        }
        int[] r=new int[2];
        r[0]=max;
        r[1]=max_num;
        return r;
    }
}
