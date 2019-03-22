import java.util.List;
import java.util.ArrayList;
import javax.swing.text.StyledEditorKit.BoldAction;

public class lengthOfLongestSubstring {
    public static void main(String[] args) throws Exception {
        String s ="au";
        System.out.println(new lengthOfLongestSubstring().answer(s));
    }
    public int answer(String s) {
        List<Character> l=new ArrayList<Character>();
        char c;
        char cc;
        int r=0;
        int tmp;
        int len=s.length();
        if(len==1) return 1;
        for(int i=0;i<len;i++){
            c=s.charAt(i);
            l.add(c);
            for(int j=i+1;j<len;j++){
                cc=s.charAt(j);
                if(!l.contains(cc)){
                    l.add(cc);
                }
                else
                    break;
            }
            tmp=l.size();
            if(tmp>r){
                r=tmp;
            }
            l.clear();
        }
        return r;
    }
}