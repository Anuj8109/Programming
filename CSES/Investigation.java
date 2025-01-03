package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.*;
import java.util.StringTokenizer;

public class Investigation {
    public static class  Edge {
        int start;
        int end;
        int price;
        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.price = weight;
        }   
    }
    
    public static void dijkstra(ArrayList<Edge>[] adjLists, int from, int to){
        int mod = 1_000_000_000 + 7;
        long[] distance = new long[to + 1];
        Arrays.fill(distance, Long.MAX_VALUE>>1);
        distance[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        int[] minRouteCount = new int[to + 1];
        int[] maxRouteCount = new int[to + 1];
        pq.add(new long[]{from, 0});
        long[] count = new long[to + 1];
        count[from] = 1;
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int city = (int)curr[0];
            long price = (long) curr[1];
            if(city == to){
                System.out.println(price + " " + count[to] + " " + minRouteCount[to] + " " + maxRouteCount[to]);
                return;
            }

            for(Edge child:adjLists[city]){
                int end = child.end;
                int cost = child.price;
                if(distance[end] > price + cost){
                    distance[end] = price + cost;
                    minRouteCount[end] = minRouteCount[city] + 1;
                    maxRouteCount[end] = maxRouteCount[city] + 1;
                    count[end] = count[city];
                    pq.add(new long[]{end, distance[end]});
                }else if(distance[end] == price + cost){
                    count[end] = (count[end] + count[city]) % mod;
                    minRouteCount[end] = Math.min(minRouteCount[end], minRouteCount[city] + 1);
                    maxRouteCount[end] = Math.max(maxRouteCount[end], maxRouteCount[city] + 1);
                }
            }
        }
        System.out.println("No answer");
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int cities = fs.nextInt();
        int flightCount = fs.nextInt();

        ArrayList<Edge>[] adjLists = new ArrayList[cities + 1];
        for(int i=1;i<=cities;i++) adjLists[i] = new ArrayList<>();
        while (flightCount-->0) {
            int from = fs.nextInt();
            int to = fs.nextInt();
            int price = fs.nextInt();
            adjLists[from].add(new Edge(from, to, price));
        }
        dijkstra(adjLists, 1, cities);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
