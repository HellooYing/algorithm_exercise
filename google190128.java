// Thread      Lock    Acquire
//  1                1         true
//  1                1         false
//  2                1         true
// 2                 2         true
// 1                 1         true
// 2                  1        false

// ===================
// 1     1     true
// 2     2     true
// 1     2     true
// 2     1     true
import java.util.*;

public class google190128{
    public static void main(String[] args) throws Exception {
        int[] Thread = { 1, 2,1,2};
        int[] Lock = { 1,2,2,1};
        boolean[] Acquire = { true, true,true,true };
        System.out.println(new google190128().answer(Thread, Lock, Acquire));
    }

    public boolean answer(int[] Thread, int[] Lock, boolean[] Acquire) {
        List<Integer> lid = new ArrayList<Integer>();
        List<lock> l = new ArrayList<lock>();
        List<Integer> tid = new ArrayList<Integer>();
        List<thread> t = new ArrayList<thread>();
        for (int i = 0; i < Thread.length; i++) {
            thread th=new thread(0);
            lock lo=new lock(0);
            if (!tid.contains(Thread[i])) {
                tid.add(Thread[i]);
                th = new thread(Thread[i]);
                t.add(th);
            } else {
                for (int j = 0; j < tid.size(); j++) {
                    if (tid.get(j) == Thread[i]) {
                        th = t.get(j);
                        break;
                    }
                }
            }
            if (!lid.contains(Lock[i])) {
                lid.add(Lock[i]);
                lo = new lock(Lock[i]);
                l.add(lo);
            } else {
                for (int j = 0; j < lid.size(); j++) {
                    if (lid.get(j) == Lock[i]) {
                        lo = l.get(j);
                        break;
                    }
                }
            }
            if (Acquire[i] == true) {
                if (lo.ac == true)
                    th.wait = lo;
                else{
                    lo.get(th,lo);
                }
            } else {
                lo.sf(th, lo);
            }
            
            if(th.wait!=null&&th.wait.thread!=null&&th.wait.thread.wait!=null){
                lock lw = th.wait;
                thread tw = lw.thread;
                lock lw2 = tw.wait;
                if (th.on.contains(lw2)) {// 线程1请求的锁里包括线程2正等待的，且线程1等待的锁被线程2持有
                    return true;// 返回是死锁的
                }
            }
        }
        return false;
    }

    class lock {
        int id;
        boolean ac = false;
        thread thread;

        lock(int id) {
            this.id = id;
        }
        void get(thread t, lock l){
            this.thread=t;
            ac=true;
            t.on.add(l);
        }
        void sf(thread t, lock l) {
            t.on.remove(l);
            this.ac = false;
        }
    }

    class thread {
        int id;
        List<lock> on=new ArrayList<lock>();// 哪些锁被本线程请求
        lock wait;// 正在等待哪个

        thread(int id) {
            this.id = id;
        }
    }
}
