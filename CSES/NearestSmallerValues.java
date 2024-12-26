package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NearestSmallerValues {
    
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        //int[] array = new int[n];
        Stack<int[]> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int temp = fs.nextInt();
            while (!s.isEmpty() && s.peek()[0] >= temp) {
                s.pop();
            }
            sb.append(" " + (s.empty() ? 0 : s.peek()[1]));
            s.add(new int[]{temp, i + 1});
        }
        System.out.println(sb.toString().substring(1));
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
