package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class RoundTrip {
    static boolean found = false;
    static void dfs(List<List<Integer>> adjList,boolean[] visited, int node,int parent,ArrayList<Integer> path){
        if(found) return;
        if(visited[node]){
            if(path.size() > 2){
                found = true;
                StringBuilder sb = new StringBuilder();
                sb.append(node + " ");
                int count = 1;
                for(int i=path.size() -1;i>=0;i--){
                    count++;
                    sb.append(path.get(i) + " ");
                    if(node == path.get(i)) break;
                }
                System.out.println(count + "\n" +sb.toString());
            }
            return;
        }
        path.add(node);
        visited[node] = true;
        for(int i:adjList.get(node)){
            if(i == parent) continue;
            dfs(adjList, visited, i, node, path);
            if(found) return;
        }
        path.remove(path.size() - 1);
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            int p = fs.nextInt();
            int q = fs.nextInt();
            adjList.get(p).add(q);
            adjList.get(q).add(p);
        }
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        for(int i=1;i<=n && !found;i++){
            if(!visited[i]){
                ArrayList<Integer> path = new ArrayList<>();
                dfs(adjList, visited, i, -1, path);
            }
        }
        if(!found){
            System.out.println("IMPOSSIBLE");
        }

    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
