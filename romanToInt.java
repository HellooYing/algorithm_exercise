import java.util.Arrays;
public class romanToInt {
    public static void main(String[] args) throws Exception {
        String x = "MCMXCIV";
        System.out.println(new romanToInt().answer(x));
    }
    public int answer(String s) {
        String x = s;
        int result = 0;
        char c;
        int p;
        int[] num = { 1000, 500, 100, 50, 10, 5, 1 };
        char[] roman = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
        int max = num.length - 1;
        for (int i = x.length() - 1; i >= 0; i--) {
            c = x.charAt(i);
            p = get_position(roman,c);
            if(max>=p) {
                max=p;
                result=result+num[p];
            }
            else result=result-num[p];
        }
        return result;
    }
    public int get_position(char[] list,char c){
        int re=-1;
        for(int r=0;r<list.length;r++){
            if(list[r]==c) re=r;
        }
        return re;
    }
}