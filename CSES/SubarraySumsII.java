package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SubarraySumsII {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int x = fs.nextInt();
        int[] elements = new int[n];
        
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        } 

        long sum = 0;
        HashMap<Long,Integer> s = new HashMap<>();
        s.put(0l, 1);
        long result = 0;
        for(int i=0;i<n;i++){
            sum += elements[i];
            result += s.getOrDefault(sum - x, 0);
            s.put(sum, s.getOrDefault(sum, 0) + 1);
        }
        System.out.println(result);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
