/**
 * @author zhaole.myy
 * @date 2019/9/14
 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb){
        if(lena!=lenb) {
            return false;
        }
        A=A+A;
        if(A.contains(B)){
            return true;
        }
        else{
            return false;
        }
    }
}
