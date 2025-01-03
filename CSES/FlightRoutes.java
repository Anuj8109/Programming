package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FlightRoutes {
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

    public static void kShortestRoute(ArrayList<Edge>[] adjLists,int k){
        int cities = adjLists.length;
       // int[] count = new int[cities];
        PriorityQueue<Long>[] bestPrice = new PriorityQueue[cities];
        for(int i=1;i<cities;i++) bestPrice[i] = new PriorityQueue<>((a,b) -> (Long.compare(b, a)));
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> (Long.compare(a[1],b[1])));
        pq.add(new long[]{1,0});
        bestPrice[1].add(0l);
        List<Long> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int city = (int)curr[0];
            long price = curr[1];
            if(price > bestPrice[city].peek()) continue;
            if(city == cities - 1){
                result.add(price);
                if(result.size() == k) break;
            }
            for(Edge e:adjLists[city]){
                long sum = price + e.weight;
                if(bestPrice[e.end].size() < k){
                    pq.add(new long[]{e.end, sum});
                    bestPrice[e.end].add(sum);
                }else if(bestPrice[e.end].peek() > price + e.weight){
                    pq.add(new long[]{e.end, sum});
                    bestPrice[e.end].poll();
                    bestPrice[e.end].add(sum);
                }
                //if(count[e.end] < k) pq.add(new long[]{e.end, price + e.weight});
            }
        }
        StringBuilder sb = new StringBuilder();
        for(long p:result) sb.append(p + " ");
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        FastReader fs = new FastReader();
        int cities = fs.nextInt();
        int flightRoutes = fs.nextInt();
        int k = fs.nextInt();
        ArrayList<Edge>[] adjLists = new ArrayList[cities + 1];
        for(int i=1;i<=cities;i++){
            adjLists[i] = new ArrayList<>();
        }

        while (flightRoutes-- > 0) {
            int start = fs.nextInt();
            int end = fs.nextInt();
            int price = fs.nextInt();
            adjLists[start].add(new Edge(start, end, price));
        }

        kShortestRoute(adjLists, k);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
