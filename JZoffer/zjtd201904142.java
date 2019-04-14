import java.util.*;

public class zjtd201904142 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int[][][] allVideo=new int[n][][];
        for (int i = 0; i <n ; i++) {
            int z=in.nextInt();
            int[][] video=new int[z][];
            for (int j = 0; j <z ; j++) {
                int fn=in.nextInt();
                int[] feature=new int[2*fn];
                for (int k = 0; k <2*fn; k++) {
                    feature[k]=in.nextInt();
                }
                video[j]=feature;
            }
            allVideo[i]=video;
        }
        in.close();
        for(int[][] v:allVideo){
            answer(v);
        }
    }
    static void answer(int[][] v){
        int r=0;
        for (int i = 0; i <v.length ; i++) {
            for (int j = 0; j <v[i].length ; j=j+2) {
                int t=getMax(v,i,j);
                if(r<t) r=t;
            }
        }
        System.out.println(r);
    }
    static int getMax(int[][] v,int y,int x){
        //从x，y和x+1，y开始
        //向下找xy相同的
        int r=1;
        while(true){
            if(y+1<v.length
                    &&x<v[y+1].length
                    &&v[y][x]==v[y+1][x]
                    &&v[y][x+1]==v[y+1][x+1]){
                r++;
                y++;
            }
            else return r;
        }
    }
}
