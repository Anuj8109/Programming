package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoSetsII {

    public static void main(String[] args){
        int n = new FastReader().nextInt();
        int totalSum = (n * (n + 1))/2;
        if((totalSum & 1) > 0){
            System.out.println(0);
            return;
        }
        int mod = 1_000_000_000 + 7;
        int half = totalSum/2;
        long[] dp = new long[half + 1];
        dp[0] = 1;
        for(int i=2;i<=n;i++){
            //System.out.println(i);
            long[] newDp = dp.clone();
            for(int j=i;j<=half;j++){
                newDp[j] = (newDp[j] + dp[j - i]) % mod;
            }
            dp = newDp;
        }
        // for(int i=1;i<=half;i++){
        //     System.out.print(dp[i] + " ");
        // }
        System.out.println((dp[half]));
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}