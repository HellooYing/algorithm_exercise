public class isPalindrome {
    public static void main(String[] args) throws Exception {
        int x = 20002;
        System.out.println(new isPalindrome().answer(x));
    }

    public boolean answer(int x) {
        boolean result=true;
        String xx=x+"";
        char head,end;
        int n=xx.length();
        for(int i=0;i<n/2;i++){
            head=xx.charAt(i);
            end=xx.charAt(n-1-i);
            if(head!=end){
                result=false;
                break;
            }
        }
        return result;
    }
}