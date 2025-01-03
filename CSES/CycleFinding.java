package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class CycleFinding {

    public static class  Edge {
        int start;
        int end;
        int weight;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }   
    }

    public static void bellmonFord(List<Edge>[] adLists){
        int n = adLists.length;
        long[] distance = new long[n];
        int[] parent = new int[n];
        Arrays.fill(distance, Long.MAX_VALUE>>1);
        Arrays.fill(parent, -1);
        distance[1] = 0;
        parent[1] = 1;
        int x = -1;
        for(int i=1;i<n;i++){
            x = -1;
            for(List<Edge> edges:adLists){
                for(Edge edge:edges){
                    if(distance[edge.start] + edge.weight < distance[edge.end]){
                        x = edge.end;
                        distance[edge.end] = distance[edge.start] + edge.weight;
                        parent[edge.end] = edge.start;
                    }
                }
            }
        }
        if(x == -1){
            System.out.println("NO");
            return;
        }

        //System.out.println("YES");

        int y = x;
        for(int i=1;i<n;i++){
            y = parent[y];
        }
        List<Integer> path = new ArrayList<>();
        for(int i=y;;i=parent[i]){
            path.add(i);
            if(i == y && path.size() > 1){
                break;
            }
        }
        Collections.reverse(path);
        StringBuilder sb = new StringBuilder();
        for(int i:path) sb.append(" " + i);
        System.out.print("YES\n" + sb.toString().substring(1));
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        List<Edge>[] adjList = new ArrayList[n + 1];
        for(int i=0;i<=n;i++){
            adjList[i] = new ArrayList<Edge>();
        }
        while (m-- > 0) {
            int start = fs.nextInt();
            int end = fs.nextInt();
            int weight = fs.nextInt();
            adjList[start].add(new Edge(start, end, weight));
            //adjList[end].add(new Edge(end, start, weight));
        }
        bellmonFord(adjList);
    }
    
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
