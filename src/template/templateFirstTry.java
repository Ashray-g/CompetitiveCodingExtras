package template;

import java.io.*;
import java.util.*;

public class templateFirstTry {

    public static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    public static FastReader scan = new FastReader(System.in);

    public static int oo = Integer.MAX_VALUE/3;
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(new File(".in"));
        PrintWriter out = new PrintWriter(new FileWriter(".out"));
        int n = 5;
        int m = 8;
        List<edge>[] adList = new List[n];
        PrintWriter writer = new PrintWriter(System.out);
        for(int i = 0;i<n;i++) adList[i] = new ArrayList<>();
        for(int i = 0 ;i<m;i++){
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            int d = scan.nextInt();
            adList[a].add(new edge(b, d));
            adList[b].add(new edge(a, d));
        }
        primTree(adList, n);

    }


    public static void bfs(int s, List<Integer>[] adList, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int[] dist = new int[n];
        Arrays.fill(dist, oo);
        dist[s] = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int ad : adList[cur]){
                if(dist[ad] == oo){
                    dist[ad] = dist[cur] + 1;
                    q.add(ad);
                }
            }
        }
    }
    public static int dfs(int s, List<Integer>[] adList, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(s);
        int[] dist = new int[n];
        Arrays.fill(dist, oo);
        dist[s] = 0;
        while(!st.isEmpty()){
            int cur = st.pop();
            for(int ad : adList[cur]){
                if(dist[ad] == oo){
                    dist[ad] = dist[cur] + 1;
                    st.push(ad);
                }
            }
        }
        int ans= 0;
        for(int i : dist){ if(i != oo) ans++; }
        return ans;
    }
    public static void dij(int s, List<edge>[] adList, int n){
        PriorityQueue<edge> pq = new PriorityQueue<>();
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[s] = 0;
        pq.add(new edge(s, 0));
        while(!pq.isEmpty()){
            edge cur = pq.poll();
            int node = cur.node;
            int len = cur.len;

            for(edge ad : adList[node]){
                int d = len + ad.len; //running total (max, +, min)
                if(d < minDist[ad.node]){
                    minDist[ad.node] = d;
                    pq.add(new edge(ad.node, d));
                }
            }
        }
    }
    public static void bin(int n, int[] arr,  int f){
        int low = 1, high = n;
        while(low <= high){
            int mid = arr[(low + high)/2];
            if(mid > f /*mid works*/){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
    }
    public static void floyd(List<edge>[] adList, int n){
        int[][] dist = new int[n][n];
        for(int i = 0;i<n;i++){
            for(int j= 0;j<n;j++){
                dist[i][j] = oo;
                if(i == j) dist[i][j] = 0;
            }
        }
        for(int i = 0;i<n;i++){
            for(edge d : adList[i]){
                dist[i][d.node] = d.len;
            }
        }
        for(int k = 0;k<n;k++){
            for(int i = 0;i<n;i++){
                for(int j = 0;j<n;j++){
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j= 0;j<n;j++){
                System.out.print(dist[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void primTree(List<edge>[] adList, int n){
        PriorityQueue<edge> q = new PriorityQueue<>();
        edge node = new edge(0,0);
        boolean[] pool = new boolean[n];
        q.add(node);
        pool[0] = true;
        int tot = 0;
        while (!q.isEmpty())
        {
            edge nod = q.remove();
            tot += nod.len;
            for (edge x: adList[nod.node])
            {
                if (!pool[x.node]) {
                    q.add(x);
                    pool[x.node] = true;
                    break;
                }
            }
        }
        System.out.println(tot);
    }

    public static class edge implements Comparable<edge>{
        int node, len;
        public edge(int node, int len) {
            this.node = node;
            this.len = len;
        }


        @Override
        public int compareTo(edge o) {
            return this.len - o.len;
        }

//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof edge)) return false;
//            edge edge = (edge) o;
//            return node == edge.node &&
//                    len == edge.len;
//        }
//        @Override
//        public int hashCode() {
//            return 0;
//        }
    }
    public static class point implements Comparable<point>{
        int x, y;
        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(point o) {
            return this.y - o.y;
//            return this.x - o.x;
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

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
