package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Projects {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        Long[][] projects = new Long[n][3];
        //List<TreeMap<Integer,Integer>> dp = new ArrayList<>();
        for(int i=0;i<n;i++){
            //System.out.print(i + " ");
            projects[i][0] = fs.nextLong();
            projects[i][1] = fs.nextLong();
            projects[i][2] = fs.nextLong();
            //dp.add(new TreeMap<>());
        }
       // System.out.println("HII");
        Comparator<Long[]> comp = (a,b) -> (Long.compare(a[1], b[1]));
        Arrays.sort(projects,comp);
        TreeMap<Long,Long> prev = new TreeMap<>();
        prev.put(0l, 0l);
        long result = 0l;
        for(int i=0;i<n;i++){
            long startTime = projects[i][0];
            long endTime = projects[i][1];
            long reward = projects[i][2];
            result = Math.max(result, prev.get(prev.floorKey(startTime - 1)) + reward);
            prev.put(endTime, result);
        }
        System.out.println(result);


    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
