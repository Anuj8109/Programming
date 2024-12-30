package CSES;
import java.io.*;
import java.util.*;

public class ShortestRoutesI {
    static void getShortestDistance(ArrayList<Edge>[] adjList, int start, long[] shortestDistance) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        shortestDistance[0] = 0;
        
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int city = curr.vertex;
            long dist = curr.distance;
            
            // Skip if we've found a better path already
            if (dist > shortestDistance[city]) continue;
            
            for (Edge edge : adjList[city]) {
                long newDist = dist + edge.weight;
                if (newDist < shortestDistance[edge.to]) {
                    shortestDistance[edge.to] = newDist;
                    pq.add(new Node(edge.to, newDist));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader fs = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int cities = fs.nextInt();
        int flights = fs.nextInt();
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] adjList = new ArrayList[cities];
        for (int i = 0; i < cities; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        // Build adjacency list
        while (flights-- > 0) {
            int start = fs.nextInt() - 1;
            int end = fs.nextInt() - 1;
            int len = fs.nextInt();
            if (end == 0) continue;
            adjList[start].add(new Edge(end, len));
        }
        
        long[] shortestDistance = new long[cities];
        Arrays.fill(shortestDistance, Long.MAX_VALUE);
        getShortestDistance(adjList, 0, shortestDistance);
        
        // Use StringBuilder for efficient string concatenation
        StringBuilder sb = new StringBuilder();
        for (long dist : shortestDistance) {
            sb.append(dist).append(' ');
        }
        out.println(sb);
        out.close();
    }
    
    // Static nested classes for better encapsulation and performance
    static class Edge {
        int to;
        int weight;
        
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static class Node implements Comparable<Node> {
        int vertex;
        long distance;
        
        Node(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Long.compare(distance, other.distance);
        }
    }
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}