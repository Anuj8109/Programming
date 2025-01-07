package CSES.Tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TreeMatching {
    static int result = 0; 
    static List<List<Integer>> arrays = new ArrayList<>();
    static boolean dfs(int index,int parent){
        
        boolean curr = false;
        for(int child:arrays.get(index)){
            if(child != parent){
                curr |= dfs(child, index);
            }
        }
        if(curr) result++;
        return !curr;
    }
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        //List<List<Integer>> arrays = new ArrayList<>();
        for(int i=0;i<=n;i++) arrays.add(new ArrayList<>());
        for(int i=0;i<n-1;i++){
            int a = fs.nextInt();
            int b = fs.nextInt();
            arrays.get(a).add(b);
            arrays.get(b).add(a);
        }
        dfs(1, -1);
        System.out.println(result);
    }
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }
 
}
