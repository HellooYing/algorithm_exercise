import java.util.*;
public class lengthOfLongestSubstring {
    public static void main(String[] args) throws Exception {
        String s="abdsa";
        System.out.println(new lengthOfLongestSubstring().answer(s));
    }
    public int answer(String s){
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        char c;
        int max=0;
        int pre=-1;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            if(!h.containsKey(c)||h.get(c)<pre){
                if(max<i-pre) max=i-pre;
                h.put(c,i);
            }
            else{
                pre=h.get(c);
                if(max<i-pre) max=i-pre;
                h.put(c,i);
            }
        }
        return max;
    }
}
