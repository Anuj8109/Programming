package CSES;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaximumSubarraySum {
    
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        Integer[] elements = new Integer[n];
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        }

        long ans = Integer.MIN_VALUE;
        long curr = Integer.MIN_VALUE;
        for(int ele:elements){
            curr = Math.max(curr + ele, ele);
            ans = Math.max(ans, curr);
        }
        System.out.println(ans);
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }
}
