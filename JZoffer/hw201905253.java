import java.util.*;

public class hw201905253 {
    //多处理器sjf（最短作业优先）调度，求处理完作业的时间
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();//处理器数量
        int m=in.nextInt();
        int[] workTime=new int[m];
        for (int i = 0; i < m; i++) {
            workTime[i]=in.nextInt();
        }
        new hw201905253().answer(n,workTime);
    }
    public void answer(int n,int[] workTime){
        Arrays.sort(workTime);
        int[] time=new int[n];
        for (int i = 0; i < workTime.length; i++) {
            time[getMin(time)]+=workTime[i];
        }
        System.out.println(time[getMax(time)]);
    }
    int getMax(int[] time){
        int r=0;
        for (int i = 1; i <time.length ; i++) {
            if(time[i]>time[r]) r=i;
        }
        return r;
    }
    int getMin(int[] time){
        int r=0;
        for (int i = 1; i <time.length ; i++) {
            if(time[i]<time[r]) r=i;
        }
        return r;
    }
}
