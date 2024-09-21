package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.*;;

public class MinimizingCoins {
    static class FastReader { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader( 
                new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) { 
                try { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() { return Integer.parseInt(next()); } 
  
        long nextLong() { return Long.parseLong(next()); } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try { 
                if(st.hasMoreTokens()){ 
                    str = st.nextToken("\n"); 
                } 
                else{ 
                    str = br.readLine(); 
                } 
            } 
            catch (IOException e) { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int numCoin = fastReader.nextInt();
        int x = fastReader.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0;i<numCoin;i++) coins.add(fastReader.nextInt());
        Collections.sort(coins);
        int[] dp = new int[x + 1];
        Arrays.fill(dp, 1_000_000 + 1);
        dp[0] = 0;
        for(int i=1;i<=x;i++){
            for(int coin:coins){
                if(i - coin >= 0 && dp[i] > 1 + dp[i-coin]) dp[i] = 1 + dp[i - coin];
            }
           // System.out.println(i + " " + dp[i]);
        }
        System.out.println(dp[x] == 1_000_000 + 1 ? -1 : dp[x]);
    }
}
