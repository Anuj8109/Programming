package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TasksandDeadlines {

    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int[][]  tasks = new int[n][2];
        for(int i=0;i<n;i++){
            tasks[i][0] = fs.nextInt();
            tasks[i][1] = fs.nextInt();
        }
        Comparator<int[]> comp = (a,b) -> a[0] - b[0];
        Arrays.sort(tasks,comp);
        long result = 0;
        long currTime = 0;
        for(int[] task:tasks){
            currTime += task[0];
            result += task[1] - currTime;
        }
        System.out.println(result);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}