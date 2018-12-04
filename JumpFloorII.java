import java.util.*;

public class JumpFloorII {
    public static void main(String[] args) throws Exception {
        System.out.println(new JumpFloorII().answer(3));
    }
    static int n=0;
    void dg(int target){
        n++;
        for(int i=1;i<=target;i++){
            if(target>i) dg(target-i);
        }
    }
    public int answer(int target){
        n=0;
        dg(target);
        return n;
    }

}