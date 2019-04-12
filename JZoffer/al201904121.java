import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class al201904121 {
    static HashMap<Integer,Integer> fnum=new HashMap<>();

    static String calculate(int m, int k) {
        int r1=f(m);
        List<Integer> a=new ArrayList<Integer>();
        System.out.println(r1+",");
        int r2=0;
        for (int i = 1; i <= m; i++) {
            if(fnum.get(i)==null) fnum.put(i,f(i));
            StringBuilder num=new StringBuilder(fnum.get(i).toString());
            num.reverse();
            if(insertSort(a,Integer.parseInt(num.toString()),k)) r2=i;
        }
        System.out.print(getYear(6)+",");
        System.out.print(r2+1);
        return "";
    }
    static int getYear(int m){
        if(m<3) return m+2;
        else return getYear(m-1)+getYear(m-3);
    }
    static boolean insertSort(List<Integer> a,int num,int k){
        if(a.size()<k){
            int l=a.size();
            for (int i = 0; i <l ; i++) {
                if(a.get(i)<num) {
                    a.add(i,num);
                    break;
                }
            }
            if(l==a.size()){
                a.add(num);
                if(a.size()==k) return true;
            }
            return false;
        }
        else{
            int l=a.size();
            for (int i = 0; i <l ; i++) {
                if(a.get(i)<num) {
                    a.add(i,num);
                    if(i==k) return true;
                    else break;
                }
            }
            if(l==a.size()) a.add(num);
            return false;
        }
    }

    static int f(int m){
        if(m<5) {
            fnum.put(m,m+1);
            return m+1;
        }
        else{
            int r=0;
            if(fnum.get(m-2)==null) fnum.put(m-2,f(m-2));
            r+=fnum.get(m-2);
            if(fnum.get(m-3)==null) fnum.put(m-3,f(m-3));
            r+=fnum.get(m-3);
            fnum.put(m,r);
            return r;
        }
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int m = Integer.valueOf(line[0]);
        int k = Integer.valueOf(line[1]);;
        System.out.println(calculate(m, k));
    }
}