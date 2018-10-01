import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Collections;
public class generateParenthesis {
    public static void main(String[] args) throws Exception {
        int a = 3;
        List<String> l=new generateParenthesis().answer(a);
        for(String aa:l)
            System.out.println(aa);
    }

    public List<String> answer(int n) {
        Set hs1 = new HashSet();
        Set hs2 = new HashSet();
        hs1.add("()");
        for(int i=1;i<n;i++){
            for(Object j:hs1){
                hs2.add("()"+j);
                hs2.add("("+j+")");
                hs2.add(j+"()");
            }
            hs1.clear();
            for(Object j:hs2){
                hs1.add(j);
            }
            hs2.clear();
        }
        List<String> l=new ArrayList<String>();
        for(Object j:hs1){
            l.add(j.toString());
        }
        Collections.sort(l);
        return l;
    }
}
