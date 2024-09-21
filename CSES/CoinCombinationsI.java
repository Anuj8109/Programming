package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;

public class CoinCombinationsI {
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
    
    static final int mod = 1_000_000_000 + 7;

    public static void main(String[] args){
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
        for(int i=1;i<=x;i++){
            for(int coin:coins){
                if(i - coin>=0) dp[i] = (dp[i] + dp[i - coin]) %mod;
                else break;
            }
            //System.out.println(i + " " +dp[i]);
        }
        // for(int i=1;i<=n;i++){
        //     for(int j=1;j<=6;j++){
        //         if(i - j >= 0) dp[i] = (dp[i] + dp[i - j]) % mod;
        //         else break;
        //         //System.out.println(dp[i] + " " + i);
        //     }
        // }
        System.out.println(dp[x]);
    }
}
