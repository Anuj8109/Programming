package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RemovingDigits {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        if(n >= 1 && n <= 9){
            System.out.println(1);
            return;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        Arrays.fill(dp, n + 1);
        for(int i=1;i<=9;i++) dp[i] = 1;
        
        for(int num=10;num<=n;num++){
            int temp = num;
            while (temp > 0) {
                int x = temp % 10;
                dp[num] = Math.min(dp[num], dp[num - x] + 1);
                temp = temp / 10;
            }
        }
        System.out.println(dp[n]);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
