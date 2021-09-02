//package facebookHackerCup.qual2021.C1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class C1 {
    public static void main(String[] args) throws IOException {
        File g = new File("src/facebookHackerCup/qual2021/C1/text.txt");
        Scanner scan  = new Scanner(g);

        String format = "Case #%s: %s";

        int t  = scan.nextInt();

        File file = new File("src/facebookHackerCup/qual2021/C1/output.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);

        int counter = 0;
        while(t-->0) {
            counter++;


            //read

            int n = scan.nextInt();
            int[] values = new int[n];
            for(int i = 0;i<n;i++) values[i] = scan.nextInt();

            ArrayList<Integer>[] adList  = new ArrayList[n];
            for(int i = 0;i<n;i++) adList[i] = new ArrayList<Integer>();

            for(int i = 0;i<n-1;i++){
                int a = scan.nextInt()-1, b = scan.nextInt()-1;
                adList[a].add(b);
                adList[b].add(a);
            }

            //end read

            String answer = "" + solve(values, n, adList);
            System.out.println(String.format(format, counter, answer));
            writer.write(String.format(format, counter, answer) + "\n");
        }
        writer.close();
    }

    public static long solve(int[] values, int n, ArrayList<Integer>[] adList){
        if (n==1) return values[0];
        ArrayList<Long> all = new ArrayList<>();
        for(int ad : adList[0]){
            all.add(maxLeafBFS(values, adList, ad, n));
        }
        Collections.sort(all);
        if(all.size() > 1) return all.get(all.size()-1) + all.get(all.size()- 2) - values[0];
        else return all.get(0);
    }

    public static long maxLeafBFS(int[] values, ArrayList<Integer>[] adList, int start, int n){
        long[] distVal = new long[n];
        Arrays.fill(distVal, -1);
        distVal[0] = values[0];
        distVal[start] = distVal[0] + values[start];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        long max = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            if(adList[cur].size()==1){
                max = Math.max(max, distVal[cur]);
            }
            else{
                ArrayList<Integer> ads = adList[cur];
                for(int ad : ads){
                    if(distVal[ad] == -1){
                        distVal[ad] = distVal[cur] + (long)values[ad];
                        q.add(ad);
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(distVal));
        return max;
    }
}
