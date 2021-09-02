package codechef.AugustChallenge2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayFilling {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int m = scan.nextInt();
            ArrayList<pair> list = new ArrayList<>();
            for(int i = 0;i<m;i++) list.add(new pair(scan.nextInt(), scan.nextInt()));
            Collections.sort(list);
            System.out.println(list);
            
        }


        //6 3
        //3 2
        //2 2
        //1 3
        //_ _ _ _ _ _
        //1 1   1 1
        //2   2   2
        //3   3   3
        //3 1 3 1 3 0

    }
    public static class pair implements Comparable<pair>{
        int a;
        int b;
        public pair(int a, int b){
            this.a = a;
            this.b=b;
        }
        @Override
        public int compareTo(pair o) {
            return this.a-o.a;
        }

        @Override
        public String toString() {
            return "pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    public static int lcm(int a, int b){
        return (a/gcd(a, b)) * b;
    }
}
