public class lengthOfLastWord {
    public static void main(String[] args) throws Exception {
        String s="  q aaa";
        System.out.println(new lengthOfLastWord().answer(s));
    }
public int answer(String s){
    int r=0;
    int l=s.length();
    int k=0;
    for(int i=l-1;i>=0;i--){
        if(s.charAt(i)!=' ') {
            r++;
            if(k==0) k=1;
        }
        else if(s.charAt(i)==' '&&k==1) break;
    }
    return r;
    }
}