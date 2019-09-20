import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhaole.myy
 * @date 2019/9/20
 */
public class tx2019092002 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        List<Integer> l=new ArrayList<>();
//        for (int i = 0; i <n ; i++) {
//            int num=sc.nextInt();
//            int time=sc.nextInt();
//            for (int j = 0; j < num; j++) {
//                l.add(time);
//            }
//        }
//        Collections.sort(l);
//        System.out.println(answer(l));
//    }
//    public static int answer(List<Integer> l){
//        int max=l.get(0)+l.get(l.size()-1);
//        for (int i = 1; i <l.size()/2 ; i++) {
//            int time=l.get(i)+l.get(l.size()-i-1);
//            if(max<time) max=time;
//        }
//        return max;
//    }
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> num=new ArrayList<>();
        List<Integer> time=new ArrayList<>();
        num.add(sc.nextInt());
        time.add(sc.nextInt());
        for (int i = 1; i <n ; i++) {
            int tnum=sc.nextInt();
            int ttime=sc.nextInt();
            if(ttime>time.get(time.size()-1)){
                time.add(ttime);
                num.add(tnum);
            }
            else{
                for (int j = 0; j <time.size() ; j++) {
                    if(time.get(j)>=ttime){
                        time.add(j,ttime);
                        num.add(j,tnum);
                        break;
                    }
                }
            }
        }
        sc.close();
        System.out.println(answer(num,time));
    }
    public static int answer(List<Integer> num,List<Integer> time){
        int max=time.get(0)*2;
        for (int i = 0,j=num.size()-1; i<=j; ) {
            int timesum=time.get(i)+time.get(j);
            if(max<timesum) max=timesum;
            if(num.get(i)>num.get(j)){
                num.set(i,num.get(i)-num.get(j));
                //num.set(j,0);
                j--;
            }
            else if(num.get(i)==num.get(j)){
                //num.set(i,0);
                //num.set(j,0);
                i++;
                j--;
            }
            else {
                //num.set(i,0);
                num.set(j,num.get(i)-num.get(j));
                i++;
            }
        }
        return max;
    }
}
