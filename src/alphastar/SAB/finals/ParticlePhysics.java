package alphastar.SAB.finals;

import java.util.Arrays;
import java.util.Scanner;

public class ParticlePhysics {
    public static int[] x, y, onRight;
    public static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        x = new int[n];
        y = new int[n];
        for(int i = 0;i<n;i++){
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        onRight = new int[n];
        Arrays.fill(onRight, -1);
        for(int a =0;a<n;a++){
            for(int b = 0;b<n;b++){
                if(x[b] > x[a]  && y[b] == y[a]){
                    if(onRight[a] != -1){
                        if(x[b] - x[a] < x[onRight[a]] - x[a]){
                            onRight[a] = b;
                        }
                    }else{
                        onRight[a] = b;
                    }
                }
            }
        }
        connected = new int[n];
        Arrays.fill(connected, -1);
        System.out.println(rec());
    }
    public static int[] connected;
    public static int rec(){
        //backtracking recursion
        int ans = 0;
//
//        int g = -1;
//        for(int i = 0;i<n;i++){
//            if(connected[i] == -1) //not connected
//            {
//                //make pairs
//                for(int j = i+1;j<n;j++){
//                    connected[i] = j;
//                    connected[j] = i;
//                    ans += rec();
//                    connected[i] = -1;
//                    connected[j] = -1;
//                }
//                //end make pairs
//                g = 0;
//                break;
//            }
//        }
//        if(g == -1){ //paired
//            if(cycle()) return 1;
//            else return 0;
//        }

        int first = -1;
        for(int i = 0;i<n;i++){
            if(connected[i] == -1) {
                first = i;
                break;
            }
        }

        if(first == -1 && cycle()){
            System.out.println(Arrays.toString(connected));
            return 1;
        }
        else if(first == -1) return 0;

        for(int i = 0;i<n;i++){
            if(connected[i] == -1) //not connected
            {
                //make pairs
                for(int j = i+1;j<n;j++){
                    if(connected[j] == -1) {
                        connected[i] = j;
                        connected[j] = i;
                        ans += rec();
                        connected[i] = -1;
                        connected[j] = -1;
                    }
                }
                //end make pairs
                break;
            }
        }

        return ans;
    }
    public static boolean cycle(){
        for(int s = 0;s<n;s++){
            boolean[] vis = new boolean[n];
            int cur = s;
            vis[cur] = true;
            for(int i = 0;i<n*2;i++){
                int next = onRight[connected[cur]];
                if(next != -1) {
                    if (vis[next]) {
                        return true;
                    } else {
                        vis[next] = true;
                        cur = next;
                    }
                }else{
                    break;
                }
            }

        }
        return false;
    }
}
