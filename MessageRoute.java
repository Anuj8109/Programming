import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class MessageRoute {
    public static void main(String[] args){
        FastReader fastReader = new FastReader();
        int n = fastReader.nextInt();
        int m = fastReader.nextInt();
        List<Integer>[] graph = new ArrayList[n + 1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int a = fastReader.nextInt();
            int b = fastReader.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int[] count = new int[n + 1];
        int[] path = new int[n + 1];
        boolean br = false;
        while (!q.isEmpty() && !br) {
            int curr = q.poll();
            for(int child:graph[curr]){
                if(!visited[child]){
                    path[child] = curr;
                    count[child] = count[curr] + 1;
                    visited[child] = true;
                    q.add(child);
                }
                if(child == n){
                    br = true;
                    break;
                }
            }
        }
        if(!visited[n]){
            System.out.println("IMPOSSIBLE");
            return;
        }
        int dis = count[n] + 1;
        StringBuffer sb = new StringBuffer();
        sb.append(dis + "\n");
        int u = n;
        int[] ans = new int[dis];
        for(int i=0; i<dis;i++){
            ans[i] = u;
            u = path[u];
        }
        for(int i=dis-1;i>=0;i--){
            sb.append(ans[i] + " ");
        }
        System.out.println(sb.toString());
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
