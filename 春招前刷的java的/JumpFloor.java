import java.util.*;

public class JumpFloor {
    public static void main(String[] args) throws Exception {
        System.out.println(new JumpFloor().answer(1));
    }
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