package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tower {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int[] cubes = new int[n];
        for(int i=0;i<n;i++){
            cubes[i] = fs.nextInt();
        }
        TreeMap<Integer,Integer> topCube = new TreeMap<>();
        int count = 0;
        for(int i:cubes){
            Integer ceil = topCube.ceilingKey(i + 1);
            if(ceil == null){
                topCube.put(i, topCube.getOrDefault(i, 0) + 1);
                count++;
            }else{
                if(topCube.get(ceil) > 1)  topCube.put(ceil, topCube.get(ceil) - 1);
                else topCube.remove(ceil);
                // topCube.remove(ceil);
                topCube.put(i, topCube.getOrDefault(i, 0) + 1);
            }
        }
        // int x = 0;
        // for(int i:topCube.keySet()){
        //     x += topCube.get(i);
        // }
        // System.out.println(x);
        System.out.println(count);

    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
