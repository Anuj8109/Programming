package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class GameRoutes {

    public static void topo(ArrayList<Integer>[] adjLists, int[] topoFreq,int start){
        int len = adjLists.length;
        int mod = 1_000_000_000 + 7;
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        for(int i=1;i<len -1;i++){
            if(topoFreq[i] == 0) q.add(i);
        }
        long[] count = new long[len];
        Arrays.fill(count, 0);
        count[start] = 1;
        while (!q.isEmpty()) {
            int curr = q.poll();
            for(int child:adjLists[curr]){
                topoFreq[child]--;
                count[child] = (count[child] + count[curr]) % mod;
                if(topoFreq[child] == 0){
                   q.add(child); 
                }
            }
        }
        System.out.println(count[1]);
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        ArrayList<Integer>[] adjLists = new ArrayList[n + 1];
        for(int i=1;i<=n;i++) adjLists[i] = new ArrayList<>();
        int[] count = new int[n + 1];
        while (m-->0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adjLists[b].add(a);
            count[a]++;
        }
        topo(adjLists, count, n);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
