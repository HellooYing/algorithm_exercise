import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) throws Exception {
        int[] a = { 3,2,4 };
        int target=4;
        int[] result=new twoSum().twoSum1(a,target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] twoSum1(int[] a, int target) {
        int start = 0;
        int end = a.length-1;
        int i=0,j=0;
        int[] b=a;
        int answer1=-1,answer2=-1;
        int[] answer={0,1};
        sort(a,start,end);
        for(i=0;i<end;i++){
            for(j=i;j<end;j++){
                if(a[i]+a[j]==target) break;
                else if(a[i]+a[j]<target) continue;
                else break;
            }
            if(a[i]+a[j]==target&&i!=j) break;
        }
        
        for(int k=0;k<=end;k++){
            if(b[k]==a[i]) {answer1=k;continue;}
            if(b[k]==a[j]) {answer2=k;}
        }
        if(answer2==-1){
            for(int k=0;k<=end;k++){
                if(b[k]==a[j]&&k!=answer1) {answer2=k;}
            }
        }
        if(answer1<answer2) {
            answer[0]=answer1;
            answer[1]=answer2;
        }
        else {
            answer[1]=answer1;
            answer[0]=answer2;
        }
        return answer;
    }

    public void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        int key = a[low];
        while(end>start){
            while(end>start&&a[end]>=key)
                end--;
            if(a[end]<=key){
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            while(end>start&&a[start]<=key)
               start++;
            if(a[start]>=key){
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
        }
        if(start>low) sort(a,low,start-1);
        if(end<high) sort(a,end+1,high);
    }
}
