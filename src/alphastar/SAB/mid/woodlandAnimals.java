package alphastar.SAB.mid;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class woodlandAnimals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(0, n-1));
        while(!q.isEmpty()){
            pair cur = q.poll();
            if((cur.e - cur.s > 1)){
                int mid = (cur.e+cur.s)/2;
                int mid2 = mid+1;
                pair a = new pair(cur.s, mid);
                pair b = new pair(mid2, cur.e);
                q.add(a);
                q.add(b);
            }else{
                if(cur.e != cur.s){
                    sum += (long)(cur.e+1) * (cur.s + 1);
                }
            }
        }
        System.out.println(sum);
    }
    public static class pair{
        int s, e;
        public pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "pair{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }
}
