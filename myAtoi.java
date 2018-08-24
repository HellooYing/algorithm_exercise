import java.util.Arrays;
public class myAtoi{
    public static void main(String[] args) throws Exception {
        String s ="4193 with words";
        System.out.println(new myAtoi().answer(s));
    }
    public int answer(String s) {
        int result=0;
        int l=s.length();
        int i;
        int j=0;
        int key=0;
        if(l==0) return 0;
        for(i=0;i<l;i++){
            if(s.charAt(i)==' '&&key==0) j++;
            else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)-'0'<=9) key=1;
            else if(s.charAt(i)-'0'>9||(s.charAt(i)==' '&&key==1)) break;
        }
        if(i==0||i==j) return 0;
        s=s.substring(j,i);
        System.out.println(s);
        try{
            result=Integer.parseInt(s);
        }catch(NumberFormatException e){
            if(s.charAt(0)=='-') return -2147483648;
            else return 2147483647;
        }
        return result;
    }
}