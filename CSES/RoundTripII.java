package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class RoundTripII {
    static boolean found = false;
    static void dfs(List<List<Integer>> adjList,boolean[] visited, int node,LinkedHashSet<Integer> path){
        if(found) return;
        if(visited[node]){
            if(path.size() > 1 && path.contains(node)){
                found = true;
                StringBuilder sb = new StringBuilder();
                ArrayList<Integer> cityVisited = new ArrayList<>();
                ArrayList<Integer> pathList = new ArrayList<>(path);
                for(int i=pathList.size() -1;i>=0;i--){
                    cityVisited.add(pathList.get(i));
                    if(node == pathList.get(i)) break;
                }
                Collections.reverse(cityVisited);
                for(int city:cityVisited){
                    sb.append(city + " ");
                }
                sb.append(node);
                System.out.println(cityVisited.size() + 1 + "\n" + sb.toString());
            }
            return;
        }
        path.add(node);
        visited[node] = true;
        for(int i:adjList.get(node)){
            //if(i == parent) continue;
            dfs(adjList, visited, i, path);
            if(found) return;
        }
        path.remove(node);
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
           // adjList.get(q).add(p);
        }
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(visited, false);
        for(int i=1;i<=n && !found;i++){
            if(!visited[i]){
                LinkedHashSet<Integer> path = new LinkedHashSet<>();
                dfs(adjList, visited, i, path);
            }
        }
        if(!found){
            System.out.println("IMPOSSIBLE");
        }

    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
