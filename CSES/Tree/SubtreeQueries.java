package CSES.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SubtreeQueries {
    
    static int[] values;
    static List<List<Integer>> adjList;
    static int[] start;
    static int[] end;
    static int timer = 1;
    public static void eulerTourIterative(int curr,int par,List<List<Integer>> adjList){

        Stack<int[]> s = new Stack<>();
        s.add(new int[]{curr,par,0});
        while (!s.isEmpty()) {
            int[] top = s.peek();
            int index = top[0];
            int parent = top[1];
            int state = top[2];
            if(state == 0){
                start[index] = timer++;
                s.pop();
                s.add(new int[]{index, parent, 1});
                for(int child:adjList.get(index)){
                    if(child != parent){
                        s.add(new int[]{child, index, 0});
                    }
                }
            }else{
                end[index] = timer;
                s.pop();
            }
            // start[index] = timer++;
            // end[index] = timer;
            // end[parent] = timer;
            // for(int child:adjList.get(index)){
            //     if(child != parent){
            //         s.add(new int[]{child, index});
            //     }
            // }
        }
    }
    public static void eulerTour(int curr,int par,List<List<Integer>> adjList){
        start[curr] = timer++;
        for(int i:adjList.get(curr)){
            if(i != par){
                eulerTour(i, curr,adjList);
            }
        }
        end[curr] = timer;
    }
    public static class BIT {
        long[] values;
        long[] sum;
        public BIT(int n){
            values = new long[n + 1];
            sum = new long[n + 1];
        }
        public void set(int index,int val){
            this.add(index, val - values[index]);
            values[index] = val;
        }
        public void add(int index,long diff){
            while(index < values.length){
                sum[index] += diff;
                index += (index & -index);
            }
        }

        public long sum(int index){
            long total = 0l;
            while (index > 0) {
                total += sum[index];
                index -= (index & (-index));
            }
            return total;
        }
    }
    public static void main(String[] args) {
        long sTime = System.currentTimeMillis();
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int q = fs.nextInt();
        values = new int[n + 1];
        start = new int[n + 1];
        end = new int[n + 1];
        for(int i=1;i<=n;i++){
            values[i] = fs.nextInt();
        }
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++) adjList.add(new ArrayList<>());

        for(int i=1;i<n;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        // eulerTour(1, -1, adjList);
        eulerTourIterative(1, 0, adjList);
        BIT bit = new BIT(n);
        for(int i=1;i<=n;i++) bit.set(start[i], values[i]);
        StringBuilder sb = new StringBuilder();
        while (q-->0) {
            int type = fs.nextInt();
            if(type == 1){
                int index = fs.nextInt();
                int val = fs.nextInt();
                bit.set(start[index], val);
            }else{
                int node = fs.nextInt();
                int endTime = end[node] - 1;
                int startTime = start[node] - 1;
                long endSum = bit.sum(endTime);
                long startSum = (startTime >= 0 ? bit.sum(startTime) : 0l);
                sb.append(endSum - startSum + "\n");
            }
        }
        System.out.println(sb.toString());
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - sTime;

        System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
