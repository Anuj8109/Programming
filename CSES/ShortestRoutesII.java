package CSES;
import java.io.*;
import java.util.*;

public class ShortestRoutesII {
    static final long INF = 1L << 59; // Large enough but prevents overflow
    
    public static void main(String[] args) throws IOException {
        Reader fs = new Reader();
        PrintWriter out = new PrintWriter(System.out);
        
        int n = fs.nextInt();
        int m = fs.nextInt();
        int q = fs.nextInt();
        
        // Use 1D array for better cache performance
        long[] dist = new long[n * n];
        Arrays.fill(dist, INF);
        
        // Set diagonal to 0
        for (int i = 0; i < n; i++) {
            dist[i * n + i] = 0;
        }
        
        // Read edges
        while (m-- > 0) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            long c = fs.nextInt();
            dist[a * n + b] = Math.min(dist[a * n + b], c);
            dist[b * n + a] = Math.min(dist[b * n + a], c);
        }
        
        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            int kn = k * n;
            for (int i = 0; i < n; i++) {
                int in = i * n;
                long ik = dist[in + k];
                if (ik == INF) continue;
                
                for (int j = 0; j < n; j++) {
                    long kj = dist[kn + j];
                    if (kj == INF) continue;
                    
                    dist[in + j] = Math.min(dist[in + j], ik + kj);
                }
            }
        }
        
        // Process queries
        while (q-- > 0) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            long ans = dist[a * n + b];
            out.println(ans >= INF ? -1 : ans);
        }
        
        out.close();
    }
    
    // Faster input reading
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private void skip(int x) throws IOException {
            while (x-- > 0)
                read();
        }
 
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return neg ? -ret : ret;
        }
    }
}