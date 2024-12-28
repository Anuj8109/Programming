package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class IncreasingSubsequence {
    
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int[] elements = new int[n];
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        }

        TreeMap<Integer,Integer> map = new TreeMap<>();
        map.put(elements[0], 1);
        int maxi = 1;
        for(int i=1;i<n;i++){
            Integer x = map.ceilingKey(elements[i]);
            if(x != null){
                int len = map.get(x);
                map.remove(x);
                map.put(elements[i], len);
            }else{
                x = map.floorKey(elements[i]);
                map.put(elements[i],map.get(x) + 1);
                maxi = Math.max(map.get(elements[i]), maxi);
            }
        }
        System.out.println(maxi);

    }

    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
