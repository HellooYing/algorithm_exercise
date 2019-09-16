import java.util.Scanner;

public class yfd2019091601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m=sc.nextInt();
        int[][] monkey=new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                monkey[i][j]=sc.nextInt();
            }
        }
        sc.close();
        answer(monkey);
    }
    public static void answer(int[][] monkey){
        if(monkey.length==0){
            return;
        }
        // 从i=0，j=0开始
        // 向下走，i++，走到i=monkey.length-1-down为止，down+1
        // 向右走，j++，走到j=monkey[0].length-1-right为止，right+1,
        // 向上走，i--，走到i=up为止，up+1
        // 向左走，j--，走到j=left为止，left+1
        // 走了m*n个数结束
        int num=0;
        int i=0,j=0;
        int down=0,right=0,left=0,up=0;
        while (num<monkey.length*monkey[0].length){
            while (i<monkey.length-1-down&&num<monkey.length*monkey[0].length){
                System.out.print(monkey[i][j]+" ");
                num++;
                i++;
            }
            down++;

            while (j<monkey[0].length-1-right&&num<monkey.length*monkey[0].length){
                System.out.print(monkey[i][j]+" ");
                num++;
                j++;
            }

            right++;
            while (i>up&&num<monkey.length*monkey[0].length){
                System.out.print(monkey[i][j]+" ");
                num++;
                i--;
            }
            up++;
            while (j>left&&num<monkey.length*monkey[0].length){
                System.out.print(monkey[i][j]+" ");
                num++;
                j--;
            }
            left++;
        }
    }
}
