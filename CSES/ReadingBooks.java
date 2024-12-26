package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReadingBooks {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        //int[] times = new int[n];
        long sum = 0;
        long maximum = 0; 
        for(int i=0;i<n;i++){
            int t = fs.nextInt();
            sum += t;
            maximum = Math.max(maximum, t);
        }
        System.out.println(Math.max(2*maximum, sum));
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }
}
