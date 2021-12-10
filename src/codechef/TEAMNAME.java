package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class TEAMNAME {
    public static void main(String[] args) {
        FastReader scan = new FastReader(System.in);
        int t = scan.nextInt();
        HashMap<String, HashSet<Character>> hs;
        boolean[] s = new boolean[26];
        for(int r = 0;r<t;r++){
            hs = new HashMap<>();
            int n = scan.nextInt();
            int ans = 0;
            String[] sub = new String[n];
            char[] ch = new char[n];
            int g = 0;
            for(int i = 0;i<n;i++){
                String cur = scan.next();
                sub[i] = cur.substring(1);
                ch[i] = cur.charAt(0);
                char o = ch[i];
                if(!s[o-'a']){
                    g++;
                    s[o-'a'] = true;
                }
                String end = sub[i];
                if(!hs.containsKey(end)) hs.put(end, new HashSet<>());
                hs.get(end).add(o);
            }
            for(int i = 0;i<26;i++) s[i] = false;
            if(g > 1) {
                for (int a = 0; a < n - 1; a++) {
                    String eA = sub[a];
                    char aa = ch[a];
                    for (int b = a + 1; b < n; b++) {
                        char bb = ch[b];
                        String eB = sub[b];
                        if ((aa != bb) && !hs.get(eA).contains(bb) && !hs.get(eB).contains(aa)) {
                            ans++;
                        }
                    }
                }
            }
            System.out.println(ans * 2);
        }
    }
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(InputStream in){br = new BufferedReader(new InputStreamReader(in));}
        public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}
        String next(){while(st==null||!st.hasMoreElements()){try{st=new StringTokenizer(br.readLine());
        }catch(IOException e){e.printStackTrace();}}return st.nextToken();}
        int nextInt(){return Integer.parseInt(next());}long nextLong()
        {return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}
        String nextLine(){String str = "";try{str=br.readLine();}catch(IOException e)
        {e.printStackTrace();}return str;}}
}
