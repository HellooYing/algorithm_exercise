import java.util.*;
import java.lang.Math.*;
public class movingCount {
    public static void main(String[] args) throws Exception {
        System.out.println(new movingCount().answer(10,1,100));
    }
    public int answer(int threshold, int rows, int cols){
        if(threshold <= 0 || rows <= 0 || cols <= 0) return 0;
        int k=threshold,m=rows-1,n=cols-1;
        Set s = new HashSet();
        //不是所有符合要求的格子都能去 可能被不能去的格子包围拦截了
        //所以递归，依次检测上下左右能不能走，能走再继续递归，符合要求的加到set里避免重复，最后统计set长度
        //因为是m行n列，所以应该不存在负数行列
        dg(k,0,0,s,m,n);
        List list = new ArrayList(s);
        Collections.sort(list);
        System.out.println(list.toString());
        return s.size();
    }
    public void dg(int k,int x,int y, Set s, int m, int n){
        if(x<0||y<0||x>m||y>n) return;
        System.out.print("x:");System.out.print(x);System.out.print("y:");System.out.print(y);
        System.out.println();
        int a,b,c,d;
        a=x/10%10;
        b=x-10*a;
        c=y/10%10;
        d=y-10*c;
        System.out.print("a:");System.out.print(a);System.out.print("b:");System.out.print(b);System.out.print("c:");System.out.print(c);System.out.print("d:");System.out.print(d);
        System.out.println();
        System.out.println();
        if(a+b+c+d<=k) s.add(a*1000+b*100+c*10+d);
        else return;
        if(!s.contains(a*1000+b*100+c*10+d-100)) dg(k,a*10+b-1,c*10+d,s,m,n);
        if(!s.contains(a*1000+b*100+c*10+d-1)) dg(k,a*10+b,c*10+d-1,s,m,n);
        if(!s.contains(a*1000+b*100+c*10+d+100)) dg(k,a*10+b+1,c*10+d,s,m,n);
        if(!s.contains(a*1000+b*100+c*10+d+1)) dg(k,a*10+b,c*10+d+1,s,m,n);
    }
}