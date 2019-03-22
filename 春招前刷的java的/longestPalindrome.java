public class longestPalindrome {
    public static void main(String[] args) throws Exception {
        String s = "aaaa";
        System.out.println(new longestPalindrome().answer(s));
    }

    public String answer(String s) {
        int l=s.length();
        int i;
        String result="";
        String tmp;
        if(l==0||l==1)
            return s;
        if(s.charAt(1)==s.charAt(0)) result=s.substring(0,2);
        else result=s.substring(0,1);
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
        }
        return result;
    }
    public String getPalindrome(String s, int j, int i){
        int l=s.length();
        int ii=i+1;
        int jj=j-1;
        StringBuffer tmp = new StringBuffer(s.substring(j,i+1));
        while(ii<l&&jj>=0){
            if(s.charAt(jj)==s.charAt(ii)) tmp=tmp.insert(0, s.charAt(jj)).append(s.charAt(ii));
            else break;
            ii=ii+1;
            jj=jj-1;
        }
        return tmp.toString();
    }
}