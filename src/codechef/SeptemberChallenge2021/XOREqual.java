package codechef.SeptemberChallenge2021;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class XOREqual {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt(), x = scan.nextInt();
            long[] a1 = new long[n], a2 = new long[n];
            HashMap<Long, Long> reps = new HashMap<>();
            HashMap<Long, Long> dist = new HashMap<>();
            for(int i = 0;i<n;i++){
                a1[i] = scan.nextInt();
                a2[i] = a1[i] ^ x;

                if(reps.containsKey(a1[i])){
                    reps.put(a1[i], reps.get(a1[i])+1);
                }else{
                    reps.put(a1[i], 1L);
                }

                if(a2[i] != a1[i]){
                    if(reps.containsKey(a2[i])){
                        reps.put(a2[i], reps.get(a2[i])+1);
                    }else{
                        reps.put(a2[i], 1L);
                    }

                }


                if(!dist.containsKey(a1[i])){
                    dist.put(a1[i], 0L);
                }

                if(a1[i] != a2[i]){
                    if(!dist.containsKey(a2[i])){
                        dist.put(a2[i], 1L);
                    }else{
                        dist.put(a2[i], dist.get(a2[i]) + 1);
                    }
                }
            }

            Set<Long> kes =  reps.keySet();
            long max = 0;
            long h = 0;
            for(long i : kes){
                long re = reps.get(i);
                long di = dist.get(i);
                if(re > max){
                    max = re;
                    h = di;
                }else if(re == max){
                    if(di < h){
                        max  = re;
                        h = di;
                    }
                }
            }
            System.out.println(max + " " + h);

        }
    }
}
