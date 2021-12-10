package codechef;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DENSEGRP {
    public static Reader scan = new Reader();
    public static void main(String[] args) throws IOException {
        int t = scan.nextInt();
        for(int i = 0;i<t;i++) solve();
    }
    public static void solve() throws IOException {
        int n = scan.nextInt(), m = scan.nextInt(), x = scan.nextInt(), y = scan.nextInt();
        int[][] abcd = new int[m][4];
        for(int i = 0;i<m;i++){
            abcd[i][0] = scan.nextInt();
            abcd[i][1] = scan.nextInt();
            abcd[i][2] = scan.nextInt();
            abcd[i][3] = scan.nextInt();
        }
        if(x == y){
            System.out.println(0);
            return;
        }
        boolean[] rangeChecked = new boolean[m];
        int ans = -1;
        int[] a1 = new int[m];
        int[] a2 = new int[m];
        int ap = 0;
        a1[ap] = x;
        a2[ap] = x;
        ap++;
        int d = 0;
        while(ans == -1 && ap > 0){
            int[] a11 = new int[m];
            int[] a22 = new int[m];
            int a1p = 0;
            for(int i = 0;i<m;i++){
                if(!rangeChecked[i]){
                    for(int j =0;j< ap;j++){
                        if(abcd[i][0]<=a2[j] && abcd[i][1] >= a1[j]){
                            a11[a1p] = abcd[i][2];
                            a22[a1p] = abcd[i][3];
                            a1p++;
                            if(abcd[i][2] <= y && abcd[i][3] >= y){
                                ans = d+1;
                                break;
                            }
                            rangeChecked[i] = true;
                            break;
                        }
                    }
                }
            }
            a1 = a11;
            a2 = a22;
            ap = a1p;
            d++;
        }
        System.out.println(ans);
    }
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
