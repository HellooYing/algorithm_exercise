import java.util.*;

public class csp2018032 {
    public static void main(String[] args) {
        Random random = new Random();
        int n=3, l=20, t=13;
        int[] a={6,10,12};
        int[] b;
        int[] c;
        Main f1 = new Main();
        test f2 = new test();

        for (int wc = 0; wc < 1000; wc++) {
            l = random.nextInt(10) + 10;
            if (l % 2 == 1)
                l++;
            n = random.nextInt((int) (l - 8) / 2) + 2;
            t = random.nextInt(50) + 1;
            a = new int[n];
            b = new int[n]; 
            c = new int[n];
            int flag;
            for (int i = 0; i < n; i++) {
                flag = 1;
                a[i] = random.nextInt((int) l / 2 - 3) + 3;
                a[i] = a[i] * 2;
                for (int j = 0; j < i; j++) {
                    if (a[j] == a[i]) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) {
                    i = i - 1;
                }
            }
            Arrays.sort(a);
            for (int i = 0; i < n; i++){
                b[i] = a[i];
                c[i] = a[i];
            }
                
            f1.answer(n, l, t, a);
            f2.answer(n, l, t, b);
            if (!Arrays.equals(a, b)) {
                
                System.out.println();
                System.out.print("l:");
                System.out.print(l);
                System.out.print(" n:");
                System.out.print(n);
                System.out.print(" t:");
                System.out.print(t);
                System.out.println(" ");
                for (int i : a) { 
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println(" ");
                for (int i : b) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println(" ");
                for (int i : c) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                break;
            }
            else{
                System.out.println(wc);System.out.print("true");
            }
        }

    }

    static void after1(int n, int L, int[] a, int[] v) {
        for (int i = 0; i < n; i++) {
            if (v[i] == 0 && a[i] == 0)
                v[i] = 1;
            else if (v[i] == 0 && a[i] == L)
                v[i] = -1;
            if (i < n - 1) {
                if (a[i] == a[i + 1]) {
                    v[i] = -v[i];
                    v[i + 1] = -v[i + 1];
                }
            }
            a[i] = a[i] + v[i];
            if (a[i] < 0) {
                a[i] = -a[i];
                v[i] = -v[i];
            } else if (a[i] > L) {
                a[i] = 2 * L - a[i];
                v[i] = -v[i];
            } else if (a[i] == 0 || a[i] == L)
                v[i] = 0;
        }
    }

    static void answer(int n, int L, int t, int[] a) {
        int[] first = new int[n];
        for (int i = 0; i < n; i++)
            first[i] = a[i];
        int[] v = new int[n];
        for (int i = 0; i < n; i++)
            v[i] = 1;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0 || a[i] == L)
                v[i] = 0;
        }
        int[] vfirst = new int[n];
        for (int i = 0; i < n; i++)
            vfirst[i] = v[i];
        int cycle = -1;
        for (int i = 0; i < t; i++) {
            after1(n, L, a, v);
            if (i != 0 && Arrays.equals(a, first) && Arrays.equals(v, vfirst)) {
                cycle = i + 1;
                break;
            }
        }
        if (cycle != -1) {
            //System.out.println("cycle ".concat("" + cycle));
            t = t % cycle;
            //System.out.println("t ".concat("" + t));
            for (int i = 0; i < t; i++) {
                after1(n, L, a, v);
            }
        }

    }
}