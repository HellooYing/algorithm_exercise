import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class atest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("")) {
            list.add(line);
            if (!sc.hasNextLine()) {
                break;
            }
        }
        int height = list.size();
        int width = list.get(0).split(" ").length;
        for (int i = 0; i < list.size(); i++) {
            String l = list.get(i);
            String arr[] = l.split(" ");
            if (width < arr.length) {
                width = arr.length;
            }
        }
        int m[][] = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                m[i][j] = 0;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String l = list.get(i);
            String arr[] = l.split(" ");
            for (int j = 0; j < arr.length; j++) {
                m[i][j] = Integer.valueOf(arr[j]);
            }
        }
        int time = 0;
        do {
            boolean tap = false;
            boolean h[][] = new boolean[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    h[i][j] = false;
                }
            }
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (m[i][j] == 2 && h[i][j] == false) {
                        if (i - 1 >= 0 && m[i - 1][j] == 1) {
                            m[i - 1][j] = 2;
                            h[i - 1][j] = true;
                            tap = true;
                        }
                        if (i + 1 <= height - 1 && m[i + 1][j] == 1) {
                            m[i + 1][j] = 2;
                            h[i + 1][j] = true;
                            tap = true;
                        }
                        if (j - 1 >= 0 && m[i][j - 1] == 1) {
                            m[i][j - 1] = 2;
                            h[i][j - 1] = true;
                            tap = true;
                        }
                        if (j + 1 <= width - 1 && m[i][j + 1] == 1) {
                            m[i][j + 1] = 2;
                            h[i][j + 1] = true;
                            tap = true;
                        }
                    }
                }
            } time++;
            if (tap == false) {
                boolean b = false;
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (m[i][j] == 1) {
                            System.out.println(-1);
                            b = true;
                            break;
                        }
                    }
                    if (b == true) {
                        break;
                    }
                }
                if (b == false) {
                    System.out.println(time - 1);
                    break;
                } else {
                    break;
                }
            }
        } while (true);
        /*  输出测试 for(int i=0;i<height;i++) { for(int j=0;j<width;j++) { System.out.print(m[i][j]+" "); } System.out.println(""); } */
    }
}