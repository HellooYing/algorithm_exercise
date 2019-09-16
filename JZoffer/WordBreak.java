import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class WordBreak {
    public static void main(String[] args) {
        String s="bb";
        List<String> wordDict=new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");
        System.out.println(new WordBreak().wordBreak(s,wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        dg(s,wordDict);
        return value;
    }
    boolean value=false;
    public void dg(String s, List<String> wordDict) {
        if(value) return;
        /**
         * 从尾开始，符合某个单词的就递归查找除此单词外前面是否也符合
         * 有任意个匹配到s为空字符串，则返回成功
         */
        if(s.length()==0){
            value=true;
            return;
        }
        for (int i = 0; i <wordDict.size() ; i++) {
            if(s.length()-wordDict.get(i).length()>=0&&s.substring(s.length()-wordDict.get(i).length()).equals(wordDict.get(i))){
                String st=s.substring(0,s.length()-wordDict.get(i).length());
                dg(st,wordDict);
            }
        }
    }
}
