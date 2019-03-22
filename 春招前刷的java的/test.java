import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int t = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        answer(n, L, t, a);
        for (int i : a) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

    static void after1(int n, int L, int[] a, int[] v) {
        for (int i = 0; i < n; i++) {

            a[i] = a[i] + v[i];
            if (a[i] == 0) {
                v[i] = 1;
            } else if (a[i] == L) {
                v[i] = -1;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] == a[j]) {
                    v[i] *= -1;
                    v[j] *= -1;
                    break;
                }
            }
        }
    }

    static void answer(int n, int L, int t, int[] a) {
        int[] v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = 1;
        for (int i = 0; i < t; i++) {
            after1(n, L, a, v);
        }
    }
}