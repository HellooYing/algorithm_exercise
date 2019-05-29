public class ReverseSentence {
    //单词反转 把i am a student变成student a am i
    public static void main(String[] args) {
        System.out.println("  ".split(" ").length);
        System.out.println(new ReverseSentence().answer("i am a student"));
    }
    public String answer(String str) {
        if(str==null||str.length()<=1) return str;
        String[] s=str.split(" ");
        if(s.length==0) return str;
        StringBuilder r=new StringBuilder();
        for (int i = s.length-1; i >=0 ; i--) {
            r.append(s[i]);
            if(i!=0) r.append(" ");
        }
        return r.toString();
    }
}
