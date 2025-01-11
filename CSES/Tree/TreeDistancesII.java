package CSES.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeDistancesII {
    static List<List<Integer>> arrays = new ArrayList<>();
    static long[][] dp;
    static int n;
    public static void dfs2(int index, int parent){
        dp[index][1] = dp[parent][1] + (n - 2*dp[index][0]);

        for(int child:arrays.get(index)){
            if(child == parent) continue;
            // dp[child][1] = new Long(dp[index][1]) + new Long(n - 2*dp[index][0]);// dp[index][1] + (n - 2*dp[index][0]);
            // if(Long.compare(dp[child][1], 1) == 1) dfs2(child, index);
            dfs2(child, index);
        }
    }
    public static void dfs(int index,int parent){
        dp[index][0] = 1;
        for(int child:arrays.get(index)){
            if(child == parent) continue;
            dfs(child, index);
            dp[index][0] += dp[child][0];
            dp[index][1] += (dp[child][1] + dp[child][0]);
        }
        
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        n = fs.nextInt();
        //List<List<Integer>> arrays = new ArrayList<>();
        for(int i=0;i<=n;i++) arrays.add(new ArrayList<>());
        dp = new long[n + 1][2];
        for(int i=0;i<n-1;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            arrays.get(a).add(b);
            arrays.get(b).add(a);
        }
        dfs(1, -1);
        dp[0][1] = dp[1][1] + n;
        dfs2(1, 0);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(dp[i][1] + " ");
        }
        System.out.println(sb.toString());
        //System.out.println();
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
