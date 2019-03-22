import java.util.*;
import java.lang.Math;

public class nk201903141 {
    static Map<Integer,List<Integer>> l = new HashMap<Integer,List<Integer>>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.close();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        list1.add(1);
        list1.add(1);
        list2.add(1);
        list2.add(-1);
        int re=Math.min(f(1,1,n,1,k,list1),f(1,-1,n,1,k,list2));
        System.out.println(re);
        System.out.println(l.get(re));
    }

    public static int f(int me, int n1, int n, int k1, int k, List<Integer> list) {
        // n1是当前数字，n是目标数字，k1是当前层数，k是目标层数，me是当前节点序号
        if (k1 == k) {
            if (n1 == n) {
                int r = 0;
                for (int i = 0; i < list.size(); i = i + 2) {
                    r += list.get(i);
                }
                l.put(r,list);
                return r;
            } else
                return Integer.MAX_VALUE;
        }

        List<Integer> l1 = new ArrayList<Integer>();
        l1.addAll(list);
        l1.add(2 * me);
        l1.add(1);
        List<Integer> l0 = new ArrayList<Integer>();
        l0.addAll(list);
        l0.add(2 * me);
        l0.add(-1);
        List<Integer> r1 = new ArrayList<Integer>();
        r1.addAll(list);
        r1.add(2 * me + 1);
        r1.add(1);
        List<Integer> r0 = new ArrayList<Integer>();
        r0.addAll(list);
        r0.add(2 * me + 1);
        r0.add(-1);
        return Math.min(Math.min(f(2 * me, n1 + 2 * me, n, k1 + 1, k, l1), f(2 * me, n1 - 2 * me, n, k1 + 1, k, l0)),
                Math.min(f(2 * me + 1, n1 + 2 * me + 1, n, k1 + 1, k, r1), f(2 * me + 1, n1 - 2 * me - 1, n, k1 + 1, k, r0)));
    }
}