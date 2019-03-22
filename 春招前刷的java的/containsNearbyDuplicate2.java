import java.util.Arrays;

public class containsNearbyDuplicate2 {
    public static void main(String[] args) throws Exception {
        int[] a = { 1,1,1,1,1,1};
        System.out.println(new containsNearbyDuplicate2().containsNearbyDuplicate(a));
    }

    public int containsNearbyDuplicate(int[] a) {
        if(a.length==1) return 0;
        int i, j, k;
        for (i = 0; i < a.length-1; i++) {
            if (a[i] > a[i + 1])
                break;
        }
        for (j = a.length - 1; j > 0; j--) {
            if (a[j - 1] > a[j])
                break;
        }
        int max = a[j];
        int min = a[j];
        for (k = i; k < j; k++) {
            if (max < a[k])
                max = a[k];
            if (min > a[k])
                min = a[k];
        }
        for (i = i - 1; i >= 0; i--) {
            if (a[i] <= min)
                break;
        }
        for (j = j + 1; j < a.length; j++) {
            if (a[j] >= max)
                break;
        }
        //System.out.println(i);
        //System.out.println(j);
        int answer=j - i - 1;
        if(answer<0) return 0;
        else return answer;
    }
}