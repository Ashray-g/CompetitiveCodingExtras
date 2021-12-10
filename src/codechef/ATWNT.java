package codechef;

import java.util.*;

public class ATWNT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] ad = new int[n];
        List<Integer>[] adList = new List[n+2];
        for(int i = 0;i<n+2;i++) adList[i] = new ArrayList<>();
        for(int i = 1;i<n;i++){
            adList[scan.nextInt()-1].add(i);
        }
        int q = scan.nextInt();
        for(int i = 0;i<q;i++){
            int s = scan.nextInt() - 1;
            int b = scan.nextInt();
            System.out.println(bfs(adList, n, s, b));
        }
    }
    public static int bfs(List<Integer>[] adList, int n, int s, int b){
        int[] tasks = new int[n+10];
        tasks[s] = b;
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int done = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(adList[cur].size() == 0){
                done += tasks[cur];
            }else if(tasks[cur] % adList[cur].size() == 0){
                for(int ad : adList[cur]){
                    tasks[ad] = tasks[cur]/adList[cur].size();
                    q.add(ad);
                }
            }
        }
        return b-done;
    }
}
