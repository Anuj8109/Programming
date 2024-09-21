package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CoinCombinationsII {
    public static void main(String[] args){
        final int mod = 1_000_000_000 + 7;
        FastReader fastReader = new FastReader();
        int n  = fastReader.nextInt();
        int x = fastReader.nextInt();
        List<Integer> coins = new ArrayList<>();
        for(int i=0;i<n;i++){
            coins.add(fastReader.nextInt());
        }
        int[] dp = new int[x + 1];
        Collections.sort(coins);
        dp[0] = 1;
        for(int coin:coins){
            for(int j=coin;j<=x;j++){
                dp[j] = (dp[j] + dp[j - coin]) % mod;
            }
        }
        System.out.println(dp[x]);
    }
    
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
}
