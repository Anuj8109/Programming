package CSES.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CompanyQueriesI {
    // static List<List<Integer>> arrays = new ArrayList<>();
    static int[] parent;
    public static void main(String[] main){

        //Input 
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int q = fs.nextInt();
        int log = 0;
        boolean[] visited = new boolean[n + 1];
        while (1 << (log + 1) <= n ) {
            log++;
        }
        parent = new int[n + 1];
        parent[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        for(int i=2;i<=n;i++){
            parent[i] = fs.nextInt();
            if(!visited[parent[i]]){
                queue.add(parent[i]);
                visited[parent[i]] = true;
            }
        }
        for(int i=2;i<=n;i++){
            if(!visited[i]) queue.add(i);
        }


        int[][] up = new int[n + 1][log + 1];

        //Binary Lifting
        while (!queue.isEmpty()) {
            int i = queue.poll();
            up[i][0] = parent[i];
            for(int j=1;j<=log;j++){
                up[i][j] = up[up[i][j-1]][j-1];
            }
        }
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int x = fs.nextInt();
            int k = fs.nextInt();
            for(int i=0;i<=log && x != 0;i++){
                if((k & (1 << i)) > 0){
                    x = up[x][i];
                }
            }
            sb.append( (x == 0 ? -1 : x)+ "\n");
        }
        System.out.println(sb.toString());
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

} 