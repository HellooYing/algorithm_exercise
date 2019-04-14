import java.util.*;

public class zjtd201904141 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        List<String[]> ls=new ArrayList<>();
        String t=in.nextLine();
        int l=t.split(" ").length;
        while(in.hasNextLine()){
            ls.add(t.split(" "));
            t=in.nextLine();
            if(t.equals("")) break;
        }
        in.close();
        int[][] a=new int[ls.size()][l++];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j]=Integer.parseInt(ls.get(i)[j]);
            }
        }
        answer(a);
    }
    static void answer(int[][] a){
        int r=-1;
        boolean flag=true;
        while(flag){
            r++;
            flag=false;
            List<Integer> xy=new ArrayList<>();
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j <a[0].length ; j++) {
                    if(a[i][j]==2){//记录程序员
                        xy.add(i);
                        xy.add(j);
                    }
                }
            }
            if(xy.size()==0){
                System.out.println(-1);
                return;
            }
            for (int i = 0; i <xy.size() ; i=i+2) {
                int x=xy.get(i);
                int y=xy.get(i+1);
                if(x-1>=0&&a[x-1][y]==1){
                    a[x-1][y]=2;
                    flag=true;
                }
                if(x+1<a.length&&a[x+1][y]==1){
                    a[x+1][y]=2;
                    flag=true;
                }
                if(y-1>=0&&a[x][y-1]==1){
                    a[x][y-1]=2;
                    flag=true;
                }
                if(y+1<a[0].length&&a[x][y+1]==1){
                    a[x][y+1]=2;
                    flag=true;
                }
            }
        }
        if(hasCP(a)) System.out.println(-1);
        else System.out.println(r);
    }
//    static void answer(int[][] a){
//        int r=0;
//        while(onceChange(a)){
//            onceOver(a);
//            r++;
//        }
//        if(hasCP(a)) System.out.println(-1);
//        else System.out.println(r);
//    }
    static boolean hasCP(int[][] a){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length ; j++) {
                if(a[i][j]==1) return true;
            }
        }
        return false;
    }
//    static boolean onceChange(int[][] a){
//        boolean changed=false;
//        for (int i = 0; i < a.length; i++) {
//            for (int j = 0; j <a[0].length ; j++) {
//                //如果旁边是2 就变成3 最后再来一次变成2
//                if(a[i][j]==1){
//                    if(i>0){
//                        if(a[i-1][j]==2) {
//                            a[i][j]=3;
//                            changed=true;
//                        }
//                    }
//                    if(i<a.length-1){
//                        if(a[i+1][j]==2) {
//                            a[i][j]=3;
//                            changed=true;
//                        }
//                    }
//                    if(j>0){
//                        if(a[i][j-1]==2) {
//                            a[i][j]=3;
//                            changed=true;
//                        }
//                    }
//                    if(j<a[0].length-1){
//                        if(a[i][j+1]==2) {
//                            a[i][j]=3;
//                            changed=true;
//                        }
//                    }
//                }
//            }
//        }
//        return changed;
//    }
//    static void onceOver(int[][] a){
//        for (int i = 0; i <a.length ; i++) {
//            for (int j = 0; j < a[0].length; j++) {
//                if(a[i][j]==3) a[i][j]=2;
//            }
//        }
//    }
}
