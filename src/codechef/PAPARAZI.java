package codechef;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class PAPARAZI{
    public static Reader scan = new Reader();
    public static void main(String[] args) throws IOException {
        int t = scan.nextInt();
        for(int i = 0;i<t;i++) solve();
    }
    public static void solve() throws IOException {
        int n = scan.nextInt();
        if(n <=2){
            for(int i = 0;i<n;i++) scan.nextInt();
            System.out.println(1);
            return;
        }
        int[] a = new int[n];
        int[][] stack = new int[n+1][2]; //dp array
        int max = 1;
        int len = 0;
        for(int i = 0;i<n;i++){
            a[i] = scan.nextInt();
            if(i >= 2){
                while(len >= 2) {
                    int run1 = i - stack[len - 1][0];
                    int rise1 = a[i] - stack[len - 1][1];
                    double s1 = (double) rise1 / run1;
                    int run2 = stack[len - 1][0] - stack[len - 2][0];
                    int rise2 = stack[len - 1][1] - stack[len - 2][1];
                    double s2 = (double) rise2 / run2;
                    if (s1 < s2) { //reset
                        //       |
                        //    |  |
                        //    |  |
                        // |  |  |
                        break;
                    } else {
                        //       |
                        //       |
                        //    |  |
                        // |  |  |
                        len--;
                    }
                }
                stack[len][0] = i;
                stack[len][1] = a[i];
                len++;
                max = Math.max(stack[len-1][0] - stack[len-2][0], max);
            }else{
                stack[i][0] = i;
                stack[i][1] = a[i];
                len++;
            }
        }
        System.out.println(max);
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
