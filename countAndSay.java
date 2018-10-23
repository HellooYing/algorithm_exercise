public class countAndSay {
    public static void main(String[] args) throws Exception {
        int n=5;
        System.out.println(new countAndSay().answer(n));
    }
public String answer(int n){
    String result="";
    String s="1";
    int i=0;
    int m=1;
    char t;
    int l;
    for(int j=1;j<n;j++){
        l=s.length();
        for(i=0;i<l-1;i++){
            t=s.charAt(i);
            if(t!=s.charAt(i+1)){
                result=result+String.valueOf(m)+String.valueOf(t);
                m=1;
            }
            else{
                m++;
            }
        } 
        result=result+String.valueOf(m)+String.valueOf(s.charAt(l-1));
        s=result;
        result="";
        m=1;
    }
    result=s;
    return result;
    }
}