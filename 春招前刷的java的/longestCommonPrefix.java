public class longestCommonPrefix {
    public static void main(String[] args) throws Exception {
        String[] strs ={"au","a"};
        System.out.println(new longestCommonPrefix().answer(strs));
    }
    public String answer(String[] strs) {
        if(strs.length==0) return "";
        String result=strs[0];
        for(int i=1;i<strs.length;i++){
            result=getCommonPrefix(result,strs[i]);
        }
        return result;
    }
    public String getCommonPrefix(String result,String str){
        int i;
        for(i=0;i<str.length()&&i<result.length();i++){
            if(result.charAt(i)!=str.charAt(i)) break;
        }
        String result1=result.substring(0,i);
        return result1;
    }
}