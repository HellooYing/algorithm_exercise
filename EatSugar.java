import java.util.*;

public class EatSugar {
	public static void main(String[] args) throws Exception {
		int[][] sugar = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 } };
		System.out.println(new EatSugar().answer(sugar));
	}

	public int answer(int[][] sugar) {
		int m = sugar.length;
		if (m == 0)
			return 0;
		int n = sugar[0].length;
		if (n == 0)
			return 0;
		// m行n列
		int kh=0;
		for(int i=0;i<m;i++){
			if(kh(sugar[i])) kh++;
			else break;
		}
		
		int[] l = new int[m-kh];// 存最左糖果
		int[] r = new int[m-kh];// 存最右糖果
		int[] el = new int[m-kh];// 存该行从左糖果下去的结束步骤
		int[] er = new int[m-kh];// 存该行从右糖果下去的结束步骤
		boolean flag;
		
		for (int i = 0; i < m-kh; i++) {
			flag = false;
			for (int j = 0; j < n; j++) {
				if (sugar[i][j] == 1) {
					l[i] = j;
					flag = true;
					break;
				}
			}
			if (flag == false)
				l[i] = -1;// 该行没有糖果
			for (int j = n - 1; j >= 0; j--) {
				if (sugar[i][j] == 1) {
					r[i] = j;
					break;
				}
			}
		} // 存完了每行的左右糖果
		el[0] = Math.abs(r[0] - l[0]);
		er[0] = 2 * el[0];
		for (int i = 1; i < m-kh; i++) {
			if (l[i] == -1) {
				l[i] = l[i - 1];
				r[i] = r[i - 1];
				el[i] = el[i - 1] + 1;
				er[i] = er[i - 1] + 1;
			} else {
				el[i] = getel(el, er, l, r, i);
				er[i] = geter(el, er, l, r, i);
			}
		}
		System.out.println(Arrays.toString(el)+" "+Arrays.toString(er));
		System.out.println(Arrays.toString(l)+" "+Arrays.toString(r));
		if (el[m - kh-1] > er[m - kh-1])
			return er[m - kh-1]+kh;
		else
			return el[m -kh- 1]+kh;
	}

	int getel(int[] el, int[] er, int[] l, int[] r, int i) {
		int p0 = el[i - 1];// 代表上一行从左吃到右
		int p1 = Math.abs(r[i - 1] - l[i]);// 从上一行的结尾走到本行的最左糖
		int p2 = 1;// 下去
		int p3 = Math.abs(r[i] - l[i]);// 吃完糖
		int r1 = p0 + p1 + p2 + p3;
		int p4 = er[i - 1];
		int p5 = Math.abs(l[i - 1] - l[i]);
		int p6 = 1;
		int p7 = p3;
		int r2 = p4 + p5 + p6 + p7;
		if (r1 > r2)
			return r2;
		else
			return r1;
	}

	int geter(int[] el, int[] er, int[] l, int[] r, int i) {
		int p0 = el[i - 1];// 代表上一行从左吃到右
		int p1 = Math.abs(r[i - 1] - r[i]);// 从上一行的结尾走到本行的最右糖
		int p2 = 1;// 下去
		int p3 = Math.abs(r[i] - l[i]);// 吃完糖
		int r1 = p0 + p1 + p2 + p3;
		int p4 = er[i - 1];
		int p5 = Math.abs(l[i - 1] - r[i]);
		int p6 = 1;
		int p7 = p3;
		int r2 = p4 + p5 + p6 + p7;
		if (r1 > r2)
			return r2;
		else
			return r1;
	}
	boolean kh(int[] a){
		for(int i=0;i<a.length;i++){
			if(a[i]!=0) return false;
		}
		return true;
	}
}
