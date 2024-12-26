package CSES;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SubarrayDistinctValues {
    public static void main(String[] args){
        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int k = fs.nextInt();
        int[] elements = new int[n];
        
        for(int i=0;i<n;i++){
            elements[i] = fs.nextInt();
        } 

        HashMap<Integer,Integer> freq = new HashMap<>();
        int start = 0;
        int curr = 0;
        long result = 0;
        while(curr < n){
            freq.put(elements[curr], freq.getOrDefault(elements[curr], 0) + 1);
            while (freq.size() > k) {
                freq.put(elements[start], freq.get(elements[start]) - 1);
                if(freq.get(elements[start]) == 0){
                    freq.remove(elements[start]);
                }
                start++;
            }
            result += (curr - start + 1);
            curr++;
        }
        System.out.println(result);
    }
    
    static class FastReader { BufferedReader br; StringTokenizer st; public FastReader() { br = new BufferedReader( new InputStreamReader(System.in)); } String next() { while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { e.printStackTrace(); } } return st.nextToken(); } int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } catch (IOException e) { e.printStackTrace(); } return str; } }

}
