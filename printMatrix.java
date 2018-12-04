import java.util.*;

public class printMatrix {
    public static void main(String[] args) throws Exception {
        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(new printMatrix().answer(matrix).toString());
    }

    public ArrayList<Integer> answer(int[][] matrix) {
        int[][] m = matrix;
        int flag = 0;
        ArrayList<Integer> r = new ArrayList<Integer>();
        if (m.length == 0)
            return r;
        int i1 = 0, i2 = m[0].length - 1, j1 = 0, j2 = m.length - 1;
        while (i1 < i2 && j1 < j2) {
            flag = 0;
            if (i1 <= i2) {
                for (int i = i1; i <= i2; i++) {
                    r.add(m[j1][i]);
                }
                j1++;
                flag = 1;
            }
            System.out.println(r.toString());
            if (j1 <= j2) {
                for (int j = j1; j <= j2; j++) {
                    r.add(m[j][i2]);

                }
                flag = 2;
                i2--;
            }
            System.out.println(r.toString());
            if (i1 <= i2) {
                for (int i = i2; i >= i1; i--) {
                    r.add(m[j2][i]);

                }
                flag = 3;
                j2--;
            }
            System.out.println(r.toString());
            if (j1 <= j2) {
                for (int j = j2; j >= j1; j--) {
                    r.add(m[j][i1]);

                }
                flag = 4;
                i1++;
            }
            System.out.println(r.toString());
        }
        System.out.println(flag);
        if (m.length * m[0].length != r.size()) {
            if (flag == 2 || flag == 3) {
                if (i1 != i2) {
                    for (int i = i2; i >= i1; i--)
                        r.add(m[j1][i]);
                } else if (j1 != j2) {
                    for (int j = j2; j >= j1; j--)
                        r.add(m[j][i1]);
                } else
                    r.add(m[j1][i1]);
            } else if (flag == 0 || flag == 4 || flag == 1) {
                if (i1 != i2) {
                    for (int i = i1; i <= i2; i++)
                        r.add(m[j1][i]);
                } else if (j1 != j2) {
                    for (int j = j1; j <= j2; j++)
                        r.add(m[j][i1]);
                } else
                    r.add(m[j1][i1]);
            }
        }
        return r;
    }
}
