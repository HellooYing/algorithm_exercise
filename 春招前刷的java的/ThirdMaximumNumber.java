import java.util.Arrays;
public class ThirdMaximumNumber {
    public static void main(String[] args) throws Exception {
        int[] a = { 1, 2,3,4,5};
        System.out.println(new ThirdMaximumNumber().thirdMax(a));
    }

    public int thirdMax(int[] nums){
        int[] max3={Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
        int count=0;
        int wtf=0;
        for(int num:nums){
            for(int j=0;j<3;j++){
                if(j==0){
                    if(max3[0]>num) break;
                    else if(max3[0]==num){
                        if(wtf==0){
                            count++;
                            wtf=1;
                        }
                        break;
                    }
                    else continue;
                }
                else if(j==1){
                    if(max3[1]>num){
                        max3[0]=num;
                        count++;
                        break;
                    }
                    else if(max3[1]==num){
                        break;
                    }
                    else{
                        continue;
                    }
                }
                else if(j==2){
                    if(max3[2]<num){
                        max3[0]=max3[1];
                        max3[1]=max3[2];
                        max3[2]=num;
                        count++;
                    }
                    else if(max3[2]==num){
                        break;
                    }
                    else{
                        max3[0]=max3[1];
                        max3[1]=num;
                        count++;
                    }
                }
            }
        }
        return (count >= 3) ? (int) max3[0] : (int) max3[2];
    }
}
