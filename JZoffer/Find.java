import java.util.*;
public class Find {
    public static void main(String[] args) throws Exception {
        int[][] a={{1,9,18,30},{2,10,25,32},{13,15,36,38},{14,20,37,40}};
        System.out.println(new Find().answer(11,a));
    }

    public boolean answer(int target, int [][] array){
        //8.5min ok
        if(array.length==0||array[0].length==0) return false;
        int t=0;
        int r=array[0].length-1;
        while(!(r==0&&t==array.length-1)){
            if(r==0&&target<array[t][r]) return false;
            if(t==array.length-1&&target>array[t][r]) return false;
            if(target<array[t][r]) r--;
            else if(target==array[t][r]) return true;
            else t++;
        }
        if(array[t][r]==target) return true;
        else return false;
    }
}