import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaole.myy
 * @date 2019/9/14
 */
public class DistinctSubstring {
    public static void main(String[] args) {
        DistinctSubstring distinctSubstring=new DistinctSubstring();
        System.out.println(distinctSubstring.longestSubstring("spnvw",5));
    }
    public int longestSubstring(String a, int n) {
        Map<Character,Integer> map=new HashMap<>();
        int max=0;
        int pre=-1;
        for (int i = 0; i < a.length(); i++) {
            char c=a.charAt(i);
            int last=-1;
            if(map.get(c)!=null){
                last=map.get(c);
            }
            map.put(c,i);
            int l;
            if(pre>last){
                l=i-pre;
            }
            else{
                pre=last;
                l=i-last;
            }
            if(l>max) max=l;
        }
        return max;
    }
}
