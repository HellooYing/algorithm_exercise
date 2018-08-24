import java.util.Arrays;
public class myAtoi{
    public static void main(String[] args) throws Exception {
        String s ="-5-";
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
            if(s.charAt(i)==' '&&key==0) {
                j++;
                continue;
            }
            else if((s.charAt(i)=='+'&&key==0)||(s.charAt(i)=='-'&&key==0)||(s.charAt(i)-'0'<=9&&s.charAt(i)-'0'>=0&&s.charAt(i)!=' ')) key=1;
            else if(s.charAt(i)-'0'>9||s.charAt(i)-'0'<0||s.charAt(i)==' ') break;
        }
        if(i==0||i==j||(l==1&&(s.charAt(0)=='+'||s.charAt(0)=='-'))) return 0;
        s=s.substring(j,i);
        if(s.length()==1&&(s.charAt(0)=='+'||s.charAt(0)=='-')) return 0;
        key=0;
        for(int k=0;k<s.length();k++){
            if(key==1&&(s.charAt(k)=='+'||s.charAt(k)=='-')) return 0;
            if(key==0&&(s.charAt(k)=='+'||s.charAt(k)=='-')) key=1;
        }
        try{
            result=Integer.parseInt(s);
        }catch(NumberFormatException e){
            if(s.charAt(0)=='-') {
                for(i=1;i<s.length();i++){
                    if(s.charAt(i)-'0'<0||s.charAt(i)-'0'>9) return 0;
                }
                return -2147483648;
            }
            else if(s.charAt(0)=='+') {
                for(i=1;i<s.length();i++){
                    if(s.charAt(i)-'0'<0||s.charAt(i)-'0'>9) return 0;
                }
                return 2147483647;
            }
            else {
                for(i=0;i<s.length();i++){
                    if(s.charAt(i)-'0'<0||s.charAt(i)-'0'>9) return 0;
                }
                return 2147483647;
            }
        }
        return result;
    }
}