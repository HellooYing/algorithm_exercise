public class reverse {
    public static void main(String[] args) throws Exception {
        int x = -2147483648;
        System.out.println(new reverse().answer(x));
    }

    public int answer(int x) {
        long result = 0;
        int zf = 0;
        int re2;
        if (x == abs(x))
            zf = 1;
        x = abs(x);
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE||result <Integer.MIN_VALUE )
            return 0;
        else
            re2 = (int) result;
        if (zf == 1)
            return re2;
        else
            return 0 - re2;
    }

    public static int abs(int num) {
        return num * (1 - ((num >>> 31) << 1));
    }
}