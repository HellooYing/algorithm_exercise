import java.util.*;
import java.lang.Math;

public class RectCover {
    public static void main(String[] args) throws Exception {
        System.out.println(new RectCover().answer(4));
    }

    //错误：所有的竖着俩是可以拆开放的。
    //所以应该是，对于奇数是，一个竖着插到横着的中间、三个竖着、……全竖着的加起来，
    //对于偶数是，俩竖着、四个竖着
    //这么想有些把问题复杂化了
    //简化问题跟跳台阶差不多，就是可以走1可以走2啊
    static int n=0;
    void dg(int target){
        if(target==1||target==2) n++;
        if(target>1) dg(target-1);
        if(target>2) dg(target-2);
    }
    public int answer(int target){
        n=0;
        dg(target);
        return n;
    }

}