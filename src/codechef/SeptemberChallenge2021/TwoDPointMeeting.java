//package codechef.SeptemberChallenge2021;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class TwoDPointMeeting {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long t = scan.nextInt();
//        while(t-->0){
//            int n = scan.nextInt();
//            long[] x = new long[n];
//            long[] y = new long[n];
//
//            for(int i = 0;i<n;i++){
//                x[i] = scan.nextInt();
//            }
//            for(int i = 0;i<n;i++) y[i] = scan.nextInt();
//
//            long min = Long.MAX_VALUE;
//
//            for(int i = 0;i<n;i++){
//                long d = dist(x, y, i);
//                min = Math.min(min, d);
//            }
//            System.out.println(min);
//
//        }
//    }
//
//    public static long dist(long[] x, long[] y, int i){
//        long x1 = x[i];
//        long y1 = y[i];
//
//        int n = x.length;
//
//        long tot = 0;
//
//        for(int j = 0;j<n;j++) {
//            if(j != i){
//                long h = steps(x[j], y[j], x1, y1);
//                tot += h;
//            }
//        }
//
//        return tot;
//    }
//
//    public static long steps(long x, long y, long x1, long y1){
//        if(Math.abs(y - y1) == Math.abs(x - x1)){ // diagonal
//            return 1;
//        }else if(y - y1 == 0 || x - x1 == 0){ // horizontal/vertical
//            return 1;
//        }else{
//            return 2;
//        }
//    }
//}
