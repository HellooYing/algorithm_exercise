
public class longestPalindrome {
    public static void main(String[] args) throws Exception {
        String s = "20aa0aaaa";
        System.out.println(new longestPalindrome().answer(s));
    }

    public String answer(String s) {
        int l=s.length();
        int i;
        String result,tmp;
        if(l==0||l==1)
            return s;
        if(s.charAt(1)==s.charAt(0)) result=s.charAt(0)+s.charAt(1);
        if(l>2){
            for(i=2;i<l;i++){
                if(s.charAt(i)==s.charAt(i-1)){
                    tmp=getPalindrome(s, i-1, i);
                    if(result.length()<tmp.length()) 
                        result=tmp;
                }
                if(s.charAt(i)==s.charAt(i-2)){
                    tmp=getPalindrome(s, i-2, i);
                    if(result.length()<tmp.length()) 
                        result=tmp;
                }
            }
            return result;
        }
    }
    public String getPalindrome(String s, int j, int i){
        int l=s.length();
        int ii=i+1;
        int jj=j-1;
        int tmp=s.charAt(j)+s.charAt(i);
        while(ii+1<l&&jj-1>=0){
            if(s.charAt(jj)==s.charAt(ii)) tmp=s.charAt(jj)+tmp+s.charAt(ii);
            else break;
            ii=ii+1;
            jj=jj-1;
        }
        return tmp;
    }
}