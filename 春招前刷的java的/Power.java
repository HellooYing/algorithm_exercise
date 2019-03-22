import java.util.*;

public class Power {
    public static void main(String[] args) throws Exception {
        System.out.println(new Power().answer(2,-3));
    }

    public double answer(double base, int exponent){
        double r=1;
        if(exponent>=0) {for(int i=0;i<exponent;i++) r=r*base;}
        else {for(int i=0;i<0-exponent;i++) r=r/base;}
        return r;
    }
}