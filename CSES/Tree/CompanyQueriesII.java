package CSES.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CompanyQueriesII {
    static int[] parent;
    static int[][] up;
    static int[] depth;

    static int findKthEle(int a,int k,int[][] up){
        int log = up[0].length;
        
        for(int i=0;i<log && a!=0;i++){
            if(((1 << i) & k )> 0){
                a = up[a][i];
            }
        }
        return a;
    }
    static int findLCA(int a,int b,int[][] up, int[] depth){
        if(depth[a] > depth[b]) return findLCA(b, a,up,depth);

        b = findKthEle(b, depth[b] - depth[a],up);
        if(a == b) return a;
        for(int i=up[0].length-1;i>=0;i--){
            if(up[a][i] != up[b][i]){
                a = up[a][i];
                b = up[b][i];
            }
        }
        return up[a][0];
    }
    static void query(int q,FastReader fs,int[][] up, int[] depth){
        //FastReader fs = new FastReader();
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            if(depth[a] > depth[b]){
                int temp = a;
                a = b;
                b = temp;
            }
            b = findKthEle(b, depth[b] - depth[a],up);
            if(a == b){
                sb.append(a + "\n");
                continue;
            }
            for(int i=up[0].length-1;i>=0;i--){
                if(up[a][i] != up[b][i]){
                    a = up[a][i];
                    b = up[b][i];
                }
            }
            sb.append(findLCA(a, b,up,depth) + "\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] main){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int q = fs.nextInt();
        int log = 0;
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
       
        parent[1] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (1 << (log + 1) <= n ) {
            log++;
        }
        int[][] up = new int[n + 1][log + 1];
        // for(int p=2;p<n;p++){
        //     Arrays.fill(up[p], 0);
        // }
        int[] depth = new int[n + 1];
        for(int i=2;i<=n;i++){
            up[i][0] = fs.nextInt();
            depth[i] = depth[up[i][0]] + 1;
            // parent[i] = fs.nextInt();
            // if(!visited[parent[i]]){
            //     queue.add(parent[i]);
            //     visited[parent[i]] = true;
            // }
        }
        // for(int i=2;i<=n;i++){
        //     if(!visited[i]) queue.add(i);
        // }

        

        
        
        depth[0] = 0;
        for(int i=1;i<=log;i++){
            for(int j=2;j<=n;j++){
                if(up[j][i - 1] != 0){
                    up[j][i] = up[ up[j][i - 1] ][i - 1];
                }
            }
        }
        // while (!queue.isEmpty()) {
        //     int i = queue.poll();
        //     up[i][0] = parent[i];
        //     depth[i] = depth[parent[i]] + 1;
        //     for(int j=1;j<=log;j++){
        //         up[i][j] = up[ up[i][j - 1] ][j-1]; 
        //     }
        // }
        query(q,fs,up,depth);
        
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
