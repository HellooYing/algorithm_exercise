import java.util.*;

public class NumberOf1 {
    public static void main(String[] args) throws Exception {
        System.out.println(new NumberOf1().answer(10));
    }

    public int answer(int a){
        int r=0;
        String s=Integer.toBinaryString(a);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1') r++;
        }
        System.out.println(s);
        return r;
    }
}