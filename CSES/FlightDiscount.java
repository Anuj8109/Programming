package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class FlightDiscount {
    public static class Edge {
        public int start;
        public int end;
        public int cost;
        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    public static long[] dijkstra(ArrayList<Edge>[] adjLists, int start){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> 
                    (Long.compare(a[1],b[1])));
        pq.add(new long[]{start,0});
        int city = adjLists.length;
        long[] costs = new long[city + 1];
        // boolean[] visited = new boolean[city + 1];
        Arrays.fill(costs, Long.MAX_VALUE >> 1);
        costs[start] = 0;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int currCity = (int)curr[0];
            long price = curr[1];
            if(costs[currCity] < price) continue;
            costs[currCity] = price;
            for(Edge e:adjLists[currCity]){
                if(costs[currCity] + e.cost < costs[e.end]){
                    costs[e.end] = costs[currCity] + e.cost;
                    pq.add(new long[]{e.end, costs[e.end]});
                }
            }
        }
        return costs;
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int city = fs.nextInt();
        int flight = fs.nextInt();
        ArrayList<Edge>[] adjList = new ArrayList[city + 1];
        ArrayList<Edge>[] adjList1 = new ArrayList[city + 1];
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i=1;i<=city;i++){
            adjList[i] = new ArrayList<>();
            adjList1[i] = new ArrayList<>();
        }
        
        while (flight -- > 0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            int c = fs.nextInt();
            edges.add(new Edge(a, b, c));
            adjList[a].add(new Edge(a, b, c));
            adjList1[b].add(new Edge(b, a, c));
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> 
                    (Long.compare(a[1],b[1])));
        pq.add(new long[]{0,0});
        long[] startCost = dijkstra(adjList, 1);
        long[] endCost = dijkstra(adjList1, city);
        long totalCost = startCost[city];
        for(Edge edge:edges){
            long total = startCost[edge.start] + endCost[edge.end] + edge.cost/2;
            if(totalCost > total){
                totalCost = total;
            }
        }
        // for(Edge i:adjList[1]){
        //     if(totalCost > startCost[i.start] + endCost[i.end] + i.cost/2){
        //         totalCost = startCost[i.start] + endCost[i.end] + i.cost/2;
        //     }
        // }
        System.out.println(totalCost);
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
