package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class CourseSchedule {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int courses = fs.nextInt();
        int requirements = fs.nextInt();
        int[] topocount = new int[courses + 1];
        ArrayList<Integer>[] adjLists = new ArrayList[courses + 1];
        for(int i=1;i<=courses;i++){
            adjLists[i] = new ArrayList<>();
        }
        while (requirements-->0) {
            int a = fs.nextInt();
            int b = fs.nextInt();
            adjLists[a].add(b);
            topocount[b]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=courses;i++){
            if(topocount[i] == 0) q.add(i);
        }
        List<Integer> completeOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int curr = q.poll();
            completeOrder.add(curr);
            for(int child:adjLists[curr]){
                topocount[child]--;
                if(topocount[child] == 0) q.add(child);
            }
        }

        if(completeOrder.size() < courses){
            System.out.println("IMPOSSIBLE");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int ele:completeOrder) sb.append(ele + " ");
        System.out.println(sb.toString());
    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
