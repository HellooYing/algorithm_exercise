public class intToRoman {
    public static void main(String[] args) throws Exception {
        int x = 20;
        System.out.println(new intToRoman().answer(x));
    }

    public String answer(int xx) {
        int x=xx;
        String result = "";
        int[] num = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] roman = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        while (x != 0) {
            for(int i=0;i<num.length;i++){
                if(x>=num[i]){
                    result=result+roman[i];
                    x=x-num[i];
                    i=i-1;
                }
            }
        }
        return result;
    }
}