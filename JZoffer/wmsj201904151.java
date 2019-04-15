import java.util.*;

public class wmsj201904151 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        List<Integer> a=new ArrayList<>();
        List<Integer> b=new ArrayList<>();
        for (int i = 0; i <n ; i++) {
            a.add(in.nextInt());
        }
        for (int i = 0; i <n ; i++) {
            b.add(in.nextInt());
        }
        in.close();
        System.out.println(answer(a,b));
    }
    static int answer(List<Integer> a,List<Integer> b){
        Collections.sort(a);
        Collections.sort(b);
        //对于a，如果a最大打不过b最大，就把a0移动到最后，再打不过a1，依次移动。移完a最大移a次大，直到抵达a0
        for (int i = a.size()-1; i >=0 ; i--) {
            while(a.get(i)<b.get(i)){
                a.add(a.remove(0));
                i--;
            }
        }
        int r=0;
        for (int i = 0; i < a.size(); i++) {
            if(a.get(i)>b.get(i)) r+=100;
            else if(a.get(i)<b.get(i)) r-=100;
        }
        return r;
    }
//    static int answer(List<Integer> a,List<Integer> b){
//        if(a.size()==1&&b.size()==1){
//            if(a.get(0)>b.get(0)){
//                return 100;
//            }
//            else if(a.get(0)==b.get(0)){
//                return 0;
//            }
//            else return -100;
//        }
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < a.size(); i++) {
//            for (int j = 0; j <b.size() ; j++) {
//                List<Integer> a1=new ArrayList<>();
//                a1.addAll(a);
//                a1.remove(i);
//                List<Integer> b1=new ArrayList<>();
//                b1.addAll(b);
//                b1.remove(j);
//                int t=answer(a1,b1);
//                if(a.get(i)>b.get(j)){
//                    t+=100;
//                }
//                else if(a.get(i)<b.get(j)){
//                    t-=100;
//                }
//                if(max<t) max=t;
//            }
//        }
//        return max;
//    }

}
