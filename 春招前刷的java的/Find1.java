import java.util.*;

public class Find1 {
    public static void main(String[] args) throws Exception {
        int target=1;
        int[][] array={{}};
        System.out.println(new Find1().answer(target,array));
    }

    public boolean answer(int target, int [][] array){
        int i1=0;//最左
        int i2=array[0].length-1;//最右
        int j1=0;//最上
        int j2=array.length-1;//最下
        if(i2==-1||j2==-1) return false;
        while(i1!=i2||j1!=j2){
            if(array[j1][i2]<target){
                j1++;
            }
            else if(array[j1][i2]>target){
                i2--;
            }
            else{
                return true;
            }
            if(array[j2][i1]<target){
                i1++;
            }
            else if(array[j2][i1]>target){
                j2--;
            }
            else{
                return true;
            }
        }
        if(array[i1][j1]==target) return true;
        return false;
    }

}