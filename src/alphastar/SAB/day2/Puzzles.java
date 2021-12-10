//package alphastar.SAB.day2;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Puzzles {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[][] arr = new int[n][n];
//        ArrayList<Point> kLoc = new ArrayList<>();
//
//        //2 = o
//        //1 = K
//        //0 = empty (_ or +)
//
//        for(int i = 0;i<n;i++){
//            String l = scan.next();
//            for(int j = 0;j<n * 2;j+=2){
//                char cur = l.charAt(j);
//                int a = 0;
//                if(cur == 'K'){
//                    kLoc.add(new Point(j/2, i));
//                    a = 1;
//                }else if(cur == 'o') a = 2;
//
//                arr[i][j/2] = a;
//            }
//        }
//
//
//        for(int i = 0;i<kLoc.size();i++){
//
//        }
//    }
//    public static ArrayList<Point> dfsUtil(Point start, int[][] arr){
//
//        int[] dx = {1, 1, -1, -1};
//        int[] dy = {1, -1, 1, -1};
//
//        int n = arr.length;
//        Point[][] parent = new Point[n][n];
//        int[][] dist = new int[n][n];
//        for(int[] h : dist){
//            Arrays.fill(h, Integer.MAX_VALUE);
//        }
//        dist[start.y][start.x] = 0;
//
//        Stack<Point> st = new Stack<>();
//        st.push(start);
//
//        while(!st.isEmpty()){
//            Point cur  =  st.pop();
//            for(int i = 0;i<4;i++){
//                int x = cur.x + dx[i];
//                int y = cur.y + dy[i];
//                if(x >=  0 && y >= 0 && x < n && y < n && arr[y][x]==2 && arr[y+dy[i]][x+dx[i]]==0){
//
//                }
//            }
//        }
//
//    }
//}
