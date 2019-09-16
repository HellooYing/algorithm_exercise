/**
 * @author zhaole.myy
 * @date 2019/9/16
 */
public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(new CountSubstrings().countSubstrings("abc"));
    }
    public int countSubstrings(String s) {
        /**
         * 就是以新字符为结尾，产生几个新的回文串，最少本身1个，检查到头为止
         */
        int[] nums=new int[s.length()];
        nums[0]=1;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <=i ; j++) {
                if(isHuiWen(s.substring(j,i+1))) nums[i]++;
            }
        }
        int r=0;
        for (int i = 0; i <nums.length ; i++) {
            r+=nums[i];
        }
        return r;
    }
    private boolean isHuiWen(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
