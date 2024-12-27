package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RectangleCutting {
    
    public static int minimumCut(int w,int h, Integer[][] dp){
        if(w == h){
            return 0;
        }
        if(w > h){
            int temp = w;
            w = h;
            h = temp;
        }
        if(w == 1) return h - 1;
        if(dp[w][h] != null) return dp[w][h];
        //System.out.println(w + " " + h);
        int cost = Integer.MAX_VALUE;
        for(int i=1;i<=w;i++){
            int c1 = minimumCut(w, h - i, dp);
            int c2 = minimumCut(w, i, dp);
            //System.out.println(c1 + " " + c2);
            cost = Math.min(cost, c1 + c2);
        }

        for(int i=1;i<w;i++){
            int c1 = minimumCut(i, h, dp);
            int c2 = minimumCut(w - i, h, dp);
            cost = Math.min(cost, c1 + c2);
        }
        return dp[w][h] = cost + 1;

    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int w = fs.nextInt();
        int h = fs.nextInt();
        if(w > h){
            int temp = w;
            w = h;
            h = temp;
        }
        Integer[][] dp = new Integer[w + 1][h + 1];
        System.out.println(minimumCut(w, h, dp));
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
