import java.util.*;

public class zjtd201904145 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][] all=new int[n][];
        for (int i = 0; i <n ; i++) {
            int m=in.nextInt();
            int[] people=new int[m];
            for (int j = 0; j < m; j++) {
                people[j]=in.nextInt();
            }
            all[i]=people;
        }
        in.close();
        for(int[] p:all){
            answer(p);
        }
    }
    static void answer(int[] p){
        //每次都是用时最短的两个人带用时最长的人过去再回来
        Arrays.sort(p);
        if(p.length<=3){
            System.out.println(p[p.length-1]);
            return;
        }
        int r=0;
        for (int i = 2; i <p.length ; i++) {
            r+=p[i];
            r+=p[1];
        }
        r-=p[1];
        System.out.println(r);
    }
}
