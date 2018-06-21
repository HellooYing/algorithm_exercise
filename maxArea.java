import java.lang.Math;
public class maxArea {
    public static void main(String[] args) throws Exception {
        int[] x = { 1,3,5,4,2 };
        System.out.println(new maxArea().answer(x));
    }

    public int answer(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=0;
        int h;
        while(i!=j){
            h=Math.min(height[i],height[j]);
            max=Math.max(max,h*(j-i));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return max;
        }
    }