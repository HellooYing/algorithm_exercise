import java.util.List;
import java.util.ArrayList;

public class letterCombinations {
    public static void main(String[] args) throws Exception {
        String s ="23";
        System.out.println(new letterCombinations().answer(s));
    }
    public List<String> answer(String digits) {
        char[][] letter={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        List<Integer> d=new ArrayList<Integer>();
        List<String> result=new ArrayList<String>();
        for(int i=0;i<digits.length();i++){
            int num=Integer.parseInt(String.valueOf(digits.charAt(i)));
            d.add(num);
        }
        if(d.size()==0) return result;
        for(int i=0;i<letter[d.get(0)].length;i++){
            result.add(String.valueOf(letter[d.get(0)][i]));
        }
        if(d.size()==1) return result;
        for(int i=0;i<d.size()-1;i++){
            while(result.get(0).length()!=i+2){
                char qqq=digits.charAt(i+1);
                int my=Integer.parseInt(String.valueOf(digits.charAt(i+1)));
                for(char tmp:letter[Integer.parseInt(String.valueOf(digits.charAt(i+1)))]){
                    result.add(result.get(0).concat(String.valueOf(tmp)));
                }
                result.remove(0);
            }
        }
        return result;
    }
}