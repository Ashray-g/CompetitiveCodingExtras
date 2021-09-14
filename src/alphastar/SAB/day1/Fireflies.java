package alphastar.SAB.day1;

import java.util.*;

public class Fireflies {
    static TreeSet<String> poss = new TreeSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = Math.min(scan.nextInt(), 4);
        ArrayList<Integer> ons = new ArrayList<>();
        ArrayList<Integer> offs = new ArrayList<>();
        for(int i = 0;i<n;i++){
            int cur = scan.nextInt() - 1;
            if(cur != -2) ons.add(cur);
            else break;
        }
        for(int i = 0;i<n;i++){
            int cur = scan.nextInt() - 1;
            if(cur != -2) offs.add(cur);
            else break;
        }


        boolean[] ffs = new boolean[n];
        Arrays.fill(ffs, true);

        //dfs
        rec(ffs, 0, c, ons, offs);
        for(String u : poss) System.out.println(u);
        if(poss.size() == 0) System.out.println("IMPOSSIBLE");

    }
    public static void rec(boolean[] arr, int ops, int c, ArrayList<Integer> ons, ArrayList<Integer> offs){
        if(ops == c){
            for(int i: ons){
                if(!arr[i]) return;
            }
            for(int i: offs){
                if(arr[i]) return;
            }
            String ne = "";
            for(boolean i : arr){
                ne += i?1:0 + "";
            }
            poss.add(ne);
            return;
        }
        //1
        boolean[] newArr = Arrays.copyOf(arr, arr.length);
        for(int i = 0;i< arr.length;i++) newArr[i] = !newArr[i];
        rec(newArr, ops+1, c, ons, offs);

        //2
        newArr = Arrays.copyOf(arr, arr.length);
        for(int i = 0;i<arr.length;i+=2) newArr[i] = !newArr[i];
        rec(newArr, ops+1, c, ons, offs);
        //3
        newArr = Arrays.copyOf(arr, arr.length);
        for(int i = 1;i<arr.length;i+=2) newArr[i] = !newArr[i];
        rec(newArr, ops+1, c, ons, offs);
        //4
        newArr = Arrays.copyOf(arr, arr.length);
        for(int i = 0;i<arr.length;i+=3) newArr[i] = !newArr[i];
        rec(newArr, ops+1, c, ons, offs);
    }
}
