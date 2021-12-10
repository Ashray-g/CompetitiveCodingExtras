package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PRIGAME {
    public static int[] preFix;
    public static void main(String[] args) {
        FastReader scan = new FastReader();
        int t = scan.nextInt();
        sieve(1_000_005);
        for(int i = 0;i<t;i++) System.out.println((preFix[scan.nextInt()] <= scan.nextInt()) ? "Chef" : "Divyam");
    }
    public static void sieve(int n) {
        boolean[] prime = new boolean[n+5];
        for(int i=0;i<n;i++) prime[i] = true;
        for(int p = 2; p*p <=n; p++) {
            for(int i = p*p; i <= (n * (prime[p] ? 1 : 0)); i += p) prime[i] = false;
        }
        preFix = new int[n+5];
        for(int i = 2; i <= n; i++) preFix[i] = preFix[i-1] + (prime[i] ? 1 : 0);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
    }
}
