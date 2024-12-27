package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GridPaths {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        char[][] grid = new char[n][n];
        for(int i=0;i<n;i++){
            String s = fs.next();
            for(int j=0;j<s.length();j++){
                grid[i][j] = s.charAt(j);
            }
        }
        if(grid[0][0] == '*'){
            System.out.println(0);
            return;
        }
        long[][] dp = new long[n][n];
        int mod = 1_000_000_000 + 7;
        dp[0][0] = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '*') continue;
                if(i > 0) dp[i][j] += dp[i - 1][j];
                if(j > 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] = dp[i][j] % mod;
                // dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
