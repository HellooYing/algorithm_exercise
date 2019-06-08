import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 */
public class groupAnagrams {
    public static void main(String[] args) {
        String[] ss=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new groupAnagrams().answer(ss));
    }
    List<List<String>> answer(String[] strs){
        List<List<String>> r;
        HashMap<String,List<String>> map=new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] cs=strs[i].toCharArray();
            Arrays.sort(cs);
            String s=String.valueOf(cs);
            List<String> ls=map.get(s);
            if(ls==null){
                ls=new ArrayList<>();
                ls.add(strs[i]);
                map.put(s,ls);
            }
            else{
                ls.add(strs[i]);
                map.put(s,ls);
            }
        }
        Collection<List<String>> coll= map.values();
        r = new ArrayList(coll);
        return r;
    }
}
