import java.util.*;


public class wmsj201904152 {
    static List<Integer> allWaysLowBlood=new ArrayList<>();
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
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
        if(a.length==0||a[0].length==0) return 1;
        dg(0,0,a,new ArrayList<Integer>());
        int result=allWaysLowBlood.get(0);
        for (int i = 1; i <allWaysLowBlood.size() ; i++) {
            if(result<allWaysLowBlood.get(i)) result=allWaysLowBlood.get(i);
        }
        //System.out.println(allWaysLowBlood);
        return -result+1;
    }
    static void dg(int x,int y,int[][] a,List<Integer> way){
        if(x==a.length-1&&y==a[0].length-1){
            List<Integer> zway=new ArrayList<>();
            zway.addAll(way);
            zway.add(a[x][y]);
            //System.out.println(zway);
            allWaysLowBlood.add(getLowBlood(zway));
        }
        if(x<a.length-1){
            List<Integer> xway=new ArrayList<>();
            xway.addAll(way);
            xway.add(a[x][y]);
            dg(x+1,y,a,xway);
        }
        if(y<a[0].length-1){
            List<Integer> yway=new ArrayList<>();
            yway.addAll(way);
            yway.add(a[x][y]);
            dg(x,y+1,a,yway);
        }
    }
    static int getLowBlood(List<Integer> way){
        int lowBlood=0;
        int blood=way.get(0);
        if(lowBlood>blood) lowBlood=blood;
        for (int i = 1; i <way.size() ; i++) {
            blood+=way.get(i);
            if(lowBlood>blood) lowBlood=blood;
        }
        return lowBlood;
    }
}
